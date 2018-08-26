<%-- 
    Document   : start
    Created on : 15.05.2018, 7:46:29
    Author     : Samsung
--%>


<%@page import="com.eshop.model.User"%>
<%@page import="com.eshop.model.ProductCategory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .block1 { 
                width: 1000px; 
                background: #ccc;
                padding: 5px;
                padding-right: 20px; 
                border: solid 1px black; 
                float: left;
            }
            .block2 { 
                width: 200px; 
                background: #fc0; 
                padding: 5px; 
                border: solid 1px black; 
                /* float: left;*/
                bottom: 100px;
                /* position: relative; */
                top: 40px;
                height: 700px;
                left: 70px;
            }
            .block3 { 
                width: 600px; 
                /*background: #fc0;*/ 
                padding: 5px; 
                border: solid 1px black; 
                /* float: left;*/
                /* bottom: 100px;*/
                /* position: relative; */
                top: 40px;
                height: 700px;
                right:  70px;
            }
            .box{
                display:flex;
                align-items: stretch;
            }
        </style> 
    </head>
    <body>

        <%
            String registration;
            String voyti;
            String usrName;
            String logOut;
            try {
                User user = (User) session.getAttribute("user");

                usrName = "<a href=\"/MyShop/personalCabin.jsp\">" + user.getLogin() + "</a>";
                voyti = "";
                registration = "";
                logOut="<a href=\"/MyShop/LogOutServlet\">Выйти из системы</a>";
            } catch (Exception e) {
                usrName = "";
                voyti = "Войти";
                registration = "Регистрация";
                logOut="";
            }

        %>
        <div class="block1">
            <table>
                <tr>

                    <td>О сайте</td><td>Контакты</td><td><a href="/MyShop/registration.jsp"><%=registration%></a></td><td><a href="/MyShop/login.jsp"><%=voyti%></a></td><td><a href="/MyShop/ViewBusket">Корзина</a></td><td><%=usrName%></td><td><%=logOut%></td>
                </tr>
            </table>
        </div>

        <div class="box">
            <div class="block2">
                <% List<ProductCategory> al1 = (List<ProductCategory>) request.getAttribute("categories");
                    for (int i = 0; i < al1.size(); i++) {
                        ProductCategory pc = al1.get(i);

                %>
                <ul> <li><a href="/MyShop/ProductSrv?id=<%=pc.getId()%>"> <%=pc.getCategoryName()%> </a></li></ul>
                        <%}

                        %>
            </div>
            <div class="block3"><p><a href=""><img src="images/iphone.jpg" alt="iphone" height="200" width="200"></a></p></div>
        </div>

    </body>
</html>
