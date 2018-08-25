<%-- 
    Document   : product
    Created on : 21.06.2018, 21:47:41
    Author     : Samsung
--%>

<%@page import="com.eshop.model.ProductCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.eshop.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String cid = request.getParameter("id");
            ProductCategory prodCat = (ProductCategory) request.getAttribute("prodCat");

            List<Product> prod = prodCat.getListProducts();
        %>
        <h1>Товары категории  <%=prodCat.getCategoryName()%></h1>



        <table border="1">
            <tr>
                <td>Название</td><td>Цена</td><td>Описание</td><td>Добавить в корзину</td>
            </tr>
            <%for (int i = 0; i < prod.size(); i++) {
                Product product = prod.get(i);
            %><tr>
                <td><a href="/MyShop/justProd?id=<%=product.getId()%>"><%=product.getProductName()%></a></td><td><%=product.getCost()%></td><td><%=product.getDescription()%></td><td><a href="/MyShop/AddToBusket?id=<%=product.getId()%>&cid=<%=cid%>">Добавить в корзину</a></td>
            </tr>
            <tr>
                <td>
                   
                </td>
            </tr>
            <%}
            %>
            
            <a href="/MyShop/ViewBusket?idUser=1">Показать корзину</a>
                    <!--  Zdes nuzhno id usera!!!! -->
        </table>


    </body>
</html>

<%--<li><a href="/MyShop/ProductSrv?id=<%=pc.getId()%>"> <%=pc.getCategoryName()%> <%=pc.getId()%></a></li></ul>
                        <%}%--%>