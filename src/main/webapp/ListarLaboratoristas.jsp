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
        <%@ include file = "NavBarAdministrador.jsp" %>
        <% if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 1) {%>
            <% if (request.getAttribute("Reporte") == null) {%>
            <% RequestDispatcher despachar = request.getRequestDispatcher("ListarLaboratoristas");
           despachar.forward(request, response);%>

 

        </div>
        <% } else {%>
<div class="container" style="padding-top: 80px" >
        <style>
            .my-custom-scrollbar {
                position: relative;
                height: 350px;
                overflow: auto;
            }
            .table-wrapper-scroll-y {
                display: block;
            }
        </style>
    <h1 class="align-content-lg-center">Listado de Laboratoristas Registrados en el Hospital</h1>
            <c:choose>
                <c:when test="${Reporte.isEmpty()}">
                <div class="alert alert-danger">
                    No existe ningun Registro de Laboratoristas en Nuestro Hospital
                </div>
            </c:when>
            <c:otherwise>
                <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table class="table table-bordered  table-hover" >
                <thead>
                <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>DPI</th>
                <th>Telefono</th>
                
                <th>Correo</th>
                <th>Numero de Registro</th>
                <th>Examen que Realiza</th>
            
                <th>Codigo del Examen</th>
                <th>Fecha de Inicio</th>
           
            </tr>
                </thead>
            <c:forEach items="${Reporte}" var="resultado"> 
                <tbody>

                <tr>
                    <td>${resultado.getCodigo()}</td>
                    <td>${resultado.getNombre()}</td>
                    <td>${resultado.getDPI()}</td>
                    <td>${resultado.getTelefono()}</td>
                    
                    <td>${resultado.getCorreo()}</td>
                    <td>${resultado.getRegistro()}</td>
                    <td>${resultado.getNombreExamen()}</td>
                    
                    <td>${resultado.getCodigoExamen()}</td>
                    <td>${resultado.getFechaInicio()}</td>
 
                </tr>
                </tbody>
            </c:forEach>
        </table>
                </div>
</c:otherwise>


        </c:choose>
            
        </div>
        <% }%>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioLaboratorista.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioPaciente.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioMedico.jsp"); %>
        <% } else { %>
    <% response.sendRedirect(request.getContextPath()+"/Login.jsp");
         %>
    <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
