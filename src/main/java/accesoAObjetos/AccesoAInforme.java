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
        String queryDividido1 = "INSERT INTO Informe(idInforme, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Descripcion, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

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
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Paciente_Usuario_Codigo = ? ORDER BY i.Fecha DESC LIMIT 5";
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
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
         
                  public List<ReportePaciente> historialMedico(String codigoUsuario){
        
        List<ReportePaciente> historialM = new ArrayList<>();
        historialM.clear();
 
        try {
            String query = "SELECT i.idInforme, u.Nombre, m.Nombre AS Medico, i.Descripcion, i.Fecha, i.Hora FROM Usuario u INNER JOIN Informe i ON u.Codigo = i.Paciente_Usuario_Codigo INNER JOIN  Medico m ON m.Usuario_Codigo = i.Medico_Usuario_Codigo WHERE i.Paciente_Usuario_Codigo = ? ORDER BY i.Fecha ASC";
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
                         rs.getString("Hora"))); 
                
            }
          
        } catch (Exception e) {

        }
          
    return historialM;
    }
}
