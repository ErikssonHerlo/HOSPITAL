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
        <div class="container" style="padding-top: 70px" >
            <script type="text/javascript">

            <h1 class="align-content-lg-center">Nuevo Examen</h1>

            <FORM name="formulario" class="col-12 caja2" METHOD="POST" ACTION="NuevoExamen">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="codigoExamen">Codigo: </label>
                        <input class="form-control" type="text"  name="codigoExamen" id="codigoExamen" placeholder="Ingrese el Codigo Asignado al Examen" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nombreExamen">Nombre: </label>
                        <input class="form-control" type="text"  name="nombreExamen" id="nombreExamen" placeholder="Ingrese el Nombre del Examen" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="orden">El Examen Requiere una Orden Medica: </label>

                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="true" name="orden" value="true" class="custom-control-input" onclick="validar(this);">
                            <label class="custom-control-label" for="orden">Si</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="false" name="orden" value="false" class="custom-control-input" onclick="deshabilitar(this)">
                            <label for="orden">No</label>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Descripción Detallada del Examen: </label>
                        <textarea class="form-control" name="descripcionExamen" id="descripcionExamen" placeholder="Ingrese la Descripción Detallada del Examen" rows="3"required> </textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Costo: </label>
                        <input class="form-control"  type="number" step="0.001"  name="costoExamen" id="costoExamen" placeholder="Ingrese el Costo del Examen" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="formatoInforme">Elija el Formato del Examen: </label>

                        <select class="form-control" name="formatoInforme" id="formatoInforme" disabled>

                            <option value="PDF">PDF</option>
                            <option value="imagen">Imagen</option>

                        </select>                    </div>
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
            <h1 class="align-content-lg-center">Nuevo Examen</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Examen Agregado con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar el Examen
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevoExamen.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

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
