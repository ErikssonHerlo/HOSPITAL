<%-- 
    Document   : InicioAdmin
    Created on : 2/10/2020, 04:43:24
    Author     : erikssonherlo
--%>

<%@page import="objetos.ReporteMedico"%>
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

            <h1 class="align-content-lg-center">Buscar Medicos</h1>
            <h3 class="align-content-lg-center">Campos de Busqueda:</h3>

            <FORM class="col-12 caja2" METHOD="GET" ACTION="BusquedaMedico">  
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="nombre">Buscar por Nombre: </label>
                        <input class="form-control" type="text"  name="nombre" id="nombre" placeholder="Ingrese el Nombre del Medico">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="nombre">Buscar por Especialidad: </label>
                        <input class="form-control" type="text"  name="titulo" id="titulo" placeholder="Ingrese la Especialidad del Medico">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="fechaFinal">Buscar por Horario: </label>
                        <input class="form-control" type="time"  name="horario">
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
                        No Existe Ningun Medico con los Campos de Busqueda que Usted Solicita
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-dark">
                            <tr>
                                <th>Codigo</th>
                                <th>Medico</th>
                                <th>Colegiado</th>
                                <th>Hora de Entrada</th>
                                <th>Hora de Salida</th>

                                <th>Fecha de Inicio</th>
                                <th>Titulo</th>
                                <th>Agendar Cita</th>

                            </tr>
                        </thead>

                        <c:forEach items="${Reporte}" var="resultado"> 
                            <tbody>
                                <tr>
                                    <td>${resultado.getCodigoMedico()}</td>
                                    <td>${resultado.getNombreMedico()}</td>
                                    <td>${resultado.getColegiado()}</td>
                                    <td>${resultado.getHoraEntrada()}</td>
                                    <td>${resultado.getHoraSalida()}</td>
                                    <td>${resultado.getFechaInicio()}</td>
                                    <td>${resultado.getTitulo()}</td>
                  
                                    <td><a href="NuevaCitaMedico?codigoMedico=${resultado.getCodigoMedico()}&tituloEspecialidad=${resultado.getTitulo()}&horaEntrada=${resultado.getHoraEntrada()}&horaSalida=${resultado.getHoraSalida()}" target="__blank">Agendar Cita</a></td>
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
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioMedico.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
