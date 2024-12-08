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
<title>Register Page</title>

<style>
  body {
    background-color: lightgreen;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  .container {
    max-width: 600px;
    margin: 50px auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  }

  h1 {
    color: #2c3e50;
    text-align: center;
    margin-bottom: 20px;
  }

  .form-group {
    margin-bottom: 15px;
    text-align: center;
  }

  .form-group label {
    display: block;
    font-size: 14px;
    color: #2c3e50;
    margin-bottom: 5px;
  }

  .form-group input {
    width: 90%;
    max-width: 400px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
  }

  .error-message {
    color: red;
    text-align: center;
    margin-bottom: 15px;
  }

  .form-footer {
    text-align: center;
    margin-top: 20px;
  }

  .form-footer a {
    text-decoration: none;
    color: #3498db;
    font-weight: bold;
    margin-left: 10px;
  }

  .form-footer a:hover {
    text-decoration: underline;
  }

  input[type="submit"] {
    background-color: #27ae60;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    font-size: 14px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #218c53;
  }
</style>
</head>
<body>
  <div class="container">
    <h1>Register Page</h1>
    <form action="Reg" method="post">
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" name="txtname" id="name" placeholder="Enter your name">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="text" name="txtemail" id="email" placeholder="Enter your email">
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
      <div class="form-footer">
        <input type="submit" value="Register">
        <a href="Login.jsp">Login</a>
      </div>
    </form>
  </div>
</body>
</html>