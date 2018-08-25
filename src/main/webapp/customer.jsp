<%-- 
    Document   : customer
    Created on : 03.05.2018, 21:46:14
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function initPage(){
                alert('INIT page!!!');
                var customer={login:'Петр',password:'Дворников',email:'PetrUrrich@mail.ru'};
             var elem1=document.getElementById("login");
             elem1.value=customer.login;
             var elem2=document.getElementById("password");
             elem2.value=customer.password;
             var elem3=document.getElementById("email");
             elem3.value=customer.email;
            }
            
        </script>
    </head>
    <body onload="initPage();">
        <form>
            Логин <input type="text" name="login" id="login" readonly > <br>
            Пароль <input type="text" name ="password" id="password" readonly><br>
           Почтовый ящик <input type="text" name ="email" id="email" readonly>
            
        </form>
    </body>
</html>
