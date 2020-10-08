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
        <% if (request.getAttribute("Reporte") == null) {%>
        <% RequestDispatcher despachar = request.getRequestDispatcher("Reporte3Medico");
                despachar.forward(request, response);%>

    </div>
    <% } else {%>
    <div class="container" style="padding-top: 80px" >
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
               <h1 class="align-content-lg-center">Citas Agendadas con el Medico <%=request.getSession().getAttribute("nombreUsuario")%> para el Dia de Hoy</h1>
          
              <c:choose>
                <c:when test="${Reporte.isEmpty()}">
                    <div class="alert alert-danger">
                        El Medico No Tiene Ninguna Cita Agendada para el Dia de Hoy
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-dark">
                            <tr>
                                <th>Codigo de la Cita</th>
                                <th>Codigo del Paciente</th>
                                <th>Paciente</th>
                                <th>Codigo del Medico</th>
                                <th>Tipo de Consulta</th>

                                <th>Fecha</th>
                                <th>Hora</th>

                            </tr>
                        </thead>

                        <c:forEach items="${Reporte}" var="resultado"> 
                     

                            <tbody>
                                <tr>
                                    <td>${resultado.getCodigoCita()}</td>
                                    <td>${resultado.getCodigoPaciente()}</td>
                                    <td>${resultado.getNombrePaciente()}</td>
                                    <td>${resultado.getCodigoMedico()}</td>
                                    <td>${resultado.getTipoConsulta()}</td>
                                    <td>${resultado.getFecha()}</td>
                                    <td>${resultado.getHora()}</td>
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
