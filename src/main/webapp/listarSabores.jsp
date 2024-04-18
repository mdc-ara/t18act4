<%-- 
    Document   : listarSabores.jsp
    Created on : 18 abr. 2024, 9:20:42
    Author     : asier.ruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="es.medac.t18act4.Sabor" %>
<%@ page import="es.medac.t18act4.SaborDAO" %>
<!DOCTYPE html>
<html>
    <head>
    <% String pageName = "Listado de Sabores"; %>
    <title><%= pageName %></title>
    </head>
<body>
    <h1>${initParam.webTitle}: <%= pageName %></h1>
    <h2>Sabores Disponibles</h2>
    <%
        SaborDAO dao = new SaborDAO();
        List<Sabor> lista = dao.listarSabores();
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Sabor</th>
            <th>Precio</th>
        </tr>
        <% for(Sabor sabor : lista) { %>
        <tr>
            <td><%= sabor.getId() %></td>
            <td><%= sabor.getSabor() %></td>
            <td><%= sabor.getPrecio() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
