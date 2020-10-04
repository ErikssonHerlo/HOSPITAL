/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Consulta;


/**
 *
 * @author erikssonherlo
 */
public class AccesoAConsulta {
        public void insertarNuevaConsulta(Consulta consulta) {
        String queryDividido1 = "INSERT INTO Consulta(Tipo, Costo) "
                + "VALUES(?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales de la consulta a la Tabla Consulta
            enviarDividido1.setString(1, consulta.getTipo());
            enviarDividido1.setDouble(2, consulta.getCosto());
            enviarDividido1.executeUpdate();

           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
