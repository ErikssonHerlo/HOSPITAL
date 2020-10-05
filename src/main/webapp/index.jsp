<%-- 
    Document   : index
    Created on : 2/10/2020, 01:28:35
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    conexionMySQL.Conexion.crearConexion();
%>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>
          <% if (request.getAttribute("Estado") == null) {%>
        <% RequestDispatcher despachar = request.getRequestDispatcher("InicioVistas");
           despachar.forward(request, response);%>
           <% } else {%>
             <% if ((boolean)request.getAttribute("Estado")) {%>
           
            <% response.sendRedirect("Login2.jsp"); %>
        <% } else {%>
            <% response.sendRedirect("CargaArchivo.jsp"); %>
        <% }%>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>

    </body>
</html>
