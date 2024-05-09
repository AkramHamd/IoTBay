<div class="product-card">
    <img src="<%= request.getParameter("imageURL") %>" alt="<%= request.getParameter("productName") %>">
    <div class="product-details">
        <h3><%= request.getParameter("productName") %></h3>
        <p><%= request.getParameter("productDescription") %></p>
        <p class="price">$<%= request.getParameter("productPrice") %></p>
        <a href="#" class="btn">Buy Now</a>
    </div>
</div>