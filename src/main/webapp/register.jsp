<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Inter', sans-serif;
      }

      body {
        height: 100vh;
        overflow: hidden;
        display: flex;
        background-color: #f8f9fa;
        letter-spacing: 0.6px;
      }

      .left-div {
        width: 40vw;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .register-div {
       
        width: 450px;
        border-radius: 25px;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        background-color: #f1f3f5;
      }

      .logo-div {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 30px 0;
        border-bottom: 1.5px solid #d22020;
      }

      .logo {
        width: 200px;
      }

      .welcome-text-div {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 40px 0;
      }

      .welcome-text-div p:nth-child(1) {
        font-weight: 500;
        font-size: 22px;
        margin-bottom: 15px;
      }

      .welcome-text-div p:nth-child(2) {
        font-weight: 200;
        font-size: 15px;
      }

      form {
        flex-grow: 1;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding: 0 40px;
        gap: 50px;
      }

      .input-div {
        display: flex;
        flex-direction: column;
        gap: 10px;
      }

      .input-div input {
        padding: 15px 20px;
        border-radius: 20px;
        border: 1px solid #d1d1d1;
        background-color: transparent;
        font-weight: 200;
        font-size: 14px;
        color: #858585;
        letter-spacing: 1px;
      }

      .input-div input:focus {
        outline-color: #858585;
      }
      .input-div a {
        color: #000;
        text-decoration: none;
        font-size: 14px;
        font-weight: 200;
        margin-left: 20px;
      }

      .submit-div {
        display: flex;
        flex-direction: column;
      }

      .submit-div input {
        background-color: #d22020;
        border: none;
        color: #fff;
        padding: 20px 0;
        border-radius: 20px;
        font-weight: 600;
        letter-spacing: 1px;
        font-size: 15px;
      }

      .submit-div input:hover {
        cursor: pointer;
        background-color: #bb1f1f;
      }

      .submit-div p {
        color: #000;
        text-decoration: none;
        font-size: 14px;
        font-weight: 200;
        margin-left: 20px;
        margin: 20px auto 40px auto;
      }

      .right-div {
        width: 60vw;
        height: 100vh;
      }

      .right-div img {
        height: 100vh;
        width: 100%;
        object-fit: cover;
      }

    </style>
    <title>IoTBay - Register</title>
  </head>
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
            <input
              type="text"
              name="given_name"
              id="given_name"
              placeholder="Given Name"
              required
            />
            <input
              type="text"
              name="family_name"
              id="family_name"
              placeholder="Family Name"
              required
            />
            <input type="email" name="email" id="email" placeholder="Email" required/>
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Password"
              required
            />
            <input
              type="text"
              name="phone"
              id="phone"
              placeholder="Phone"
              required
            />

            <input type="date" name="dob" id="dob">
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

