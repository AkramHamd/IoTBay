<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>

<nav>
  <div class="container navbar">
    <a href="/index.jsp"><img src="/assets/logo.png" alt="logo" class="logo" /></a>
    <div class="search-div">
      <input type="text" placeholder="Search millions of things . . ." />
      <img src="/assets/search-icon.png" alt="search icon" class="search-icon" />
    </div>
    <div class="user-div">
      <% User user = (User) session.getAttribute("user"); %>

      <% if(user == null) { %>
        <a href="/login.jsp">Login</a>
        <a href="/register.jsp">Register</a>
      <% } else { %>
        <a href="/cart.jsp">Cart</a>
        <a href="/LogoutServlet">Logout</a>
        <a href="/dashboard.jsp"><img src="/assets/user-icon.png" alt="user icon" class="user-icon"/></a>
      <% } %>
    </div>
  </div>
</nav>