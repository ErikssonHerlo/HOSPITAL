/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Examen;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAExamen {

    public void insertarNuevoExamen(Examen examen) {
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

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
