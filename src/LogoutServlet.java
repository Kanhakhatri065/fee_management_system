import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toLogout = request.getParameter("logout_request");

        if(toLogout.equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request,response);
        } else {
            System.out.println("Could not logout");
            request.getRequestDispatcher("home.jsp").include(request,response);
        }
    }
}
