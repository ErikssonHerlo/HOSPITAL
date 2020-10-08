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
        <%@ include file = "NavBarAdministrador.jsp" %>
        <% if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 1) {%>
            <% if (request.getAttribute("Exitoso") == null) {%>
        <div class="container" style="padding-top: 50px" >

            <h1 class="align-content-lg-center">Nuevo Medico</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevoMedico">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="codigoMedico">Codigo: </label>
                        <input class="form-control" type="text"  name="codigoMedico" id="codigoMedico" placeholder="Ingrese el Codigo Asignado al Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Nombre: </label>
                        <input class="form-control" type="text"  name="nombreMedico" id="nombreMedico" placeholder="Ingrese el Nombre del Medico" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>DPI: </label>
                        <input class="form-control" type="text"  name="DPIMedico" id="DPIMedico" placeholder="Ingrese el DPI del Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Telefono: </label>
                        <input class="form-control" type="text"  name="telefonoMedico" id="telefonoMedico" placeholder="Ingrese el Numero Telefonico del Medico" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Correo Electronico: </label>
                        <input class="form-control" type="email"  name="correoMedico" id="correoMedico" placeholder="Ingrese el Correo Electronico del Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contraseña: </label>
                        <input class="form-control" type="password"  name="passwordMedico" id="passwordMedico" placeholder="Ingrese la Contraseña Asignada al Medico" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Colegiado: </label>
                        <input class="form-control" type="number"  name="colegiadoMedico" id="colegiadoMedico" placeholder="Ingrese el Numero de Colegiado del Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="fechaInicioMedico">Fecha de Inicio de Labores: </label>
                        <input class="form-control" type="date"  name="fechaInicioMedico" id="fechaInicioMedico" min="2000-01-01" max="2025-01-01" required>
                    </div>
                </div>

                
                 <div class="row">
                    <div class="form-group col-md-4">
                        <label>Hora de Entrada: </label>
                        <input class="form-control" type="time"  name="horaEntradaMedico" id="horaEntradaMedico" placeholder="Ingrese la Hora de Entrada del Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Hora de Salida: </label>
                        <input class="form-control" type="time"  name="horaSalidaMedico" id="horaSalidaMedico" placeholder="Ingrese la Hora de Salida del Medico" required>
                    </div>
                </div>
               
                <h1 class="align-content-lg-center">Especialidad</h1>
                               <div class="row">
                    <div class="form-group col-md-4">
                        <label>Primera Especialidad: </label>
                        <input class="form-control" type="text"  name="especialidad1Medico" id="especial1Medico" placeholder="Ingrese el Nombre de la Especialidad del Medico" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Segunda Especialidad: </label>
                        <input class="form-control" type="text"  name="especialidad2Medico" id="especial2Medico" placeholder="Ingrese el Nombre de la Especialidad del Medico">
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
            <h1 class="align-content-lg-center">Nuevo Medico</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Medico Agregado con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar al Medico
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevoMedico.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

                </CENTER>
            </div>
            <% }%>
        </div>
        <% }%>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 2) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioLaboratorista.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 3) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioPaciente.jsp"); %>
        <% } else if((String)request.getSession().getAttribute("codigoUsuario") != null && (int)request.getSession().getAttribute("tipoUsuario") == 4) { %>
        <% response.sendRedirect(request.getContextPath()+"/InicioMedico.jsp"); %>
        <% } else { %>
    <% response.sendRedirect(request.getContextPath()+"/Login.jsp");
         %>
    <% }%>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
