<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/layout.css" />
    <link rel="stylesheet" href="css/register.css">
    <title>IoTBay - Register</title>
  </head>

  <% String register_givenNameErr = (String) session.getAttribute("register_givenNameErr"); %>
  <% String register_familyNameErr = (String) session.getAttribute("register_familyNameErr"); %>
  <% String register_emailErr = (String) session.getAttribute("register_emailErr"); %>
  <% String register_passwordErr = (String) session.getAttribute("register_passwordErr"); %>
  <% String register_phoneErr = (String) session.getAttribute("register_phoneErr"); %>
  <% String register_dobErr = (String) session.getAttribute("register_dobErr"); %>
  <% String register_email_exists = (String) session.getAttribute("register_email_exists"); %>

  <body>
    <div class="left-div">
      <div class="register-div">
        <div class="logo-div">
          <a href="/index.jsp"
            ><img src="/assets/logo.png" alt="logo" class="logo"
          /></a>
        </div>
        <div class="welcome-text-div">
          <p>Nice to meet you!</p>
          <p>Create an account to get the most from IoTBay</p>
        </div>
        <form method="post" action="/RegisterServlet">
          <div class="input-div">

            <% if(register_givenNameErr != null) { %>
              <p><%=register_givenNameErr%></p>
            <% } %>
            <input
              type="text"
              name="given_name"
              id="given_name"
              placeholder="Given Name"
              
            />

            <% if(register_familyNameErr != null) { %>
              <p><%=register_familyNameErr%></p>
            <% } %>
            <input
              type="text"
              name="family_name"
              id="family_name"
              placeholder="Family Name"
              
            />

            

            <% if(register_emailErr != null) { %>
              <p><%=register_emailErr%></p>
            <% } %>
            <% if(register_email_exists != null) { %>
              <p><%=register_email_exists%></p>
            <% } %>
            <input type="email" name="email" id="email" placeholder="Email" />

            <% if(register_passwordErr != null) { %>
              <p><%=register_passwordErr%></p>
            <% } %>
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Password"
              
            />

            <% if(register_phoneErr != null) { %>
              <p><%=register_phoneErr%></p>
            <% } %>
            <input
              type="text"
              name="phone"
              id="phone"
              placeholder="Phone"
              
            />

            <% if(register_dobErr != null) { %>
              <p><%=register_dobErr%></p>
            <% } %>
            <input type="date" name="dob" id="dob" >

          </div>
          <div class="submit-div">
            <input type="submit" value="Register" />
            <p>Don't have an account? <a href="/login.jsp">Login</a></p>
          </div>
        </form>
      </div>
    </div>

    <div class="right-div">
      <img src="https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?q=80&w=2565&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="mouse wallpaper" />
    </div>
  </body>
</html>

