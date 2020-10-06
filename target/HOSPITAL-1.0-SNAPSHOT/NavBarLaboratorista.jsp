<%-- 
    Document   : NavBarLaboratorista
    Created on : 5/10/2020, 13:41:16
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
                        <a class="navbar-brand" href="">Hospital</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
      

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Resultados Examenes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <!-- <li><a href="EjemploArchivos/Guia-1W205777444%20JOSE%20LOPEZ.pdf" target="__blank"/>Nuevo Administrador</li> 
                                    -->
                                   
                                    <li class="dropdown-header">Nuevo</li>
                                    <li><a href="#">Registrar Nuevo Resultado</a></li>
                                   
                                    
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Existente</li>
                                    <li><a href="#">Ver Resultados Existentes</a></li>
                                    
                                    
                                </ul>
                            </li>
                         
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                   
                                    <li class="dropdown-header">Examenes</li>
                                    <li><a href="#">Examenes a Realizar en Turno</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Resultados</li>
                                    <li><a href="#">Examenes Realizados Hoy</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Turnos</li>
                                    <li><a href="#">Utilizacion de Cada Dia de Trabajo</a></li>
                                    <li><a href="#">Fecha con mas Trabajo Realizado</a></li>
                                   
                                </ul>
                            </li>
                            <li class="dropdown"><a href="CerrarSesion">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>>