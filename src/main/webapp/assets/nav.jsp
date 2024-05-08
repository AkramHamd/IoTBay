<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Customer"%>

<nav style="border-bottom: 2px solid var(--primary);">
  <div class="container navbar" style="display: flex; align-items: center; justify-content: space-between; padding: 40px 0;">
    <a href="/index.jsp"
      ><img src="/assets/logo.png" alt="logo" class="logo" style="width: 200px;"
    /></a>
    <div class="search-div" style="width: 550px; display: flex; border: 1px solid var(--border-colour); border-radius: 25px; padding: 10px 20px; gap: 10px;">
      <input type="text" placeholder="Search millions of things . . ." style="flex: 1; border: none; font-size: 14px;"/>
      <img
        src="/assets/search-icon.png"
        alt="search icon"
        class="search-icon"
        style="width: 25px;"
      />
    </div>
    <div class="cart-div" style="background-color: var(--primary); color: #fff; padding: 5px 15px; border-radius: 25px; display: flex; align-items: center; gap: 15px;">
      Cart
      <img src="/assets/cart-icon.png" alt="cart icon" class="cart-icon" style="width: 25px;"/>
    </div>
    <div class="user-div" style="display: flex; align-items: center; gap: 15px;">
      <% Customer customer = (Customer) session.getAttribute("customer"); %>

      <% if(customer == null) { %>
        <a href="/login.jsp">Login</a>
        <a href="/register.jsp">Register</a>
      <% } else { %>
        <a href="/LogoutServlet">Logout</a>
        <a href="/dashboard.jsp"><img src="/assets/user-icon.png" alt="user icon" class="user-icon" style="width: 30px;"/></a>
      <% } %>
    </div>
  </div>
</nav>