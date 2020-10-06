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

            <h1 class="align-content-lg-center">Nueva Consulta</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="NuevaConsulta">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="tipoConsulta">Tipo: </label>
                        <input class="form-control" type="text"  name="tipoConsulta" id="tipoConsulta" placeholder="Ingrese el Tipo de Consulta que se Prestara" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="costoConsulta">Costo: </label>
                        <input class="form-control" type="number" step="0.001"  name="costoConsulta" id="costoConsulta" placeholder="Ingrese el Costo que tendrá la Consulta" required>
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
            <h1 class="align-content-lg-center">Nueva Consulta</h1>


            <% if ((boolean) request.getAttribute("Exitoso")) {%>
            <div class="alert alert-success">
                Consulta Agregada con Exito
            </div>
            <% } else {%>
            <div class="alert alert-danger">
                Error al Agregar la Consulta
            </div>
            <div class="col-12 caja2">
                <CENTER>

                    <a href="NuevaConsulta.jsp" class="btn btn-primary">Ingresar Datos de Nuevo</a>

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
