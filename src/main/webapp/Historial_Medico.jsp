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
        <% if (request.getAttribute("ReporteHistorialMedico") == null) {%>
        <% RequestDispatcher despachar = request.getRequestDispatcher("Reporte1Medico");
                despachar.forward(request, response);%>

    </div>
    <% } else {%>
    <div class="container" style="padding-top: 50px" >
        <style>
            .my-custom-scrollbar {
                position: relative;
                height: 450px;
                overflow: auto;
            }
            .table-wrapper-scroll-y {
                display: block;
            }
        </style>
        <!-- -------------------------HISTORIAL MEDICO DE CONSULTAS  ------------------>
            <h1 class="align-content-lg-center">Historial Medico de Todos los Pacientes</h1>
            <c:choose>
                <c:when test="${ReporteHistorialMedico.isEmpty()}">
                <div class="alert alert-danger">
                    El Historial de Consultas esta Vacio
                </div>
            </c:when>
            <c:otherwise>

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
                                <th>Cita Medica</th>
                            </tr>
                        </thead>


                        <c:forEach items="${ReporteHistorialMedico}" var="resultado"> 
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
                </div>

            </c:otherwise>

        </c:choose>




    </div>
    <% }%>
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
