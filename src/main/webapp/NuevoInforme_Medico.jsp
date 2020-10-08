<%-- 
    Document   : InicioAdmin
    Created on : 2/10/2020, 04:43:24
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>
        <%@ include file = "NavBarMedico.jsp" %>
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 4) {%>
        <% if (request.getAttribute("Exitoso") == null) {%>
        <div class="container" style="padding-top: 70px" >


            <h1 class="align-content-lg-center">Nuevo Informe de Consulta Medica</h1>

            <FORM name="formulario" class="col-12 caja2" METHOD="POST" ACTION="NuevoInformeMedico">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="codigoExamen">Codigo del Paciente: </label>
                        <input class="form-control" type="text"  name="codigoPaciente" id="codigoPaciente" placeholder="Ingrese el Codigo del Paciente al que se le Practico la Consulta" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="codigoMedico">Codigo del Medico: </label>
                        <input class="form-control" type="text"  name="codigoMedico" id="codigoMedico" value="<%=(String) request.getSession().getAttribute("codigoUsuario")%>" readonly="<%=(String)request.getSession().getAttribute("codigoUsuario")%>">
                    </div>
                </div>
                <div class="row">
                   
                    <div class="form-group col-md-8">
                        <label>Descripción Detallada de la Consulta Medica Realizada: </label>
                        <textarea class="form-control" name="descripcionInforme" id="descripcionInforme" placeholder="Ingrese la Descripción Detallada del Examen" rows="6"required> </textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="fechaInicioMedico">Fecha en la que se Realizo la Consulta: </label>
                        <input class="form-control" type="date"  name="fechaInforme" id="fechaInforme" min="2000-01-01" max="2025-01-01" required>
                    </div>
                

                    <div class="form-group col-md-2">
                        <label>Hora: </label>
                        <input class="form-control" type="time"  name="horaInforme" id="horaInforme"  required>
                        <small>Horario en que se realizo la consulta</small>
                    </div>    
                    <div class="form-group col-md-3">
                        <label for="codigoMedico">Codigo de la Consulta: </label>
                        <input class="form-control" type="text"  name="codigoConsulta" id="codigoConsulta" placeholder="Ingrese el Codigo de la Cita Medica Realizada">
                    </div>
                </div>

                <br>
                <CENTER>

                    <input class="btn btn-primary" type="submit" value="Agregar">
                    <input class="btn" type="reset" value="Eliminar Datos">
                </CENTER>

            </FORM>

        </div>
        <% } else {%>
        <div class="container" style="padding-top: 70px" >
            <h1 class="align-content-lg-center">Nuevo Informe de Consulta Medica</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Informe de Consulta Medica Agregado con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar el Informe de Consulta Medica
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevoInforme_Medico.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

                </CENTER>
            </div>
            <% }%>
        </div>
        <% }%>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioLaboratorista.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioPaciente.jsp"); %>
        <% } else if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) { %>
        <% response.sendRedirect(request.getContextPath() + "/InicioAdmin.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/Login.jsp");
        %>
        <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
