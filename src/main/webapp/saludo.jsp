<%-- 
    Document   : saludo
    Created on : 18 abr. 2024, 8:25:58
    Author     : asier.ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% String pageName = "Saludo"; %>
        <title><%= pageName %></title>
    </head>
<body>
    <h1>${initParam.webTitle}: <%= pageName %></h1>
    <h2>¡Hola <%= request.getParameter("nombre") %>!</h2>
    <p>Bienvenido.</p>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat"%>
    <%
    Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("EEEE 'día' dd 'de' MMMM");
    String fechaFormateada = formateador.format(ahora);
    %>
    <p>Hoy es <%= fechaFormateada %></p>
    <p>Menú:</p>
    <ul>
        <li> <a href="listarSabores.jsp">Listar Sabores</a><br> </li>
    </ul>
</body>
</html>
