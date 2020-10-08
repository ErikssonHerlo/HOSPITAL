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
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) {%>

                    <div class="container" style="padding-top: 70px" >

            <h1 class="align-content-lg-center">Los Ingresos Obtenidos por los Medicos</h1>
            <h3 class="align-content-lg-center">Intervalo de Tiempo:</h3>

            <FORM class="col-12 caja2" METHOD="GET" ACTION="Reporte2Admin">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="fechaInicio">Fecha de Inicio: </label>
                        <input class="form-control" type="date"  name="fechaInicio" id="fechaInicio" min="2000-01-01" max="2030-01-01" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="fechaFinal">Fecha de Finalización: </label>
                        <input class="form-control" type="date"  name="fechaFinal" id="fechaFinal" min="2000-01-01" max="2030-01-01" required>
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
                height: 250px;
                overflow: auto;
            }
            .table-wrapper-scroll-y {
                display: block;
            }
        </style>

            <c:choose>
                <c:when test="${Reporte.isEmpty()}">
                    <div class="alert alert-danger">
                        No se Obtuvo Ninguna Ganancia durante este Intervalo de Tiempo
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-dark">
                            <tr>

                                <th>Codigo del Ingreso</th>
                                <th>Codigo del Paciente</th>
                                <th>Codigo del Medico</th>
                                <th>Medico</th>
                                <th>Fecha</th>
                                <th>Ingreso Total</th>
                                <th>Codigo Cita Medica</th>

                            </tr>
                        </thead>

                        <c:forEach items="${Reporte}" var="resultado"> 
                     

                            <tbody>
                                <tr>
                                    <td>${resultado.getIdIngresos()}</td>
                                    <td>${resultado.getCodigoPaciente()}</td>
                                    <td>${resultado.getCodigoMedico()}</td>
                                    <td>${resultado.getNombreMedico()}</td>
                                    <td>${resultado.getFecha()}</td>
                                    <td>${resultado.getTotal()}</td>
                                    <td>${resultado.getCodigoCita()}</td>
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
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioMedico.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioPaciente.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
