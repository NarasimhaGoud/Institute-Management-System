<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>

<style>
  body {
    margin: 0;
    padding: 0;
    background: linear-gradient(to right, #6a11cb, #2575fc);
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #fff;
  }

  .login-container {
    background: rgba(255, 255, 255, 0.1);
    padding: 30px 20px;
    border-radius: 10px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
    width: 100%;
    max-width: 400px;
    text-align: center;
  }

  .login-container h1 {
    margin-bottom: 20px;
    font-size: 24px;
    font-weight: bold;
    color: #fff;
  }

  .form-group {
    margin-bottom: 20px;
    text-align: left;
  }

  .form-group label {
    display: block;
    margin-bottom: 5px;
    font-size: 14px;
    font-weight: bold;
  }

  .form-group input {
    width: calc(100% - 20px);
    max-width: 300px;
    padding: 10px;
    border: none;
    border-radius: 5px;
    font-size: 14px;
  }

  .form-group input:focus {
    outline: none;
    box-shadow: 0 0 5px rgba(102, 153, 255, 0.8);
  }

  .error-message {
    color: #ff4d4d;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .login-container input[type="submit"] {
    background: #2575fc;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    font-size: 14px;
    cursor: pointer;
    margin-top: 10px;
    transition: background 0.3s;
  }

  .login-container input[type="submit"]:hover {
    background: #1c5ac6;
  }

  .login-container a {
    margin-left: 15px;
    font-size: 14px;
    color: #fff;
    text-decoration: none;
  }

  .login-container a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>
  <div class="login-container">
    <h1>Login Page</h1>
    <form action="Log" method="post">
      <div class="form-group">
        <label for="useremail">User Email</label>
        <input type="text" name="txtuseremail" id="useremail" placeholder="Enter your email">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="txtpassword" id="password" placeholder="Enter your password">
      </div>
      <div class="error-message">
        <% if (request.getAttribute("message") != null) { %>
          <%= request.getAttribute("message") %>
        <% } %>
      </div>
      <input type="submit" value="Login">
      <a href="register2.jsp">Sign Up</a>
    </form>
  </div>
</body>
</html>

	