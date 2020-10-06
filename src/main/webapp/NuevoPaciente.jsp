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
        <div class="container" style="padding-top: 70px" >

            <h1 class="align-content-lg-center">Nuevo Paciente</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevoPaciente">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="codigoPaciente">Codigo: </label>
                        <input class="form-control" type="text"  name="codigoPaciente" id="codigoPaciente" placeholder="Ingrese el Codigo Asignado al Paciente" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Nombre: </label>
                        <input class="form-control" type="text"  name="nombrePaciente" id="nombrePaciente" placeholder="Ingrese el Nombre del Paciente" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>DPI: </label>
                        <input class="form-control" type="text"  name="DPIPaciente" id="DPIPaciente" placeholder="Ingrese el DPI del Paciente" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Telefono: </label>
                        <input class="form-control" type="text"  name="telefonoPaciente" id="telefonoPaciente" placeholder="Ingrese el Numero Telefonico del Paciente" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Correo Electronico: </label>
                        <input class="form-control" type="email"  name="correoPaciente" id="correoPaciente" placeholder="Ingrese el Correo Electronico del Paciente" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contraseña: </label>
                        <input class="form-control" type="password"  name="passwordPaciente" id="passwordPaciente" placeholder="Ingrese la Contraseña Asignada al Paciente" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="sexoPaciente">Sexo: </label>
                       
                        

                        <select class="form-control" name="sexoPaciente" id="sexoPaciente">

                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>

                        </select>   

                    </div>
                    <div class="form-group col-md-4">
                        <label>Fecha de Nacimiento: </label>
                        <input class="form-control" type="date"  name="nacimientoPaciente" id="nacimientoPaciente" min="1950-01-01" max="2020-01-01" required>
                    </div>
                </div>
                
                 <div class="row">
                    <div class="form-group col-md-4">
                        <label>Peso: </label>
                        <input class="form-control" type="text"  name="pesoPaciente" id="pesoPaciente" placeholder="Ingrese el Peso del Paciente" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Tipo de Sangre: </label>
                        <input class="form-control" type="text"  name="tipoSangrePaciente" id="tipoSangrePaciente" placeholder="Ingrese el Tipo de Sangre del Paciente" required>
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
            <h1 class="align-content-lg-center">Nuevo Paciente</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Paciente Agregado con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar al Paciente
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevoPaciente.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

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
