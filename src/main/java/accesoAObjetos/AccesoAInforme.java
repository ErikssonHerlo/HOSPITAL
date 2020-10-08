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
import objetos.Informe;
import objetos.ReporteMedico;
import objetos.ReportePaciente;


/**
 *
 * @author erikssonherlo
 */
public class AccesoAInforme {
    /**
     * La Abreviatura CA = Carga del Archivo, por lo que este metodo sera utilizado unicamente en la carga del archivo.
     * @param informe
     * @return 
     */
    public boolean insertarNuevoInformeCA(Informe informe) {
        String queryDividido1 = "INSERT INTO Informe(idInforme, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Descripcion, Fecha, Hora, Estado, Cita_Medico_Codigo) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del informe a la Tabla Informe
            enviarDividido1.setInt(1, informe.getCodigoInforme());
            enviarDividido1.setString(2, informe.getCodigoPaciente());
            enviarDividido1.setString(3, informe.getCodigoMedico());
            enviarDividido1.setString(4, informe.getDescripcion());
            enviarDividido1.setString(5, informe.getFecha());
            enviarDividido1.setString(6, informe.getHora());
            enviarDividido1.setBoolean(7, informe.isEstado());
            enviarDividido1.setString(8, informe.getCodigoCitaMedica());
            enviarDividido1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
    /**
     * Metodo para agregar nuevos Informes de Citas Medicas Realizadas desde la Vista del Medico
     * @param informe
     * @return 
     */
    
     public boolean insertarNuevoInforme(Informe informe) {
        String queryDividido1 = "INSERT INTO Informe(Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Descripcion, Fecha, Hora, Estado, Cita_Medico_Codigo) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del informe a la Tabla Informe

            enviarDividido1.setString(1, informe.getCodigoPaciente());
            enviarDividido1.setString(2, informe.getCodigoMedico());
            enviarDividido1.setString(3, informe.getDescripcion());
            enviarDividido1.setString(4, informe.getFecha());
            enviarDividido1.setString(5, informe.getHora());
            enviarDividido1.setBoolean(6, informe.isEstado());
            enviarDividido1.setString(7, informe.getCodigoCitaMedica());
            enviarDividido1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
         public List<ReportePaciente> reporte3(String codigoUsuario){
        
        List<ReportePaciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora, i.Cita_Medico_Codigo FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Paciente_Usuario_Codigo = ? ORDER BY i.Fecha DESC LIMIT 5";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new ReportePaciente(rs.getInt("idInforme"), 
                        rs.getString("Nombre"), 
                        rs.getString("Medico"),
                        rs.getString("Descripcion"),                   
                         rs.getString("Fecha"), 
                         rs.getString("Hora"),
                rs.getString("Cita_Medico_Codigo"),
                true)); 
                
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
         /**
          * REUTILIZACION DE LA ESTRUCTURA DEL REPORTE DEL PACIENTE, PARA EL REPORTE NO. 4
          * @param codigoUsuario
          * @return 
          */
           public List<ReportePaciente> reporte4Paciente(String codigoUsuario, String fechaInicio, String fechaFinal, String nombreMedico){
        
        List<ReportePaciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora, i.Cita_Medico_Codigo FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Paciente_Usuario_Codigo = ? AND i.Fecha>= ? AND i.Fecha <=? AND m.Nombre = ? ORDER BY i.Fecha DESC";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        enviar.setString(2, fechaInicio);
        enviar.setString(3, fechaFinal);
        enviar.setString(4, nombreMedico);
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new ReportePaciente(rs.getInt("idInforme"), 
                        rs.getString("Nombre"), 
                        rs.getString("Medico"),
                        rs.getString("Descripcion"),                   
                         rs.getString("Fecha"), 
                         rs.getString("Hora"),
                rs.getString("Cita_Medico_Codigo"),
                true)); 
                
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
                  public List<ReportePaciente> historialMedico(String codigoUsuario){
        
        List<ReportePaciente> historialM = new ArrayList<>();
        historialM.clear();
 
        try {
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora, i.Cita_Medico_Codigo FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Paciente_Usuario_Codigo = ? ORDER BY i.Fecha ASC";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                historialM.add(new ReportePaciente(rs.getInt("idInforme"), 
                        rs.getString("Nombre"), 
                        rs.getString("Medico"),
                        rs.getString("Descripcion"),                   
                         rs.getString("Fecha"), 
                         rs.getString("Hora"),
                rs.getString("Cita_Medico_Codigo"),
                true)); 
                
            }
          
        } catch (Exception e) {

        }
          
    return historialM;
    }
                  
        public List<ReportePaciente> historialMedicoReporte1(){
        
        List<ReportePaciente> historialM = new ArrayList<>();
        historialM.clear();
 
        try {
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora, i.Cita_Medico_Codigo FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo ORDER BY i.Fecha ASC";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
 
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                historialM.add(new ReportePaciente(rs.getInt("idInforme"), 
                        rs.getString("Nombre"), 
                        rs.getString("Medico"),
                        rs.getString("Descripcion"),                   
                         rs.getString("Fecha"), 
                         rs.getString("Hora"),
                rs.getString("Cita_Medico_Codigo"),
                true)); 
                
            }
          
        } catch (Exception e) {

        }
          
    return historialM;
    }
        
        /**
         * Metodo que devuelve una Lista de Objetos de Tipo ReporteMedico y que nos
     * servira para Obtener los Pacientes con Mayor Cantidad de Informes Medicos en un Intervalo de Tiempo
     * Reporte 4 - Medico
         * @param fechaInicio
         * @param fechaFinal
         * @return 
         */
          public List<ReporteMedico> reporte4Medico(String fechaInicio, String fechaFinal) {

        List<ReporteMedico> reporte = new ArrayList<>();
        reporte.clear();

        try {
            String query = "SELECT i.Paciente_Usuario_Codigo AS Paciente, count(Paciente_Usuario_Codigo) AS Total, p.Nombre FROM Informe i INNER JOIN Paciente p ON p.Usuario_Codigo = i.Paciente_Usuario_Codigo WHERE i.Fecha <= ? AND i.Fecha >=? GROUP BY Paciente ORDER BY 2 DESC";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            
            enviar.setString(1, fechaFinal);
            enviar.setString(2, fechaInicio);
            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(new ReporteMedico(rs.getString("Paciente"),
                        rs.getInt("Total"), 
                        rs.getString("Nombre")));
        
                        
                   
            }

        } catch (Exception e) {

        }

        return reporte;
    }
          /**
           * REUTILIZACION DE LA ESTRUCTURA DEL REPORTE 4 PARA EL REPORTE 1 DEL ADMINISTRADOR
           * @param fechaInicio
           * @param fechaFinal
           * @return 
           */
           public List<ReporteMedico> reporte1Admin(String fechaInicio, String fechaFinal) {

        List<ReporteMedico> reporte = new ArrayList<>();
        reporte.clear();

        try {
            String query = "SELECT i.Medico_Usuario_Codigo AS Medico, count(Medico_Usuario_Codigo) AS Cantidad, m.Nombre FROM Informe i INNER JOIN Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Fecha <=? AND i.Fecha >=? GROUP BY Medico ORDER BY 2 DESC LIMIT 10";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            
            enviar.setString(1, fechaFinal);
            enviar.setString(2, fechaInicio);
            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(new ReporteMedico(rs.getString("Medico"),
                        rs.getInt("Cantidad"), 
                        rs.getString("Nombre")));
        
                        
                   
            }

        } catch (Exception e) {

        }

        return reporte;
    }
     
           /**
            * REUTILIZACION DE ESTRUCTURA PARA EL REPORTE NO.1 PARA LA MENOR CANTIDAD DE CITAS AGENDADAS PARA UN MEDICO
            * @param fechaInicio
            * @param fechaFinal
            * @return 
            */
        public List<ReporteMedico> reporte3Admin(String fechaInicio, String fechaFinal) {

        List<ReporteMedico> reporte = new ArrayList<>();
        reporte.clear();

        try {
            String query = "SELECT c.Medico_Usuario_Codigo AS Medico, count(Medico_Usuario_Codigo) AS Cantidad, m.Nombre FROM Cita_Medico c INNER JOIN Medico m ON m.Usuario_Codigo = c.Medico_Usuario_Codigo WHERE c.Fecha <=? AND c.Fecha >=? GROUP BY Medico ORDER BY 2 ASC LIMIT 5";
                        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            
            enviar.setString(1, fechaFinal);
            enviar.setString(2, fechaInicio);
            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(new ReporteMedico(rs.getString("Medico"),
                        rs.getInt("Cantidad"), 
                        rs.getString("Nombre")));
        
                        
                   
            }

        } catch (Exception e) {

        }

        return reporte;
    }
}
