<%-- 
    Document   : NavBarPaciente
    Created on : 5/10/2020, 13:40:47
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
                        <a class="navbar-brand" href="InicioPaciente.jsp">Hospital</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown"><a href="Historial_Paciente.jsp">Historial Medico</a></li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agendar <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                               
                                   
                                    <li class="dropdown-header">Cita Medica</li>
                                    <li><a href="#">Nueva Cita Medica</a></li>
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Cita Laboratorio</li>
                                    <li><a href="#">Nueva Cita con el Laboratorio</a></li>
                            
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                               
                                   
                                    <li class="dropdown-header">Cita Medica</li>
                                    <li><a href="#">Citas Programadas con el Medico</a></li>
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Cita Laboratorio</li>
                                    <li><a href="#">Citas Programadas con el Laboratorio</a></li>
                            
                                </ul>
                            </li>
                           

                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="dropdown-header">Laboratorio</li>
                                    <li><a href="Reporte1_Paciente.jsp">Ultimos Examenes Realizados</a></li>
                                    <li><a href="#">Examenes Realizados de un Tipo en Especifico</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Consultas Medicas</li>
                                    <li><a href="Reporte3_Paciente.jsp">Ultimas Consultas Realizadas</a></li>
                                    <li><a href="#">Consultas Realizadas por un Medico en Especifico</a></li>
                                 
                                </ul>
                            </li>
                            <li class="dropdown"><a href="CerrarSesion">Cerrar Sesion</a></li>
                            <li class="dropdown"><a href=""></a>________________</li>
                            <li class="dropdown"><a  href=""><%=(String)request.getSession().getAttribute("nombreUsuario")%></a></li>
                            
                        </ul>
                    </div>
                </div>
            </nav>
        </div>>