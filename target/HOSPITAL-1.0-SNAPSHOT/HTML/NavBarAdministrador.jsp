<%-- 
    Document   : NavBarAdministrador
    Created on : 2/10/2020, 04:31:12
    Author     : erikssonherlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                        <a class="navbar-brand" href="../Administrador/InicioAdmin.jsp">Hospital</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <!-- <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li> 
                                    -->
                                   
                                    <li class="dropdown-header">Usuarios</li>
                                    <li><a href="#">Pacientes</a></li>
                                    <li><a href="#">Medicos</a></li>
                                    <li><a href="#">Laboratoristas</a></li>
                                    <li><a href="#">Administradores</a></li>
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Servicios</li>
                                    <li><a href="#">Examenes</a></li>
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agregar Nueva Informacion <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li>
                                    <li><a href="#">Nuevo Paciente</a></li>
                                    <li><a href="#">Nuevo Medico</a></li>
                                    <li><a href="#">Nuevo Laboratorista</a></li>
                                    <li><a href="#">Nuevo Examen</a></li>
                                    <li><a href="#">Nueva Consulta</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas</li>
                                    <li><a href="#">Nueva Cita Laboratorista</a></li>
                                    <li><a href="#">Nueva Cita Medica</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Modificar Informacion <span class="caret"></span></a>
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="dropdown-header">Informes</li>
                                    <li><a href="#">Medicos con mas Informes</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Ingresos</li>
                                    <li><a href="#">Ingresos obtenidos por Medico</a></li>
                                    <li><a href="#">Ingresos obtenidos por Paciente</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Citas</li>
                                    <li><a href="#">Medicos con menos Citas</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Laboratorio</li>
                                    <li><a href="#">Examenes con mayor demanda</a></li>
                                    <li><a href="#">Examenes con mayor demanda por Medicos</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="#">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>>
</html>
