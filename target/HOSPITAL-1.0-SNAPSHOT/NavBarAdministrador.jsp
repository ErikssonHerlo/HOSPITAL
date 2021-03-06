<%-- 
    Document   : PruebaNavBar
    Created on : 3/10/2020, 08:19:33
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
                        <a class="navbar-brand" href="InicioAdmin.jsp">Hospital</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <!-- <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li> 
                                    -->
                                   
                                    <li class="dropdown-header">Usuarios</li>
                                    <li><a href="ListarPacientes.jsp">Pacientes</a></li>
                                    <li><a href="ListarMedicos.jsp">Medicos</a></li>
                                    <li><a href="ListarLaboratoristas.jsp">Laboratoristas</a></li>
                                    <li><a href="#">Administradores</a></li>
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Servicios</li>
                                    <li><a href="ListarExamenes.jsp">Examenes</a></li>
                                    <li><a href="#">Consultas</a></li>
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Informacion</li>
                                    <li><a href="#">Especialidades</a></li>
                                    <li><a href="#">Turnos del Laboratorio</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Informes</li>
                                    <li><a href="#">Informes de Consultas</a></li>
                                    <li><a href="#">Resultados del Laboratorio</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas</li>
                                    <li><a href="#">Citas Laboratorista</a></li>
                                    <li><a href="#">Citas Medicas</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agregar Nueva Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    
                                    <li><a href="NuevoAdmin.jsp">Nuevo Administrador</a></li>
                                    <li><a href="NuevoPaciente.jsp">Nuevo Paciente</a></li>
                                    <li><a href="NuevoMedico.jsp">Nuevo Medico</a></li>
                                    <li><a href="NuevoLaboratorista.jsp">Nuevo Laboratorista</a></li>
                                    <li><a href="NuevoExamen.jsp">Nuevo Examen</a></li>
                                    <li><a href="NuevaConsulta.jsp">Nueva Consulta</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas</li>
                                    <li><a href="#">Nueva Cita Laboratorista</a></li>
                                    <li><a href="#">Nueva Cita Medica</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Modificar Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Editar Administrador</a></li>
                                    <li><a href="#">Editar Paciente</a></li>
                                    <li><a href="#">Editar Medico</a></li>
                                    <li><a href="#">Editar Laboratorista</a></li>
                                    <li><a href="#">Editar Examen</a></li>
                                    <li><a href="#">Editar Consulta</a></li>

                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="dropdown-header">Informes</li>
                                    <li><a href="Reporte1_Admin.jsp">Medicos con mas Informes</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Ingresos</li>
                                    <li><a href="Reporte2_Admin.jsp">Ingresos obtenidos por Medico</a></li>
                                    <li><a href="Reporte6_Admin.jsp">Ingresos obtenidos por Paciente</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas</li>
                                    <li><a href="Reporte3_Admin.jsp">Medicos con menos Citas</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Laboratorio</li>
                                    <li><a href="#">Examenes con mayor demanda</a></li>
                                    <li><a href="#">Examenes con mayor demanda por Medicos</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="CerrarSesion">Cerrar Sesion</a></li>
                            <li class="dropdown"><a href=""></a>__________</li>
                            
                            <li class="dropdown"><a href=""><%=(String)request.getSession().getAttribute("nombreUsuario")%></a></li>
                            
                        </ul>
                    </div>
                </div>
            </nav>
        </div>>
