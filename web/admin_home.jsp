<%--
  Created by IntelliJ IDEA.
  User: kabir
  Date: 10/01/20
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    HttpSession session = request.getSession();
    String emailId = (String) session.getAttribute("email_id");

    if(!emailId.equals("admin")){
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
%>
