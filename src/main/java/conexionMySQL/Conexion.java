/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erikssonherlo
 */
public class Conexion {
    private static String url="jdbc:mysql://localhost:3306/HOSPITAL";
    public static Connection conexion = null;
   /* 
    public static Connection obtenerConexion() {
        
        try {
             conexion = (Connection) DriverManager.getConnection(url,"root","Herlo201830459.");
            
                if(conexion != null){
                   System.out.println("Conexion establecida");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar "+ex);
        }
        return conexion;
    }
    */
    //--------------------------------Probando con el metodo de Angel
    public static void crearConexion(){
        if(conexion == null){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSPITAL", "root", "Herlo201830459.");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex){
        System.out.println("Error DB: " + ex.getMessage());
            ex.printStackTrace();
        }
        }
    }
    
    public static Connection getInstance(){
        if(conexion == null){
            conexion = (Connection) new Conexion();
        }
            
        return conexion;
    }
    //-------------------------------------------------
    public static Connection conexionDB() throws SQLException{
        String url="jdbc:mysql://localhost:3306/HOSPITAL";
        return DriverManager.getConnection(url,"root","Herlo201830459.");
    }
    public static void close(Connection cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {

        }
    }
    public static void close(PreparedStatement cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {

        }
    }
            public static ResultSet getTabla(String consulta) {
        Connection cd = conexion;
        Statement st;
        ResultSet datos = null;
        try {
            st = cd.createStatement();
            datos = st.executeQuery(consulta);
        } catch (Exception e) {
        }
        return datos;
    }
            
}
