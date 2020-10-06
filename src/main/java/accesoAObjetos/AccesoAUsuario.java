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
import objetos.Administrador;
import objetos.Laboratorista;
import objetos.Medico;
import objetos.Paciente;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAUsuario {
            public boolean verificarAdminDB(){
        
        Administrador admin = null;
 
        ResultSet rs = Conexion.getTabla("SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario FROM Usuario u INNER JOIN Administrador a ON a.Usuario_Codigo = u.Codigo");
        try {
            while (rs.next()) {
                admin = new Administrador(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"));
                
            }

        } catch (Exception e) {

        }
           if(admin == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
         //INICIO DE SESION PARA EL ADMINISTRADOR
        /**
         * Metodo de Validacion, recibe los parametros desde el formulario, verifica si existe el usuario
         * y si este existe, verifica que su contraseña sea correcta
         * @param codigoUsuario
         * @param password
         * @return
         * @throws SQLException 
         */
        public Administrador loginAdmin(String codigoUsuario, String password) throws SQLException {
        Administrador admin = obtenerAdministrador(codigoUsuario);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
        /**
         * Obtenemos el Administrador con una busqueda entorno a su codigo
         * @param codigoUsuario
         * @return 
         */
      public Administrador obtenerAdministrador(String codigoUsuario){
        
        Administrador admin = null;
 
        try {
        String query ="SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario FROM Usuario u INNER JOIN Administrador a ON a.Usuario_Codigo = u.Codigo WHERE a.Usuario_Codigo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                admin = new Administrador(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"));
                
            }
          
        } catch (Exception e) {

        }
          
    return admin;
    }
      //**************************************************PACIENTE
      /**
       * Metodo para Verificar si la carga de Archivo en la Tabla Paciente fue exitosa
       * @return 
       */
        public boolean verificarPacienteDB(){
        
        Paciente paciente = null;
 
        ResultSet rs = Conexion.getTabla("SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre, p.Estado FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo LIMIT 1");
        try {
            while (rs.next()) {
               paciente = new Paciente(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getString("Sexo"), rs.getString("Nacimiento"), rs.getString("Peso"), rs.getString("Tipo_Sangre"),rs.getBoolean("Estado"));
               
            }

        } catch (Exception e) {

        }
           if(paciente == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
      // INICIO DE SESION PARA EL PACIENTE
      /**
       * Metodo de Validacion, recibe los parametros desde el formulario, verifica si existe el usuario
         * y si este existe, verifica que su contraseña sea correcta
         * Hace falta la Encriptacion
       * @param codigoUsuario
       * @param password
       * @return
       * @throws SQLException 
       */
         public Paciente loginPaciente(String codigoUsuario, String password) throws SQLException {
        Paciente paciente = obtenerPaciente(codigoUsuario);
        if (paciente != null && paciente.getPassword().equals(password)) {
            return paciente;
        }
        return null;
    }
        /**
         * Obtenemos el Paciente con una busqueda entorno a su codigo
         * @param codigoUsuario
         * @return 
         */
      public Paciente obtenerPaciente(String codigoUsuario){
        
        Paciente paciente = null;
 
        try {
        String query ="SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, p.Sexo, p.Nacimiento, p.Peso, p.Tipo_Sangre, p.Estado FROM Usuario u INNER JOIN Paciente p ON p.Usuario_Codigo = u.Codigo WHERE p.Usuario_Codigo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                paciente = new Paciente(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getString("Sexo"), rs.getString("Nacimiento"), rs.getString("Peso"), rs.getString("Tipo_Sangre"),rs.getBoolean("Estado"));
                
            }
          
        } catch (Exception e) {

        }
          
    return paciente;
    }
      
      
            //**************************************************MEDICO
      /**
       * Metodo para Verificar si la carga de Archivo fue exitosa
       * @return 
       */
        public boolean verificarMedicoDB(){
        
        Medico medico = null;
 
        ResultSet rs = Conexion.getTabla("SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, m.Estado FROM Usuario u INNER JOIN Medico m ON m.Usuario_Codigo = u.Codigo LIMIT 1");
        try {
            while (rs.next()) {
               medico = new Medico(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getInt("Colegiado"), rs.getString("Hora_Entrada"), rs.getString("Hora_Salida"), rs.getString("Fecha_Inicio"),rs.getBoolean("Estado"));
               
            }

        } catch (Exception e) {

        }
           if(medico == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
      // INICIO DE SESION PARA EL MEDICO

        /**
         * Obtenemos el Medico con una busqueda entorno a su codigo
         * @param codigoUsuario
         * @return 
         */
      public Medico obtenerMedico(String codigoUsuario){
        
        Medico medico = null;
 
        try {
        String query ="SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, m.Colegiado, m.Hora_Entrada, m.Hora_Salida, m.Fecha_Inicio, m.Estado FROM Usuario u INNER JOIN Medico m ON m.Usuario_Codigo = u.Codigo WHERE m.Usuario_Codigo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
             medico = new Medico(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getInt("Colegiado"), rs.getString("Hora_Entrada"), rs.getString("Hora_Salida"), rs.getString("Fecha_Inicio"),rs.getBoolean("Estado"));
     
            }
          
        } catch (Exception e) {

        }
          
    return medico;
    }
            /**
       * Metodo de Validacion, recibe los parametros desde el formulario, verifica si existe el usuario
         * y si este existe, verifica que su contraseña sea correcta
         * Hace falta la Encriptacion
       * @param codigoUsuario
       * @param password
       * @return
       * @throws SQLException 
       */
         public Medico loginMedico(String codigoUsuario, String password) throws SQLException {
        Medico medico = obtenerMedico(codigoUsuario);
        if (medico != null && medico.getPassword().equals(password)) {
            return medico;
        }
        return null;
    }
      
      
         
            //**************************************************LABORATORISTA
      /**
       * Metodo para Verificar si la carga de Archivo para la Tabla Laboratorista fue exitosa
       * @return 
       */
        public boolean verificarLaboratoristaDB(){
        
        Laboratorista laboratorista = null;
 
        ResultSet rs = Conexion.getTabla("SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, l.Registro, l.Nombre_Examen, l.Fecha_Inicio, l.Estado, l.Examen_Codigo FROM Usuario u INNER JOIN Laboratorista l ON l.Usuario_Codigo = u.Codigo LIMIT 1");
        try {
            while (rs.next()) {
               laboratorista = new Laboratorista(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getString("Registro"), rs.getString("Nombre_Examen"),  rs.getString("Fecha_Inicio"),rs.getBoolean("Estado"),rs.getInt("Examen_Codigo"));
               
            }

        } catch (Exception e) {

        }
           if(laboratorista == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
      // INICIO DE SESION PARA EL LABORATORISTA

        /**
         * Obtenemos el Medico con una busqueda entorno a su codigo
         * @param codigoUsuario
         * @return 
         */
      public Laboratorista obtenerLaboratorista(String codigoUsuario){
        
        Laboratorista laboratorista = null;
 
        try {
        String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario, l.Registro, l.Nombre_Examen, l.Fecha_Inicio, l.Estado, l.Examen_Codigo FROM Usuario u INNER JOIN Laboratorista l ON l.Usuario_Codigo = u.Codigo WHERE l.Usuario_Codigo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoUsuario);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
        laboratorista = new Laboratorista(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"),rs.getString("Registro"), rs.getString("Nombre_Examen"),  rs.getString("Fecha_Inicio"),rs.getBoolean("Estado"),rs.getInt("Examen_Codigo"));
 
            }
          
        } catch (Exception e) {

        }
          
    return laboratorista;
    }
            /**
       * Metodo de Validacion, recibe los parametros desde el formulario, verifica si existe el usuario
         * y si este existe, verifica que su contraseña sea correcta
         * Hace falta la Encriptacion
       * @param codigoUsuario
       * @param password
       * @return
       * @throws SQLException 
       */
         public Laboratorista loginLaboratorista(String codigoUsuario, String password) throws SQLException {
        Laboratorista laboratorista = obtenerLaboratorista(codigoUsuario);
        if (laboratorista != null && laboratorista.getPassword().equals(password)) {
            return laboratorista;
        }
        return null;
    }
}
