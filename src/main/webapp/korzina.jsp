<%-- 
    Document   : korzina
    Created on : 15.07.2018, 15:05:53
    Author     : Samsung
--%>

<%@page import="com.eshop.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.eshop.model.Busket"%>
<%@page import="com.eshop.model.BusketItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Товары в корзине</h1>
        <%Busket busket = (Busket) request.getAttribute("busket");
            List<BusketItem> list1 = busket.getBusketItems();
            User user = busket.getUser();
        %>
        <table border="1">
            <tr>
                <td>Товар</td><td>Количество</td><td>Стоимость</td><td></td>
            </tr>
            <%for (int j = 0; j < list1.size(); j++) {
                    BusketItem punktZakaza = list1.get(j);
                    String product = punktZakaza.getProduct().getProductName();
                    int number = punktZakaza.getNumber();
                    double cost = punktZakaza.getProduct().getCost();
            %>
            <tr>
                <td><a href="<%=request.getContextPath()%>/justProd?id=<%=punktZakaza.getProduct().getId()%>"><%=product%></td><td><%=number%></td><td><%=cost%></td><td><a href="/MyShop/DeleteOrderServlet?id=<%=punktZakaza.getId()%>">Убрать из заказа</a></td>
            </tr>
            <%}%>
        </table><br>
        Общая сумма: <%=busket.getTotalPrice()%>
        <a href="/MyShop/DeleteOrderServlet?user_id=<%=user.getId()%>">Очистить корзину</a>
        Оформить заказ(кнопка)-
    </body>
</html>
