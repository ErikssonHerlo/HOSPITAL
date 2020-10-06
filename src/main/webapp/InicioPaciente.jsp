<%-- 
    Document   : InicioAdmin
    Created on : 2/10/2020, 04:43:24
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>

    <% if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 3) {
    %>
        <%@ include file = "NavBarPaciente.jsp"%>
    
        <%@ include file = "CarrouselGeneral.html"%>
        <%@ include file = "FooterGeneral.html" %>
            <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioLaboratorista.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 1) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioAdmin.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioMedico.jsp"); %>
        
    <% } else { %>
    <% response.sendRedirect(request.getContextPath()+"/Login.jsp");
         %>
    <% }%>
    </body>
</html>
