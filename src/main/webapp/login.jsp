<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/login.css" />
    <title>IoTBay - Login</title>
  </head>
  <body>
    <div class="left-div">
      <div class="login-div">
        <div class="logo-div">
          <a href="/homepage.jsp"
            ><img src="/assests/logo.png" alt="logo" class="logo"
          /></a>
        </div>
        <div class="welcome-text-div">
          <p>Welcome back!</p>
          <p>Login to get the most from IoTBay</p>
        </div>
        <form action="/dashboard.jsp">
          <div class="input-div">
            <input type="email" name="email" id="email" placeholder="Email" />
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Password"
            />
            <a href="/forgot_password.jsp">Forgot password?</a>
          </div>
          <div class="submit-div">
            <input type="submit" value="Login" />
            <p>Don't have an account? <a href="/register.jsp">Register</a></p>
          </div>
        </form>
      </div>
    </div>

    <div class="right-div">
      <img src="/assests/wallpaper.jpeg" alt="mouse wallpaper" />
    </div>
  </body>
</html>
