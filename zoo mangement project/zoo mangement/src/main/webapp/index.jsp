<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  <style>
    /* Add some basic styles to improve appearance */
    body {
      font-family: Arial, sans-serif;
    }
    form {
      max-width: 300px;
      margin: 40px auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
      display: block;
      margin-bottom: 10px;
    }
    input[type="text"], input[type="password"] {
      width: 100%;
      height: 40px;
      margin-bottom: 20px;
      padding: 10px;
      border: 1px solid #ccc;
    }
    input[type="submit"] {
      background-color: #4CAF50;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    input[type="submit"]:hover {
      background-color: #3e8e41;
    }
  </style>
</head>
<body>
  <form action="ControllerServlet" method="post">
    <fieldset>
      <legend>Login</legend>
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" aria-label="Enter your name">
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" aria-label="Enter your password">
      <br>
      <input type="submit" value="Login">
    </fieldset>
  </form>
</body>
</html>