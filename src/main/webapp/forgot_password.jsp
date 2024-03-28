<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/forgot_password.css" />
    <title>IoTBay - Forgot Password</title>
  </head>
  <body>
    <div class="left-div">
      <div class="forgot-password-div">
        <div class="logo-div">
          <a href="/index.jsp"
            ><img src="/assests/logo.png" alt="logo" class="logo"
          /></a>
        </div>
        <div class="welcome-text-div">
          <p>Reset your password</p>
        </div>
        <form action="/dashboard.jsp">
          <div class="input-div">
            <input
              type="text"
              name="firstName"
              id="firstName"
              placeholder="First Name"
            />
            <input type="email" name="email" id="email" placeholder="Email" />
          </div>
          <div class="submit-div">
            <input type="submit" value="Reset Password" />
            <p>Remember your password? <a href="/login.jsp">Login</a></p>
          </div>
        </form>
      </div>
    </div>

    <div class="right-div">
      <img src="/assests/wallpaper.jpeg" alt="mouse wallpaper" />
    </div>
  </body>
</html>
