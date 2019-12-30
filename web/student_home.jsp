<%--
  Created by IntelliJ IDEA.
  User: Kanha Khatri
  Date: 26-12-2019
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Student" %>
<html>
<head>
    <title>FEE MANAGEMENT SYSTEM</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<%
    HttpSession httpSession = request.getSession();
    String userEmail = (String) httpSession.getAttribute("email_id");

    if(!userEmail.equals("admin")){
        Student student = (Student) request.getAttribute("student_details");

%>
<body>
    <fieldset>
        <legend>Student Details</legend>
            Rol`
    </fieldset>
</body>
</html>
