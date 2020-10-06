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
            <% if (request.getAttribute("HistorialMedico") == null) {%>
            <% RequestDispatcher despachar = request.getRequestDispatcher("HistorialMedicoPaciente");
           despachar.forward(request, response);%>

        </div>
        <% } else {%>
<div class="container" style="padding-top: 60px" >
    <style>
        .my-custom-scrollbar {
position: relative;
height: 300px;
overflow: auto;
}
.table-wrapper-scroll-y {
display: block;
}
    </style>
    <!-- -------------------------HISTORIAL MEDICO DE CONSULTAS  ------------------>
     <h1 class="align-content-lg-center">Historial Medico del Paciente <%=request.getSession().getAttribute("nombreUsuario")
            %></h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table class="table table-bordered  table-hover" >
                <thead>
                <tr>
                <th>Codigo</th>
                <th>Paciente</th>
                <th>Medico</th>
                <th>Descripcion</th>
                
                <th>Fecha</th>
                <th>Hora</th>
            
            </tr>
                </thead>
            <c:forEach items="${HistorialMedico}" var="resultado"> 
                <tbody>
                <tr>
                    <td>${resultado.getCodigoInforme()}</td>
                    <td>${resultado.getNombrePaciente()}</td>
                    <td>${resultado.getNombreMedico()}</td>
                    <td>${resultado.getDescripcion()}</td>
                    
                    <td>${resultado.getFecha()}</td>
                    <td>${resultado.getHora()}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
            </div>
 
    
    
    
    
    
    
    
    <h1 class="align-content-lg-center">Historial del Laboratorio del Paciente <%=request.getSession().getAttribute("nombreUsuario")
            %></h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table class="table table-bordered  table-hover" >
                <thead class="thead-dark">
                <tr>
                <th>Codigo</th>
                <th>Paciente</th>
                <th>Laboratorista</th>
                <th>Examen</th>
                <th>Informe del Examen</th>
                
                <th>Fecha</th>
                <th>Hora</th>
            
            </tr>
                </thead>
            <c:forEach items="${HistorialLaboratorio}" var="resultado"> 
                <tbody>
                <tr>
                    <td>${resultado.getCodigoResultado()}</td>
                    <td>${resultado.getNombrePaciente()}</td>
                    <td>${resultado.getNombreLaboratorista()}</td>
                    <td>${resultado.getNombreExamen()}</td>
                    <td><a href="ArchivosDB/${resultado.getInformeExamen()}" target="__blank">Informe</a></td>
                    <td>${resultado.getFecha()}</td>
                    <td>${resultado.getHora()}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
            </div>
    
            
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
