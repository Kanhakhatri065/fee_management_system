<%--
  Created by IntelliJ IDEA.
  User: Kanha Khatri
  Date: 21-12-2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login V19</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--===============================================================================================-->
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="css/util.css">
  <link rel="stylesheet" type="text/css" href="css/main.css">
  <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
  <div class="container-login100">
    <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
      <form class="login100-form validate-form">
					<span class="login100-form-title p-b-33">
						FEE MANAGEMENT SYSTEM Login
					</span>

        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
          <input class="input100" type="text" name="email_id" placeholder="Email">
          <span class="focus-input100-1"></span>
          <span class="focus-input100-2"></span>
        </div>

        <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
          <input class="input100" type="password" name="password" placeholder="Password">
          <span class="focus-input100-1"></span>
          <span class="focus-input100-2"></span>
        </div>

        <div class="container-login100-form-btn m-t-20">
          <button class="login100-form-btn">
            Sign in
          </button>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="js/main.js"></script>

</body>
</html>
