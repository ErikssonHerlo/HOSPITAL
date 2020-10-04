/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Administrador;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAAdministrador {
    
    public boolean insertarNuevoAdministrador(Administrador administrador) {
        
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Administrador(Usuario_Codigo) "
                + "VALUES(?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del administrador a la Tabla Usuario
            enviarDividido1.setString(1, administrador.getCodigo());
            enviarDividido1.setString(2, administrador.getNombre());
            enviarDividido1.setString(3, administrador.getDPI());
            enviarDividido1.setString(4, administrador.getTelefono());
            enviarDividido1.setString(5, administrador.getCorreo());
            enviarDividido1.setString(6, administrador.getPassword());
            enviarDividido1.setInt(7, 1);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Administrador a la tabla administrador
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, administrador.getCodigo());
            enviarDividido2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
       

    }
}
