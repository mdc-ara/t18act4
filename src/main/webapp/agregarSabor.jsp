<%-- 
    Document   : agregarSabor
    Created on : 19 abr. 2024, 8:54:17
    Author     : asier.ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <% String pageName = "Agregar Sabor"; %>
    <title><%= pageName %></title>
    </head>
<body>
    <h1>${initParam.webTitle}: <%= pageName %></h1>
    <form action="SaborServlet" method="GET">
        <input type="hidden" name="action" value="agregar"/> <!-- Acción a realizar por el servlet -->
        Sabor: <input type="text" name="sabor" value=""/><br/>
        Precio: <input type="number" step="0.01" name="precio" value=""/><br/>
        <input type="submit" value="Guardar"/>
    </form>
</body>
</html>
