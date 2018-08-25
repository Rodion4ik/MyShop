<%-- 
    Document   : JustProduct
    Created on : 07.07.2018, 0:20:09
    Author     : Samsung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%Product prod = (Product) request.getAttribute("product");
    String name = prod.getProductName();
    double cost = prod.getCost();
    String desc = prod.getDescription();
    int vendor = prod.getVendor_id();
    ArrayList<Integer> photos = prod.getPhotosIds();
%>
<html>
    <head>
        <script>
            function openPhoto(id) {
                window.open('/MyShop/PhotoServlet?id=' + id, 'previewPhoto', 'width=800,height=600')
            }

        </script>
        <!--po navedeniu uvelich-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=name%></title>
    </head>
    <body>

        <h1><%=name%></h1>
        <table border =1>
            <tr>
                <td>Наименование</td><td><%=name%></td>
            </tr>      
            <tr>   
                <td>Стоимость</td><td><%=cost%></td>
            </tr>
            <tr>      
                <td>Описание</td><td><%=desc%></td>
            </tr>
            <tr>     


                <td>Фото</td>
                <td><table><tr><%for (Integer i : photos) {
                        %><tr><td><a onclick="openPhoto(<%=i%>)"><img src="/MyShop/PhotoServlet?id=<%=i%>" alt="альтернативный текст" height="200" width="200"></td></tr></a></td>
                            <%}%></tr></table>
            </tr>


            <!--Dz opisanie, esli null, to net null na stranice, frazy. Takze foto mozhno zapisat v table.
            Plus eskizy po uvelicheniu
            plus otdelnyy servis sevice i metody dlya neavtorizovannogo uzera.-->

            <!--Izobrazheni iz bazy bytea i id--> 
        </table>

    </body>
</html>
