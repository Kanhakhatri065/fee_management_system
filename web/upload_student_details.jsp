<%--
  Created by IntelliJ IDEA.
  User: Kanha Khatri
  Date: 22-12-2019
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fee Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Vertical (basic) form</h2>
    <form action="UploadStudentServlet" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label >Roll No:</label>
            <input type="text" class="form-control" id="roll_no" placeholder="Enter Roll Number" name="roll_no">
        </div>
        <div class="form-group">
            <label>Student Name:</label>
            <input type="text" class="form-control" placeholder="Enter Student Name" name="student_name">
        </div>
        <div class="form-group">
            <label>Branch:</label>
            <input type="text" class="form-control" placeholder="Enter Branch" name="branch">
        </div>
        <div class="form-group">
            <label>Email:</label>
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
        <div class="dropdown">
            <label>Category:</label>
            <input type="text" class="form-control" name="category" value="Above 5 lac per annum">
            <input type="text" class="form-control" name="category" value="Below 5 lac per annum">
            <input type="text" class="form-control" name="category" value="Below 1 lac per annum">
            <input type="text" class="form-control" name="category" value="SC/ST">
        </div>
        <div class="form-group">
            <label>Fee Due Date:</label>
            <input type="date" class="form-control" name="fee_due_date">
        </div>
        <div class="form-group">
            <label>Student Photo:</label>
            <input type="image" class="form-control" name="student_photo">
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="text" class="form-control" placeholder="Enter Fee Amount" name="fee_amount">
        </div>
        <button type="submit" class="btn btn-default">Upload</button>
    </form>
</div>
</body>
</html>
