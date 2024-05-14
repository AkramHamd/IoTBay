<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>

<nav>
  <div class="container navbar">
    <a href="/index"><img src="/assets/logo.png" alt="logo" class="logo" /></a>
    <form class="search-div" method="post" action="/ProductSearchServlet">
      <input type="text" name="searchQuery" placeholder="Search millions of things . . ." />
      <input type="image" src="/assets/search-icon.png" alt="search icon" class="search-icon" />
    </form>
    <div class="cart-div">
      Cart
    </div>
    <div class="user-div">
      <% User user = (User) session.getAttribute("user"); %>

      <% if(user == null) { %>
        <a href="/login.jsp">Login</a>
        <a href="/register.jsp">Register</a>
      <% } else { %>
        <a href="/LogoutServlet">Logout</a>
        <a href="/dashboard.jsp"><img src="/assets/user-icon.png" alt="user icon" class="user-icon"/></a>
      <% } %>
    </div>
  </div>
</nav>