<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/register.css" />
    <title>IoTBay - Register</title>
  </head>
  <body>
    <div class="left-div">
      <div class="register-div">
        <div class="logo-div">
          <a href="/index.jsp"
            ><img src="/assests/logo.png" alt="logo" class="logo"
          /></a>
        </div>
        <div class="welcome-text-div">
          <p>Nice to meet you!</p>
          <p>Create an account to get the most from IoTBay</p>
        </div>
        <form action="/dashboard.jsp">
          <div class="input-div">
            <input
              type="text"
              name="firstName"
              id="firstName"
              placeholder="First Name"
              required
            />
            <input
              type="text"
              name="lastName"
              id="lastName"
              placeholder="Last Name"
              required
            />
            <input type="email" name="email" id="email" placeholder="Email" required/>
            <input
              type="password"
              name="password1"
              id="password1"
              placeholder="Password"
              required
            />
            <input
              type="password"
              name="password2"
              id="password2"
              placeholder="Confirm Password"
              required
            />
          </div>
          <div class="submit-div">
            <input type="submit" value="Register" />
            <p>Don't have an account? <a href="/login.jsp">Login</a></p>
          </div>
        </form>
      </div>
    </div>

    <div class="right-div">
      <img src="/assests/wallpaper.jpeg" alt="mouse wallpaper" />
    </div>
  </body>
</html>

