<%-- 
    Document   : createProduct
    Created on : 26.04.2018, 21:22:12
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
         function validateForm(){
             alert('ValidateForm');
             var inp1=document.getElementById('productname');
             if(inp1.value.length>10){
                 alert('Название велико');
             }
             alert(inp1.value);
             console.log(inp1.value);
             var inp2=document.getElementById('cost');
             var costValue =Number(inp2.value);
             if(costValue<=0)
            // if(inp2.value.lenght<0)
             alert('Цена не может быть отрицательной!');
             var inp3=document.getElementById('description');
             if(inp3.value.length===0)
             alert('описание не может быть пустым');
             var inp4=document.getElementById('vendor');
               alert(inp4.value);
             if(inp4.value.length===0)
               alert('Выберите значение');
           
         }   
        </script>
    </head>
    <body>
        <h2>Создание продукта</h2>
        <form>
            <table>
                <tr>
                    <td>Название продукта:</td><td> <input type="text" name="productname" id="productname"></td>
                </tr>
                <tr>
                    <td>Стоимость:</td><td> <input type="text" name="cost" id="cost"></td>
                </tr>
                <tr>
                    <td>Описание:</td><td> <textarea id="description" row="5" cols="20" name="description"></textarea></td>
                </tr>
                <tr>
                    <td>Производитель:</td><td> <select name="vendor" id="vendor">
                            <option></option>
                            <option>Sony</option>
                            <option>Apple</option>
                            <option>Samsung</option>
                        </select></td>
                </tr>
            </table>
            <button onclick="validateForm()" type="button">Отправить</button>
        </form>
        
    </body>
</html>
//dz - dlya vseh poley alert
//fuction number - preobrazovat, ogranichenie na stoimos - otricat znach