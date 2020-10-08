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
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 3) {%>

                    <div class="container" style="padding-top: 70px" >

                        <h1 class="align-content-lg-center">Busqueda de los Ultimos Examenes Realizados por el Paciente <%=(String)request.getSession().getAttribute("nombreUsuario")%></h1>
            <h3 class="align-content-lg-center">Intervalo de Tiempo:</h3>

            <FORM class="col-12 caja2" METHOD="GET" ACTION="Reporte2Paciente">  
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="fechaInicio">Fecha de Inicio: </label>
                        <input class="form-control" type="date"  name="fechaInicio" id="fechaInicio" min="2000-01-01" max="2030-01-01" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="fechaFinal">Fecha de Finalización: </label>
                        <input class="form-control" type="date"  name="fechaFinal" id="fechaFinal" min="2000-01-01" max="2030-01-01" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="fechaFinal">Nombre del Examen: </label>
                        <input class="form-control" type="text"  name="nombreExamen" id="examen" placeholder="Ingrese el Nombre del Examen que desea Buscar" required>
                    </div>
                     <div class="form-group col-md-3">
 
                        <br>
                        <input class="form-control-sm btn btn-primary" type="submit" value="Buscar">
                    </div>
                </div>

            </FORM>
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

                <c:choose>
                <c:when test="${Reporte.isEmpty()}">
                <div class="alert alert-danger">
                    El Paciente No Ha Realizado Ningun Examen en Nuestro Laboratorio
                </div>
            </c:when>
            <c:otherwise>
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
                
            <c:forEach items="${Reporte}" var="resultado"> 
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

</c:otherwise>


        </c:choose>

        </div>
        
      
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioLaboratorista.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioMedico.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioAdmin.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
