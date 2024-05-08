<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/login.css" type="text/css" />
    <title>IoTBay - Login</title>
  </head>
  
  <% String login_emailPasswordErr = (String) session.getAttribute("login_emailPasswordErr"); %>

  <body>
    <div class="left-div">
      <div class="login-div">
        <div class="logo-div">
          <a href="/index.jsp"
            ><img src="/assets/logo.png" alt="logo" class="logo"
          /></a>
        </div>
        <div class="welcome-text-div">
          <p>Welcome back!</p>
          <p>Login to get the most from IoTBay</p>
        </div>
        <form method="post" action="/LoginServlet">
          <div class="input-div">
            <% if(login_emailPasswordErr != null) { %>
              <p><%=login_emailPasswordErr%></p>
            <% } %>
            <input type="email" name="email" id="email" placeholder="Email" required/>
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Password"
              required
            />
          </div>
          <div class="submit-div">
            <input type="submit" value="Login" />
            <p>Don't have an account? <a href="/register.jsp">Register</a></p>
          </div>
        </form>
      </div>
    </div>

    <div class="right-div">
      <img src="https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?q=80&w=2565&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="mouse wallpaper" />
    </div>
  </body>
</html>
