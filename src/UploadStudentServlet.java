import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class UploadStudentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> addUser = null;
        try {
            addUser = sfu.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        String rollNo = addUser.get(0).getString();
        String studentName = addUser.get(1).getString();
        String branch = addUser.get(2).getString();
        String emailId = addUser.get(3).getString();
        String phoneNo = addUser.get(4).getString();
        String password = addUser.get(5).getString();
        String category = addUser.get(6).getString();
        InputStream studentPhoto = addUser.get(7).getInputStream();
        long feeDueDate = Long.parseLong(addUser.get(8).getString());
        float feeAmount = Float.parseFloat(addUser.get(9).getString());

        boolean isDetailsUploaded = false;

        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = DBConnection.getConnection();
            String sql = "insert into table student(id,roll_no,student_name,) values (id_seq.nextval,?,?,?,?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,rollNo);
            pstmt.setString(2,studentName);
            pstmt.setString(3,branch);
            pstmt.setString(4,emailId);
            pstmt.setString(5,phoneNo);
            pstmt.setString(6,password);
            pstmt.setString(7,category);
            pstmt.setBinaryStream(8,studentPhoto,(int)addUser.get(7).getSize());
            pstmt.setDate(9, (java.sql.Date) new Date(feeDueDate));
            pstmt.setFloat(10,feeAmount);

            int result = pstmt.executeUpdate();

            if(result > 0){
                isDetailsUploaded = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if(isDetailsUploaded){
            request.setAttribute("upload_message","upload successful");
        } else {
            request.setAttribute("upload_message","upload unsuccessful");
        }
        request.getRequestDispatcher("#").include(request,response);
    }
}
