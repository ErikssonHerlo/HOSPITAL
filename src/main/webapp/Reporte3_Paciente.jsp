<%-- 
    Document   : InicioAdmin
    Created on : 2/10/2020, 04:43:24
    Author     : erikssonherlo
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>
        <%@ include file = "NavBarPaciente.jsp" %>
        <% if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 3) {%>
            <% if (request.getAttribute("Reporte") == null) {%>
            <% RequestDispatcher despachar = request.getRequestDispatcher("Reporte3Paciente");
           despachar.forward(request, response);%>

 

        </div>
        <% } else {%>
<div class="container" style="padding-top: 80px" >

    <h1 class="align-content-lg-center">Ultimas Consultas Medicas Realizados al Paciente <%=request.getSession().getAttribute("nombreUsuario")
            %></h1>
            <c:choose>
                <c:when test="${Reporte.isEmpty()}">
                <div class="alert alert-danger">
                    El Paciente No Ha Realizado Ninguna Consulta en Nuestro Hospital
                </div>
            </c:when>
            <c:otherwise>
            <table class="table table-bordered  table-hover" >
                <thead>
                <tr>
                <th>Codigo</th>
                <th>Paciente</th>
                <th>Medico</th>
                <th>Descripcion</th>
                
                <th>Fecha</th>
                <th>Hora</th>
                <th>Cita Medica</th>
            
            </tr>
                </thead>
            <c:forEach items="${Reporte}" var="resultado"> 
                <tbody>
                <tr>
                    <td>${resultado.getCodigoInforme()}</td>
                    <td>${resultado.getNombrePaciente()}</td>
                    <td>${resultado.getNombreMedico()}</td>
                    <td>${resultado.getDescripcion()}</td>
                    
                    <td>${resultado.getFecha()}</td>
                    <td>${resultado.getHora()}</td>
                    <td>${resultado.getCodigoCitaMedica()}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
</c:otherwise>


        </c:choose>
            
        </div>
        <% }%>
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
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
