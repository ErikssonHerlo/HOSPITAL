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
import objetos.Especialidad;
import objetos.Medico;
import objetos.ReporteMedico;
import objetos.ReportePaciente;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAMedico {

    public boolean insertarNuevoMedico(Medico medico, Especialidad especialidad) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Medico(Usuario_Codigo, Nombre, Colegiado, Hora_Entrada, Hora_Salida, Fecha_Inicio, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido3 = "INSERT INTO Especialidad(Titulo, Estado, Medico_Usuario_Codigo) "
                + "VALUES(?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del Medico a la Tabla Usuario
            enviarDividido1.setString(1, medico.getCodigo());
            enviarDividido1.setString(2, medico.getNombre());
            enviarDividido1.setString(3, medico.getDPI());
            enviarDividido1.setString(4, medico.getTelefono());
            enviarDividido1.setString(5, medico.getCorreo());
            enviarDividido1.setString(6, medico.getPassword());
            enviarDividido1.setInt(7, 4);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Medico a la Tabla Medico
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, medico.getCodigo());
            enviarDividido2.setString(2, medico.getNombre());
            enviarDividido2.setInt(3, medico.getColegiado());
            enviarDividido2.setString(4, medico.getHoraEntrada());
            enviarDividido2.setString(5, medico.getHoraSalida());
            enviarDividido2.setString(6, medico.getFechaInicio());
            enviarDividido2.setBoolean(7, medico.isEstado());
            enviarDividido2.executeUpdate();

            ////Envio de los Datos de la Especialidad perteneciente a un Medico en Especifico en la Tabla Especialidad
            PreparedStatement enviarDividido3 = Conexion.conexion.prepareStatement(queryDividido3);
            
            for(int i=0; i< especialidad.getTitulo().size();i++){
                enviarDividido3.setString(1, especialidad.getTitulo().get(i).toString());
                enviarDividido3.setBoolean(2, especialidad.isEstado());
                enviarDividido3.setString(3, medico.getCodigo()); //Envio del Codigo del Medico, al cual se le asigno dicha especialidad
                enviarDividido3.executeUpdate();
            }
           return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
    /**
     * METODO PARA LA BUSQUEDA GENERAL DE LOS MEDICOS
     * @return 
     */
         public List<ReporteMedico> busquedaGeneral(){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
   /**
    * BUSQUEDA POR NOMBRE DEL MEDICO
    * N = NOMBRE
    * @param nombre
    * @return 
    */
        public List<ReporteMedico> busquedaN(String nombre){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE m.Nombre = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, nombre);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
        /**
         * BUSQUEDA DE MEDICO POR ESPECIALIDAD
         * E = ESPECIALIDAD
         * @param titulo
         * @return 
         */
                public List<ReporteMedico> busquedaE(String titulo){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE e.Titulo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, titulo);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
                
         /**
          * BUSQUEDA DE MEDICO POR HORARIO DE ATENCION
          * @param horario
          * @return 
          */       
        public List<ReporteMedico> busquedaH(String horario){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE m.Hora_Entrada <= ? AND m.Hora_Salida > ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, horario);
        enviar.setString(2, horario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
        /**
         * BUSQUEDA DE MEDICO PRO NOMBRE Y ESPECIALIDAD
         * @param nombre
         * @param titulo
         * @return 
         */
   public List<ReporteMedico> busquedaNE(String nombre, String titulo){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE m.Nombre = ? AND e.Titulo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, nombre);
        enviar.setString(2, titulo);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
   /**
    * BUSQUEDA DE MEDICO POR NOMBRE Y HORARIO
    * @param nombre
    * @param horario
    * @return 
    */
      public List<ReporteMedico> busquedaNH(String nombre, String horario){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE m.Nombre = ? AND m.Hora_Entrada <= ? AND m.Hora_Salida > ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, nombre);
        enviar.setString(2, horario);
        enviar.setString(3, horario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
/**
 * BUSQUEDA POR ESPECIALIDAD Y HORARIO
 * @param titulo
 * @param horario
 * @return 
 */
       public List<ReporteMedico> busquedaEH(String titulo, String horario){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE e.Titulo = ? AND m.Hora_Entrada <= ? AND m.Hora_Salida > ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, titulo);
        enviar.setString(2, horario);
        enviar.setString(3, horario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
       
       /**
        * BUSQUEDA DE MEDICO POR NOMBRE, ESPECIALIDAD Y HORARIO
        * @param nombre
        * @param titulo
        * @param horario
        * @return 
        */
        public List<ReporteMedico> busquedaNEH(String nombre, String titulo, String horario){
        
        List<ReporteMedico> busqueda = new ArrayList<>();
        busqueda.clear();
 
        try {
            String query = "SELECT m.Usuario_Codigo, m.Nombre, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, e.Titulo FROM Medico m INNER JOIN Especialidad e ON m.Usuario_Codigo = e.Medico_Usuario_Codigo WHERE m.Nombre = ? AND e.Titulo = ? AND m.Hora_Entrada <= ? AND m.Hora_Salida > ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        enviar.setString(1, nombre);
        enviar.setString(2, titulo);
        enviar.setString(3, horario);
        enviar.setString(4, horario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                busqueda.add(new ReporteMedico(rs.getString("Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getInt("Colegiado"), 
                        rs.getString("Hora_Entrada"), 
                        rs.getString("Hora_Salida"),
                        rs.getString("Fecha_Inicio"),
                        rs.getString("Titulo")));
                                        
            }
          
        } catch (Exception e) {

        }
          
    return busqueda;
    }
}
