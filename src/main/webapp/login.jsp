<%-- 
    Document   : login
    Created on : 06.08.2018, 9:14:06
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход на сайт</title>
    </head>
    <body>
        <h1>Введите учетные данные</h1>
        <form action="/MyShop/LoginServlet" method="POST">
            Логин <input type="text" name="login" id="login"  > <br>
            Пароль <input type="text" name ="password" id="password" ><br>
            <input type="submit" value="submit">            
        </form>
        <!--vyvesti soobshenie,esli error=1 parametr prishel-->
    </body>
</html>
