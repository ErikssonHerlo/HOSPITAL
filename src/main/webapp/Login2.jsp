<%-- 
    Document   : Login2
    Created on : 5/10/2020, 00:14:42
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <%@ include file = "HeaderGeneral.html" %>
    <body>
        <style>

.abs-center {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}
 
.form {
  width: 600px;
  
 
}
        </style>
        <% if (request.getAttribute("Exitoso") == null) {%>
        <div class="container" style="padding-top: 70px" >
            <center>
                <h1 class="align-content-lg-center">Inicio de Sesión</h1>
                </center>
            
            <div class="modal-dialog text-centered">
            <FORM class="px-5 py-4 " METHOD="POST" ACTION="InicioSesion">  
                
                    <div class="form-group">
                        <label>Codigo de Usuario: </label>
                        <input class="form-control" type="text"  name="usuarioCodigo" id="usuarioCodigo" placeholder="Ingrese su Codigo de Usuario" required>
                    </div>

                
                
                    <div class="form-group">
                        <label>Contraseña: </label>
                        <input class="form-control" type="text"  name="usuarioPassword" id="usuarioPassword" placeholder="Ingrese su Contraseña" required>
                    </div>

              
                
               

                <br>
                <CENTER>

                    <input class="btn btn-primary" type="submit" value="Iniciar Sesión">
                    
                </CENTER>

            </FORM>
            </div>
       
            <center>
           <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">¿No tienes una Cuenta? Registrate</a>
            </center>
            

        
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
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
