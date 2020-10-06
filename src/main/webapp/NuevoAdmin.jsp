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

            <h1 class="align-content-lg-center">Nuevo Administrador</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevoAdministrador">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Codigo: </label>
                        <input class="form-control" type="text"  name="codigoAdministrador" id="codigoAdministrador" placeholder="Ingrese el Codigo Asignado al Administrador" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Nombre: </label>
                        <input class="form-control" type="text"  name="nombreAdministrador" id="nombreAdministrador" placeholder="Ingrese el Nombre del Administrador" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>DPI: </label>
                        <input class="form-control" type="text"  name="DPIAdministrador" id="DPIAdministrador" placeholder="Ingrese el DPI del Administrador" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Telefono: </label>
                        <input class="form-control" type="text"  name="telefonoAdministrador" id="telefonoAdministrador" placeholder="Ingrese el Numero Telefonico del Administrador" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Correo Electronico: </label>
                        <input class="form-control" type="email"  name="correoAdministrador" id="correoAdministrador" placeholder="Ingrese el Correo Electronico del Administrador" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contraseña: </label>
                        <input class="form-control" type="password"  name="passwordAdministrador" id="passwordAdministrador" placeholder="Ingrese la Contraseña Asignada al Administrador" required>
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
            <h1 class="align-content-lg-center">Nuevo Administrador</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Administrador Agregado con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar al Administrador
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
