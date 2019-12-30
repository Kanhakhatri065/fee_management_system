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

public class SearchStudentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email_id");

        String query = request.getParameter("search_query");
        String searchCategory = request.getParameter("search_category");

        List<Student> studentList = new ArrayList<>();

        Connection con = null;
        PreparedStatement pstmt = null;

        boolean isSearched = false;

        if(emailId.equals("admin")){
            try{
                con = DBConnection.getConnection();
                String sql = "";
                if(searchCategory.equals("roll_no")){
                    sql = "select * from student where roll_no = ?";
                } else if(searchCategory.equals("student_name")){
                    sql = "select * from student where student_name = ?";
                } else if(searchCategory.equals("email_id")){
                    sql = "select * from student where email_id = ?";
                }

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,query);

                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                    isSearched = true;
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

            if(isSearched){
                request.setAttribute("student_list",studentList);
                request.setAttribute("search_message","search_successful");
            } else {
                request.setAttribute("search_message","search_unsucessful");
            }
            request.getRequestDispatcher("#").include(request,response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
    }
}
