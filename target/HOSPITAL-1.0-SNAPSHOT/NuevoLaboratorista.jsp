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
        <% if ((String) request.getSession().getAttribute("codigoUsuario") != null && (int) request.getSession().getAttribute("tipoUsuario") == 1) {%>
        <% if (request.getAttribute("Exitoso") == null) {%>
        <div class="container" style="padding-top: 50px" >
            <script type="text/javascript">

                function unselect() {
                    document.querySelectorAll('[name=Lunes]').forEach((x) => x.checked = false);

                }
            </script>
            <h1 class="align-content-lg-center">Nuevo Laboratorista</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevoLaboratorista">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="codigoLaboratorista">Codigo: </label>
                        <input class="form-control" type="text"  name="codigoLaboratorista" id="codigoLaboratorista" placeholder="Ingrese el Codigo Asignado al Laboratorista" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Nombre: </label>
                        <input class="form-control" type="text"  name="nombreLaboratorista" id="nombreLaboratorista" placeholder="Ingrese el Nombre del Laboratorista" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>DPI: </label>
                        <input class="form-control" type="text"  name="DPILaboratorista" id="DPILaboratorista" placeholder="Ingrese el DPI del Laboratorista" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Telefono: </label>
                        <input class="form-control" type="text"  name="telefonoLaboratorista" id="telefonoLaboratorista" placeholder="Ingrese el Numero Telefonico del Laboratorista" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Correo Electronico: </label>
                        <input class="form-control" type="email"  name="correoLaboratorista" id="correoLaboratorista" placeholder="Ingrese el Correo Electronico del Laboratorista" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contraseña: </label>
                        <input class="form-control" type="password"  name="passwordLaboratorista" id="passwordLaboratorista" placeholder="Ingrese la Contraseña Asignada al Laboratorista" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Registro ante el MSPAS: </label>
                        <input class="form-control" type="text"  name="registroLaboratorista" id="registroLaboratorista" placeholder="Ingrese el Codigo de Registro del Laboratorista" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="fechaInicioLaboratorista">Fecha de Inicio de Labores: </label>
                        <input class="form-control" type="date"  name="fechaInicioLaboratorista" id="fechaInicioLaboratorista" min="2000-01-01" max="2025-01-01" required>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-8">
                        <label>Nombre del Examen: </label>
                        <input class="form-control" type="text"  name="examenLaboratorista" id="examenLaboratorista" placeholder="Ingrese el Nombre del Examen que Realizará el Laboratorista" required>
                        <small>*Debe Escribir el Nombre del Examen Correctamente en Base al Nombre que fue Ingresado en La Base de Datos</small>

                    </div>


                </div>
                <h1 class="align-content-lg-center">Turnos</h1>

                <div class="form-group col-md-12">

                    <input class="form-check-input" type="radio" id="Lunes" name="Lunes" value="Lunes">
                    <label class="form-check-label" for="Lunes">Lunes </label>

                    <input class="form-check-input" type="radio" id="Martes" name="Martes" value="Martes">
                    <label class="form-check-label" for="Martes">Martes </label>

                    <input class="form-check-input" type="radio" id="Miercoles" name="Miercoles" value="Miercoles">
                    <label class="form-check-label" for="Miercoles">Miercoles </label>

                    <input class="form-check-input" type="radio" id="Jueves" name="Jueves" value="Jueves">
                    <label class="form-check-label" for="Jueves">Jueves </label>

                    <input class="form-check-input" type="radio" id="Viernes" name="Viernes" value="Viernes">
                    <label class="form-check-label" for="Viernes">Viernes </label>

                    <input class="form-check-input" type="radio" id="Sabado" name="Sabado" value="Sabado">
                    <label class="form-check-label" for="Sabado">Sabado </label>

                    <input class="form-check-input" type="radio" id="Domingo" name="Domingo" value="Domingo">
                    <label class="form-check-label" for="Domingo">Domingo </label>


                </div>

                <br>
                <CENTER>

                    <input class="btn btn-primary" type="submit" value="Agregar">
                    <input class="btn" type="reset" value="Eliminar Datos" onclick="unselect()">
                </CENTER>

            </FORM>


            <% } else {%>
            <div class="container" style="padding-top: 70px" >
                <h1 class="align-content-lg-center">Nuevo Laboratorista</h1>


                <% if ((boolean) request.getAttribute("Exitoso")) {%>
                <div class="alert alert-success">
                    Laboratorista Agregado con Exito
                </div>
                <% } else {%>
                <div class="alert alert-danger">
                    Error al Agregar al Laboratorista
                </div>
                <div class="col-12 caja2">
                    <CENTER>

                        <a href="NuevoLaboratorista.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

                    </CENTER>
                </div>
                <% }%>
            </div>
            <% }%>
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
