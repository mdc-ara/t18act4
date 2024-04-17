<%-- 
    Document   : index
    Created on : 17 abr. 2024, 14:17:08
    Author     : asier.ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% String pageName = "Index"; %>
        <title><%= pageName %></title>
    </head>
    <body>
        <h1>Heladería Carap <%= pageName %></h1>
        <p>Bienvenido a mi aplicación web de gestión de la Heladería Carap.</p>
    
        <form action="saludo.jsp" method="post">
            <label for="nombre">Ingresa tu nombre:</label>
            <input type="text" id="nombre" name="nombre">
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
