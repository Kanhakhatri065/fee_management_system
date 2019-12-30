import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailId = request.getParameter("email_id");
        String password = request.getParameter("password");

        boolean isLoggedIn = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = DBConnection.getConnection();
            String sql = "select password from student where email_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,emailId);

            ResultSet rs = pstmt.executeQuery();

            if(password.equals(rs.getString("password"))){
                isLoggedIn = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if(isLoggedIn){
            HttpSession session = request.getSession();
            session.setAttribute("email_id",emailId);
            request.getRequestDispatcher("home.jsp").include(request,response);
        } else {
            System.out.println("could not login");
            request.setAttribute("login_failed_message","email id or password may be incorrect");
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
    }
}
