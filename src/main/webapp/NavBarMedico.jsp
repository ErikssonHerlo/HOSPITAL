<%-- 
    Document   : NavBarMedico
    Created on : 5/10/2020, 13:41:02
    Author     : erikssonherlo
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="container">
            <!-- Fixed navbar -->
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="InicioMedico.jsp">Hospital</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
      

                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Informes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <!-- <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li> 
                                    -->
                                   
                                    <li class="dropdown-header">Nuevo</li>
                                    <li><a href="NuevoInforme_Medico.jsp">Realizar Informe de Cita Medica</a></li>
                                   
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Existente</li>
                                    <li><a href="#">Ver Informes Existentes</a></li>
                                    
                                    
                                </ul>
                            </li>
                           <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agendar <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <!-- <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li> 
                                    -->
                                   
                                    <li class="dropdown-header">Cita Medica</li>
                                    <li><a href="#">Nueva Cita Medica</a></li>

                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Cita Laboratorio</li>
                                    <li><a href="#">Nueva Cita Laboratorio</a></li>
                                    
                                    
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="dropdown-header">Historial Medico</li>
                                    <li><a href="Historial_Medico.jsp">Historial Medico de Todos los Pacientes</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas Medicas</li>
                                    <li><a href="Reporte2_Medico.jsp">Citas Agendadas en un Intervalo de Tiempo</a></li>
                                    <li><a href="Reporte3_Medico.jsp">Citas Agendadas para Hoy</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Informes </li>
                                    <li><a href="Reporte4_Medico.jsp">Pacientes con Mas Informes</a></li>
                                   
                                </ul>
                            </li>
                            <li class="dropdown"><a href="CerrarSesion">Cerrar Sesion</a></li>
                            <li class="dropdown"><a href=""></a>___________________________________________</li>
                            <li class="dropdown"><a href=""><%=(String)request.getSession().getAttribute("nombreUsuario")%></a></li>
                            
                        </ul>
                    </div>
                </div>
            </nav>
        </div>>