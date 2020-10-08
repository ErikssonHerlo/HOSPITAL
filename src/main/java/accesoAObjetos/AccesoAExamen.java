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
import objetos.Examen;
import objetos.Medico;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAExamen {
/**
 * METODO QUE RECIBE UN OBJETO DE TIPO EXAMEN, OBTIENE SUS ATRIBUTOS Y ENVIA LOS DATOS DE UN NUEVO EXAMEN A LA BASE DE DATOS
 * UTILIZADO PARA LA CARGA DEL ARCHIVO XML Y LA CREACION DE NUEVOS EXAMENES DESDE LA VISTA DEL ADMINISTRADOR
 * @param examen
 * @return 
 */
    public boolean insertarNuevoExamen(Examen examen) {
        String queryDividido1 = "INSERT INTO Examen(Codigo, Nombre, Orden, Descripcion, Costo, Formato, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del examen a la Tabla Examen
            enviarDividido1.setInt(1, examen.getCodigoExamen());
            enviarDividido1.setString(2, examen.getNombre());
            enviarDividido1.setBoolean(3, examen.isOrden());
            enviarDividido1.setString(4, examen.getDescripcion());
            enviarDividido1.setDouble(5, examen.getCosto());
            enviarDividido1.setString(6, examen.getFormato());
            enviarDividido1.setBoolean(7, examen.isEstado());
            enviarDividido1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }

      public List<Examen> listarExamenes(){
        
        List<Examen> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT Codigo, Nombre, Orden, Descripcion, Costo, Formato FROM Examen"; 
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
       
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Examen(rs.getInt("Codigo"),
                        rs.getString("Nombre"),
                        rs.getBoolean("Orden"),
                        rs.getString("Descripcion"), 
                        rs.getDouble("Costo"),
                        rs.getString("Formato"), true));                                        
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
}
