<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Index Page</title>
    </head>
    <body >
        <nav>
            <div class="container navbar">
              <a href="/index.jsp"
                ><img src="/assests/logo.png" alt="logo" class="logo"
              /></a>
              <div class="search-div">
                <input type="text" placeholder="Search millions of things . . ." />
                <img
                  src="/assests/search-icon.png"
                  alt="search icon"
                  class="search-icon"
                />
              </div>
              <div class="cart-div">
                Cart
                <img src="/assests/cart-icon.png" alt="cart icon" class="cart-icon" />
              </div>
              <div class="user-div">
                
                <a href="/login.jsp">Login</a>
                <a href="/register.jsp">Register</a>
             
                <img src="/assests/user-icon.png" alt="user icon" class="user-icon" />
              </div>
            </div>
          </nav>

          <main class="container">
            <h1>Home Page</h1>
    
            <a href="/dashboard.jsp">Dashboard</a>
            
            <% User user = (User) session.getAttribute("authUser"); %>
    
            <% if(user == null) { %>
                <p>You are either not registered or authenticated</p>
            <% } else { %>
                <p>You are authenticated <%=user.getFirstName() %></p>
            <% } %>
          </main>
    </body>
</html>
