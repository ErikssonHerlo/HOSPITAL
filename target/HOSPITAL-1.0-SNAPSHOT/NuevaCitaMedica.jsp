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
        <%@ include file = "NavBarPaciente.jsp" %>
        <% if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 3) {%>
            
        <div class="container" style="padding-top: 70px" >
            <% if (request.getAttribute("Exitoso") == null) {%>

            <h1 class="align-content-lg-center">Nueva Cita Medica</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevaCitaMedico">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Codigo de la Cita: </label>
                        <input class="form-control" type="text"  name="codigoCita" id="codigoCita" value="<%=(int)request.getAttribute("codigoCitaMedica")%>"  readonly="<%=(int)request.getAttribute("codigoCitaMedica")%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label>Codigo del Paciente: </label>
                        <input class="form-control" type="text"  name="codigoPaciente" id="codigoPaciente" value="<%=(String)request.getAttribute("codigoUsuario")%>" readonly="<%=(String)request.getAttribute("codigoUsuario")%>">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Codigo del Medico: </label>
                        <input class="form-control" type="text"  name="codigoMedico" id="codigoMedico" value="<%=(String)request.getAttribute("codigoMedico")%>" readonly="<%=(String)request.getAttribute("codigoMedico")%>">
                    </div>
                     <div class="form-group col-md-4">
                        <label>Tipo de Consulta: </label>
                        <input class="form-control" type="text"  name="tipoConsulta" id="tipoConsulta" value="<%=(String)request.getAttribute("tituloEspecialidad")%>" readonly="<%=(String)request.getAttribute("tituloEspecialidad")%>">
                    </div>
                </div>
                     <div class="row">
                    <div class="form-group col-md-4">
                        <label>Hora de Entrada del Medico: </label>
                        <input class="form-control" type="text"  name="horaEntrada" id="horaEntrada" value="<%=(String)request.getAttribute("horaEntrada")%>" readonly="<%=(String)request.getAttribute("horaEntrada")%>">
                    </div>
                     <div class="form-group col-md-4">
                        <label>Hora de Salida del Medico: </label>
                        <input class="form-control" type="text"  name="horaSalida" id="horaSalida" value="<%=(String)request.getAttribute("horaSalida")%>" readonly="<%=(String)request.getAttribute("horaSalida")%>">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Fecha: </label>
                        <input class="form-control" type="date"  name="fechaCitaMedica" id="fechaCitaMedica"  min="2000-01-01" max="2025-01-01" required>
                        <small>Ingrese la Fecha en la que Desea Agendar la Cita Medica </small>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Hora: </label>
                        <input class="form-control" type="time"  name="horaCitaMedica" id="horaCitaMedica" min="<%=(String)request.getAttribute("horaEntrada")%>" max="<%=(String)request.getAttribute("horaSalida")%>" required>
                        <small>Ingrese el Horario en el que Desea Agendar la Cita Medica </small>
                    </div>
                </div>

                <br>
                <CENTER>

                    <input class="btn btn-primary" type="submit" value="Agregar">
                    <input class="btn" type="reset" value="Eliminar Datos">
                </CENTER>

            </FORM>

        </div>
                        <% } else{%>
        
        <div class="container" style="padding-top: 70px" >
           <h1 class="align-content-lg-center">Nueva Cita Medica</h1>

            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Cita Medica Agendada con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agendar la Cita Medico, debido a que el Horario ya se encuentra Ocupado
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevoAdmin.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

                </CENTER>
            </div>
            <% }%>

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
