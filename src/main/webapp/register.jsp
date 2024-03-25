<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/register.css">
        <title>Register</title>
    </head>
    <body >
        <div class="left">
            <div class="register-div">
                <div class="logo-div">
                    <img src="./assests/logo.png" alt="IoTBay logo" class="logo">
                </div>

                <div class="welcome-msg-div">
                    <p>Welcome back!</p>
                    <p>Login to get the most from IoTBay</p>
                </div>
                
                <form>
                    <div class="form-input-div">
                        <input name="firstName" id="firstName" placeholder="First Name" />
                        <input name="lastName" id="lastName" placeholder="Last Name" />
                        <input type="email" name="email" id="email" placeholder="email" required/>
                        <input type="password" name="password1" id="password1" placeholder="Password" />
                        <input type="password" name="password2" id="password2" placeholder="Confirm Password" />
                    </div>
                    
                    <button type="submit">Register Account</button> 
                    <p>Already have an account? <a href="/login.jsp">Login</a></p>
                </form>
                
            </div>
         </div>

         <img src="./assests/wallpaper.jpeg" alt="wallpaper of a mouse" class="right">
    </body>
</html>
