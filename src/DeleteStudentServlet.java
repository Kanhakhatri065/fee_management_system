import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email_id");

        String rollNo = request.getParameter("roll_no");

        Connection con = null;
        PreparedStatement pstmt = null;

        boolean isDeleted = false;

        if(emailId.equals("admin")){
            try{
                con = DBConnection.getConnection();
                String sql = "delete from student where roll_no = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,rollNo);

                int result = pstmt.executeUpdate();

                if(result > 0){
                    isDeleted = true;
                }

            } catch (Exception e){
                e.printStackTrace();
            }

            if(isDeleted) {
                request.setAttribute("delete_message","delete_successful");
            } else {
                request.setAttribute("delete_message","delete_unsuccessful");
            }
            request.getRequestDispatcher("#").include(request,response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
    }
}
