<%-- 
    Document   : CargaArchivo
    Created on : 3/10/2020, 21:11:22
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>
        <% if (request.getAttribute("Exitoso") == null) {%>
        <div class="container" style="padding-top: 70px" >
            <h1 class="align-content-lg-center">Carga de Archivo XML</h1>
     
            <FORM class="col-12 caja2" METHOD="POST" ACTION="ControladorCargaArchivo" enctype="multipart/form-data">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Elija el Archivo que desea Cargar a la Base de Datos: </label>
                    </div>
                    <div class="form-group col-md-4">
                        
                        <input class="form-control" type="file"  name="archivoDB" id="archivoDB" placeholder="Elija el Archivo" accept="application/xml" required>
                    </div>
                </div>


                <br>
                <CENTER>

                    <input class="btn btn-primary" type="submit" value="Cargar">
                    <input class="btn" type="reset" value="Eliminar Datos">
                </CENTER>

            </FORM>

        </div>
        <% } else {%>
                    < <div class="container" style="padding-top: 70px" >
             <center>
            <h1 class="align-content-lg-center">Carga de Archivo XML</h1>
             </center>
        <% if ((boolean)request.getAttribute("Exitoso")) {%>
           

            <div class="alert alert-success">
                Carga de Archivo Realizada con Exito
            </div>
                <br>
                <CENTER>
               
                    <a href="InicioAdmin.jsp" class="btn btn-primary">Iniciar Sesion</a>
              

                </CENTER>
      

        
        <% } else {%>
                       <div class="alert alert-danger">
                Fallo en la Carga de Archivo
            </div>
                <br>
                <CENTER>
               
                    <a href="InicioAdmin.jsp" class="btn btn-primary">Iniciar Sesion</a>
              

                </CENTER>
        <% }%>
         </div>
        <% }%>

        
    </body>
</html>
