import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EditStudentCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email_id");

        String category = request.getParameter("category");
        String rollNo = request.getParameter("roll_no");

        Connection con = null;
        PreparedStatement pstmt = null;

        boolean isEdited = false;

        if(emailId.equals("admin")){
            try{
                con = DBConnection.getConnection();
                String sql = "update table (student) set category = ? where roll_no = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,category);
                pstmt.setString(2,rollNo);

                int result = pstmt.executeUpdate();

                if(result > 0){
                    isEdited = true;
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            if(isEdited){
                request.setAttribute("edit_message","edit_successful");
            } else {
                request.setAttribute("edit_message","edit_unsuccessful");
            }

            request.getRequestDispatcher("#").include(request,response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
    }
}
