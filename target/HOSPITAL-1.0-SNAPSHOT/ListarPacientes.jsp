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
        <%@ include file = "NavBarAdministrador.jsp" %>
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) {%>

                    <div class="container" style="padding-top: 70px" >

            <h1 class="align-content-lg-center">Todos los Pacientes</h1>
            <h3 class="align-content-lg-center">Campos de Busqueda:</h3>

            <FORM class="col-12 caja2" METHOD="GET" ACTION="ListarPacientes">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="nombre">Buscar por Nombre: </label>
                        <input class="form-control" type="text"  name="nombre" id="nombre" placeholder="Ingrese el Nombre del Paciente">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nombre">Buscar por Codigo: </label>
                        <input class="form-control" type="text"  name="codigo" id="codigo" placeholder="Ingrese el Codigo del Paciente">
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
                        No Existe Ningun Paciente con los Campos de Busqueda que Usted Solicita
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-bordered table-hover" >
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>DPI</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th>Sexo</th>
                                <th>Nacimiento</th>
                                <th>Peso</th>
                                <th>Tipo de Sangre</th>
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
                                    <td>${resultado.getSexo()}</td>
                                    <td>${resultado.getNacimiento()}</td>
                                    <td>${resultado.getPeso()}</td>
                                    <td>${resultado.getTipoSangre()}</td>
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
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioPaciente.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioMedico.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
