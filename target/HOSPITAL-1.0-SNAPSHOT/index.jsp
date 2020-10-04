<%-- 
    Document   : index
    Created on : 2/10/2020, 01:28:35
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    conexionMySQL.Conexion.crearConexion();
%>
<html>
    <%@ include file = "HeaderGeneral.html" %>
    <body>
        <div class="container" style="padding-top: 70px" >

            <h1 class="align-content-lg-center">Carga de Archivo XML</h1>

            <FORM class="col-12 caja2" METHOD="POST" ACTION="ControladorCargaArchivo" enctype="multipart/form-data">  
                <div class="row">
                    <div class="form-group col-md-4">
                        <label>Elija el Archivo que desea Cargar a la Base de Datos: </label>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Nombre: </label>
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
        <%--  <% response.sendRedirect("Laboratorista/InicioLaboratorista.jsp"); %>
        
        <%-- <% response.sendRedirect("Medico/InicioMedico.jsp"); %>
        
        <%--
        <% response.sendRedirect("Paciente/InicioPaciente.jsp"); %>
        <%@ include file = "HTML/CarrouselGeneral.html" %>
        <%@ include file = "HTML/FooterGeneral.html" %>
         <% response.sendRedirect("InicioAdmin.jsp"); %>
        <%--   
          
        --%>





    </body>
</html>
