<%-- 
    Document   : registration
    Created on : 15.07.2018, 12:00:31
    Author     : Samsung
--%>

<%@page import="com.eshop.UserService"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Регистрация</h1>
       
        <div>
            <form action="/MyShop/RegistrationServlet" method="POST">
                Логин <input type="text" name="login" id="login"  > <br>
                Пароль <input type="text" name ="password" id="password" ><br>
                email <input type="text" name ="email" id="email">
                <input type="submit" value="регистрация">            
            </form>
        </div>

    </body>
</html>
