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
        <%@ include file = "NavBarMedico.jsp" %>
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) {%>

                    <div class="container" style="padding-top: 70px" >

            <h1 class="align-content-lg-center">Pacientes con Mayor Cantidad de Informes Medicos</h1>
            <h3 class="align-content-lg-center">Intervalo de Tiempo:</h3>

            <FORM class="col-12 caja2" METHOD="GET" ACTION="Reporte4Medico">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="fechaInicio">Fecha de Inicio: </label>
                        <input class="form-control" type="date"  name="fechaInicio" id="fechaInicio" min="2019-01-01" max="2025-01-01" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="fechaFinal">Fecha de Finalización: </label>
                        <input class="form-control" type="date"  name="fechaFinal" id="fechaFinal" min="2019-01-01" max="2025-01-01" required>
                    </div>
                    <div class="form-group col-md-4">
 
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
                        No se Realizo Ningun Reporte Medico durante este Intervalo de Tiempo
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-dark">
                            <tr>

                                <th>Codigo del Paciente</th>
                                <th>Paciente</th>
                                <th>Cantidad de Informes</th>

                            </tr>
                        </thead>

                        <c:forEach items="${Reporte}" var="resultado"> 
                     

                            <tbody>
                                <tr>

                                    <td>${resultado.getCodigoPaciente()}</td>
                                    <td>${resultado.getNombrePaciente()}</td>
                                    <td>${resultado.getCantidadInformes()}</td>
                                    
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    </div>
                </c:otherwise>


            </c:choose>

        </div>
        
      
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioLaboratorista.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioAdmin.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioPaciente.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
