<%-- 
    Document   : user
    Created on : 15.07.2018, 12:52:56
    Author     : Samsung
--%>

<%@page import="com.eshop.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%User user;
            String name="noName";
                try{ user= (User)session.getAttribute("user");
             name = user.getLogin();
            String otherInfo = "Zdes mogla by byt vasha reklama";}
                catch(Exception e){}
            %>
            Login uzverya <%=name%>
            </br>
            fio</br>
            email</br>
            <a href="/MyShop/ViewBusket">Товары в корзине</a>
            istoriya pokypok(vtoraya korzina) mozhno na ee osnovanii cheki delat
            (smotra kakoe zakonodatelstvo)
            
            
        </div>
    </body>
</html>
