<%--
  Created by IntelliJ IDEA.
  User: kabir
  Date: 10/01/20
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
html>
<head>
    <title>Fee Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">

    <form action="EditStudentCategoryServlet" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>New Email Id:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email_id">
        </div>
        <div class="form-group">
            <label>Phone Number:</label>
            <input type="text" class="form-control" placeholder="Enter Phone Number" name="phone_no">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label>Student Photo:</label>
            <input type="image" class="form-control" name="student_photo">
        </div>
        <div class="form-group">
            <label>Fee Amount :</label>
            <input type="text" class="form-control" placeholder="Enter Fee Amount" name="fee_amount">
        </div>
        <button type="submit" class="btn btn-default">Update</button>
    </form>
</div>
</body>
</html>
