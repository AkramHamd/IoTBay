<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="180x180" href="/assests/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/assests/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/assests/favicon/favicon-16x16.png">
        <link rel="manifest" href="/assests/favicon/site.webmanifest">
        
        <link rel="stylesheet" href="css/index.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Index Page</title>
    </head>

    <% User user = (User) session.getAttribute("authUser"); %>

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

                <% if(user == null) { %>
                  <a href="/login.jsp">Login</a>
                  <a href="/register.jsp">Register</a>
                <% } else { %>
                  <a href="/logout.jsp">Logout</a>
                <% } %>
                
                <a href="/dashboard.jsp"><img src="/assests/user-icon.png" alt="user icon" class="user-icon" /></a>
              </div>
            </div>
          </nav>

          <main class="container">
            <h1>Home page still under construction</h1>
                
            <% if(user == null) { %>
                <p>You are NOT authenticated</p>
            <% } else { %>
                <p>You are authenticated</p>
            <% } %>
          </main>
          <footer>
            <div class="container footer-container">
              <div class="footer-left">
                <div>
                  <a href="/index.jsp">
                    <img src="/assests/logo.png" alt="logo" class="footer-logo" />
                  </a>
                  <p>You name it, we got it</p>
                </div>
                <div class="AOC-div">
                  <h1>Acknowledgement of Country</h1>
                  <p>
                    IoTBay acknowledges Aboriginal and Torres Strait Islander people
                    as the Traditional Custodians of the land and acknowledges and
                    pays respect to their Elders, past and present.
                  </p>
                </div>
              </div>
              <div class="footer-right">
                <div class="footer-links">
                  <div>
                    <p>Showcase</p>
                    <p>Services</p>
                    <p>Privacy policy</p>
                    <p>Return policy</p>
                  </div>
                  <div>
                    <p>About Us</p>
                    <p>Contact Us</p>
                    <p>Affiliates</p>
                    <p>Resources</p>
                  </div>
                </div>
              </div>
            </div>
            <div class="container footer-footer">
              <p>Copyright &copy 2024. All rights reserved.</p>
              <p>Built by ISD Group 2</p>
            </div>
          </footer>
    </body>
</html>
