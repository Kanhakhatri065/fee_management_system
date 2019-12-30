import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class ShowStudentDetailsServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email_id");

        List<Student> studentList = new ArrayList<Student>();
        Connection con = null;
        PreparedStatement pstmt = null;

        if(emailId.equals("admin")){
            try{
                con = DBConnection.getConnection();
                String sql = "select * from student";
                pstmt = con.prepareStatement(sql);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()){
                Student student = new Student();
                student.setId(Long.parseLong(rs.getString("id")));
                student.setStudentName(rs.getString("student_name"));
                student.setRollNo(rs.getString("roll_no"));
                student.setBranch(rs.getString("branch"));
                student.setEmailId(rs.getString("email_id"));
                student.setCategory(rs.getString("category"));
                student.setFeeAmount(Float.parseFloat(rs.getString("fee_amount")));
                Blob studentPhoto = rs.getBlob("student_photo");
                InputStream is = studentPhoto.getBinaryStream();
                student.setStudentPhoto(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                student.setFeeDueDate((Date) sdf.parse(rs.getString("fee_due_date")));

                studentList.add(student);
            }
            } catch (Exception e){
                e.printStackTrace();
            }

            request.setAttribute("student_list",studentList);
            request.getRequestDispatcher("#").include(request,response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
    }
}
