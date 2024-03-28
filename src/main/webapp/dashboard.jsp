<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <link rel="stylesheet" href="css/dashboard.css" />
    <title>IoTBay - Dashboard</title>
  </head>

  <%
    String firstName = request.getParameter("firstName");
  %>

  <body>
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
          <a href="/index.jsp">Logout</a>
          <img src="/assests/user-icon.png" alt="user icon" class="user-icon" />
        </div>
      </div>
    </nav>
    <main>
      <div class="container dashboard-div">
        <h1>Dashboard</h1>
      </div>
      <div class="container main-wrapper">
        <div class="sidebar-div">
          <div class="sidebar-items">
            <a href="/">Home</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
          <div class="sidebar-items">
            <a href="/">Personal Details</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
          <div class="sidebar-items">
            <a href="/">Payment Details</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
          <div class="sidebar-items">
            <a href="/">Active Orders</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
          <div class="sidebar-items">
            <a href="/">Order History</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
          <div class="sidebar-items">
            <a href="/">Wish List</a>
            <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
          </div>
        </div>
        <div class="main-div">
          <div class="welcome-div">
            <h1>Hi welcome back, <%= firstName%></h1>
            <p>You last sign into your account on 31/03/2024</p>
          </div>
          <div class="recommended-div">
            <h1>Recommended Products</h1>
            <div class="carousel-div">
              <img
                src="/assests/carousel-icons.png"
                alt="arrow icon"
                class="carousel-arrow-left"
              />
              <div class="products-div">
                <div class="product"></div>
                <div class="product"></div>
              </div>

              <img
                src="/assests/carousel-icons.png"
                alt="arrow icon"
                class="carousel-arrow-right"
              />
            </div>
          </div>
        </div>
      </div>
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
