/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Administrador;
import objetos.ReportePaciente;
import objetos.Resultado;



/**
 *
 * @author erikssonherlo
 */
public class AccesoAResultado {
    /**
     * La Abreviatura CA = Carga del Archivo, por lo que este metodo sera utilizado unicamente en la carga del archivo.
     * @param resultado
     * @return 
     */
  
    public boolean insertarNuevoResultadoCA(Resultado resultado) {
        String queryDividido1 = "INSERT INTO Resultado(Codigo_Resultado, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Laboratorista_Usuario_Codigo, Examen_Codigo, Orden, Informe_Examen, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del resultado a la Tabla resultado
            enviarDividido1.setInt(1, resultado.getCodigo());
            enviarDividido1.setString(2, resultado.getCodigoPaciente());
            enviarDividido1.setString(3, resultado.getCodigoMedico());
            enviarDividido1.setString(4, resultado.getCodigoLaboratorista());
            enviarDividido1.setInt(5, resultado.getCodigoExamen());
            enviarDividido1.setString(6, resultado.getOrden());
            enviarDividido1.setString(7, resultado.getInformeExamen());
            enviarDividido1.setString(8, resultado.getFecha());
            enviarDividido1.setString(9, resultado.getHora());
            enviarDividido1.setBoolean(10, resultado.isEstado());
            enviarDividido1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
    
     public List<ReportePaciente> reporte1(String codigoUsuario){
        
        List<ReportePaciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT r.Codigo_Resultado, u.Nombre, l.Nombre AS Laboratorista, e.Nombre AS Nombre_Examen, r.Informe_Examen, r.Fecha, r.Hora FROM Usuario u INNER JOIN Resultado r ON u.Codigo = r.Paciente_Usuario_Codigo INNER JOIN Examen e ON e.Codigo = r.Examen_Codigo INNER JOIN Laboratorista l ON l.Usuario_Codigo = r.Laboratorista_Usuario_Codigo WHERE r.Paciente_Usuario_Codigo = ? ORDER BY r.Fecha DESC LIMIT 5";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new ReportePaciente(rs.getInt("Codigo_Resultado"),
                        rs.getString("Nombre"),
                        rs.getString("Laboratorista"), 
                        rs.getString("Nombre_Examen"), 
                         rs.getString("Informe_Examen"), 
                         rs.getString("Fecha"), 
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
     
     /**
      * REUTILIZACION DE LA ESTRUCTURA PARA EL REPORTE NO, 2
      * @param codigoUsuario
      * @return 
      */
public List<ReportePaciente> reporte2Paciente(String codigoUsuario, String fechaInicio, String fechaFinal, String nombreExamen){
        
        List<ReportePaciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT r.Codigo_Resultado, u.Nombre, l.Nombre AS Laboratorista, e.Nombre AS Nombre_Examen, r.Informe_Examen, r.Fecha, r.Hora FROM Usuario u INNER JOIN Resultado r ON u.Codigo = r.Paciente_Usuario_Codigo INNER JOIN Examen e ON e.Codigo = r.Examen_Codigo INNER JOIN Laboratorista l ON l.Usuario_Codigo = r.Laboratorista_Usuario_Codigo WHERE r.Paciente_Usuario_Codigo = ? AND r.Fecha >= ? AND r.Fecha <= ? AND e.Nombre = ? ORDER BY r.Fecha DESC";
                    
         PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        enviar.setString(2, fechaInicio);
        enviar.setString(3, fechaFinal);
        enviar.setString(4, nombreExamen);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new ReportePaciente(rs.getInt("Codigo_Resultado"),
                        rs.getString("Nombre"),
                        rs.getString("Laboratorista"), 
                        rs.getString("Nombre_Examen"), 
                         rs.getString("Informe_Examen"), 
                         rs.getString("Fecha"), 
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
     



     public List<ReportePaciente> historialLaboratorio(String codigoUsuario){
        
        List<ReportePaciente> historialLab = new ArrayList<>();
        historialLab.clear();
 
        try {
            String query = "SELECT r.Codigo_Resultado, u.Nombre, l.Nombre AS Laboratorista, e.Nombre AS Nombre_Examen, r.Informe_Examen, r.Fecha, r.Hora FROM Usuario u INNER JOIN Resultado r ON u.Codigo = r.Paciente_Usuario_Codigo INNER JOIN Examen e ON e.Codigo = r.Examen_Codigo INNER JOIN Laboratorista l ON l.Usuario_Codigo = r.Laboratorista_Usuario_Codigo WHERE r.Paciente_Usuario_Codigo = ? ORDER BY r.Fecha ASC";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                historialLab.add(new ReportePaciente(rs.getInt("Codigo_Resultado"),
                        rs.getString("Nombre"),
                        rs.getString("Laboratorista"), 
                        rs.getString("Nombre_Examen"), 
                         rs.getString("Informe_Examen"), 
                         rs.getString("Fecha"), 
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return historialLab;
    }
           public List<ReportePaciente> historialLaboratorioReporte1(){
        
        List<ReportePaciente> historialLab = new ArrayList<>();
        historialLab.clear();
 
        try {
            String query = "SELECT r.Codigo_Resultado, u.Nombre, l.Nombre AS Laboratorista, e.Nombre AS Nombre_Examen, r.Informe_Examen, r.Fecha, r.Hora FROM Usuario u INNER JOIN Resultado r ON u.Codigo = r.Paciente_Usuario_Codigo INNER JOIN Examen e ON e.Codigo = r.Examen_Codigo INNER JOIN Laboratorista l ON l.Usuario_Codigo = r.Laboratorista_Usuario_Codigo ORDER BY r.Fecha ASC";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                historialLab.add(new ReportePaciente(rs.getInt("Codigo_Resultado"),
                        rs.getString("Nombre"),
                        rs.getString("Laboratorista"), 
                        rs.getString("Nombre_Examen"), 
                         rs.getString("Informe_Examen"), 
                         rs.getString("Fecha"), 
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return historialLab;
    }
}
