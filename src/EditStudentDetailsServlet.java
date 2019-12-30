import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class EditStudentDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String)session.getAttribute("email_id");

        ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> editUser = null;


        String updateEmailId = editUser.get(0).getString();
        String phoneNo = editUser.get(1).getString();
        String password = editUser.get(2).getString();
        InputStream studentPhoto = editUser.get(3).getInputStream();

        Connection con = null;
        PreparedStatement pstmt = null;

        boolean isEdited = false;


            try{
                con = DBConnection.getConnection();
                String sql = "";
                if(updateEmailId.equals(emailId) && studentPhoto == null) {
                    sql = "update student set phone_no = ?, password = ? where email_id = ?";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, phoneNo);
                    pstmt.setString(2, password);
                    pstmt.setString(3, emailId);
                } else if(updateEmailId.equals(emailId) && studentPhoto != null) {
                    sql = "update student set phone_no = ?,password = ?, student_photo = ? where email_id = ?";

                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, phoneNo);
                    pstmt.setString(2, password);
                    pstmt.setBinaryStream(3, studentPhoto, (int) editUser.get(3).getSize());
                    pstmt.setString(4,emailId);
                } else if(updateEmailId.equals(emailId) == false  && studentPhoto == null){
                    sql = "update student set email_id = ?,phone_no = ?,password = ? where email_id = ?";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1,updateEmailId);
                    pstmt.setString(2,phoneNo);
                    pstmt.setString(3,password);
                    pstmt.setString(4,emailId);
                } else if(updateEmailId.equals(emailId) == false && studentPhoto != null){
                    sql = "update student set email_id = ?,phone_no = ?,password = ?,student_photo = ? where email_id = ?";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1,updateEmailId);
                    pstmt.setString(2,phoneNo);
                    pstmt.setString(3,password);
                    pstmt.setBinaryStream(4,studentPhoto,(int)editUser.get(3).getSize());
                }

                int result = pstmt.executeUpdate();

                if(result > 0){
                    isEdited = true;
                }

            } catch (Exception e){
                e.printStackTrace();
            }

            if(isEdited){
                request.setAttribute("edit_message","updation successful");
            } else {
                request.setAttribute("edit_message","updation unsuccessful");
            }

            request.getRequestDispatcher("#").include(request,response);
    }
}
