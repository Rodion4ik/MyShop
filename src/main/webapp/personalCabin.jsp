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
            <%User user = (User)session.getAttribute("user");
            String name = user.getLogin();
            String otherInfo = "Zdes mogla by byt vasha reklama";
            %>
            Login uzverya <%=name%>
            </br>
            fio</br>
            email</br>
            vzyat s servleta User
            tovary v korzine
            istoriya pokypok(vtoraya korzina) mozhno na ee osnovanii cheki delat
            (smotra kakoe zakonodatelstvo)
            
            
        </div>
    </body>
</html>
