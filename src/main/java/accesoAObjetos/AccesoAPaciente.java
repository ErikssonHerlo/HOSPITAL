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
import objetos.Paciente;
import objetos.ReportePaciente;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAPaciente {

    public boolean insertarNuevoPaciente(Paciente paciente) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Paciente(Usuario_Codigo, Nombre, Sexo, Nacimiento, Peso, Tipo_Sangre, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del Paciente a la Tabla Usuario
            enviarDividido1.setString(1, paciente.getCodigo());
            enviarDividido1.setString(2, paciente.getNombre());
            enviarDividido1.setString(3, paciente.getDPI());
            enviarDividido1.setString(4, paciente.getTelefono());
            enviarDividido1.setString(5, paciente.getCorreo());
            enviarDividido1.setString(6, paciente.getPassword());
            enviarDividido1.setInt(7, 3);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Paciente a la tabla Paciente
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, paciente.getCodigo());
             enviarDividido2.setString(2, paciente.getNombre());
            enviarDividido2.setString(3, paciente.getSexo());
            enviarDividido2.setString(4, paciente.getNacimiento());
            enviarDividido2.setString(5, paciente.getPeso());
            enviarDividido2.setString(6, paciente.getTipoSangre());
            enviarDividido2.setBoolean(7, paciente.isEstado());
            enviarDividido2.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
    /**
     * METODO PARA LISTAR A TODOS LOS PACIENTES INGRESADOS EN LA BASE DE DATOS
     * @return 
     */
    public List<Paciente> listarPacientes(){
        
        List<Paciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo";    
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Paciente(rs.getString("Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("DPI"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        "vacio", 3, rs.getString("Sexo"),
                        rs.getString("Nacimiento"),
                        rs.getString("Peso"),
                        rs.getString("Tipo_Sangre"),
                        true));
                        
                     
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
    /**
     * METODO PARA LISTAR PACIENTES POR NOMBRE
     * @param nombre
     * @return 
     */
    public List<Paciente> listarPacientesNombre(String nombre){
        
        List<Paciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo WHERE p.Nombre = ?";    
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
         enviar.setString(1, nombre);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Paciente(rs.getString("Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("DPI"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        "vacio", 3, rs.getString("Sexo"),
                        rs.getString("Nacimiento"),
                        rs.getString("Peso"),
                        rs.getString("Tipo_Sangre"),
                        true));
                        
                     
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
    /**
     * METODO PARA LISTAR PACIENTES POR CODIGO
     * @param codigo
     * @return 
     */
        public List<Paciente> listarPacientesCodigo(String codigo){
        
        List<Paciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo WHERE p.Usuario_Codigo = ?";    
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
         enviar.setString(1, codigo);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Paciente(rs.getString("Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("DPI"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        "vacio", 3, rs.getString("Sexo"),
                        rs.getString("Nacimiento"),
                        rs.getString("Peso"),
                        rs.getString("Tipo_Sangre"),
                        true));
                        
                     
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
        /**
         * METODO PARA LISTAR PACIENTES POR MEDIO DE CODIGO Y NOMBRE
         * @param codigo
         * @param nombre
         * @return 
         */
          public List<Paciente> listarPacientesCodigoNombre(String codigo, String nombre){
        
        List<Paciente> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo WHERE p.Usuario_Codigo = ? AND p.Nombre = ?";    
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
         enviar.setString(1, codigo);
         enviar.setString(2, nombre);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Paciente(rs.getString("Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("DPI"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        "vacio", 3, rs.getString("Sexo"),
                        rs.getString("Nacimiento"),
                        rs.getString("Peso"),
                        rs.getString("Tipo_Sangre"),
                        true));
                             
                
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
}
