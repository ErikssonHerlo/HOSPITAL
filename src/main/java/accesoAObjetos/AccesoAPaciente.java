/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Paciente;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAPaciente {

    public boolean insertarNuevoPaciente(Paciente paciente) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Paciente(Usuario_Codigo, Sexo, Nacimiento, Peso, Tipo_Sangre, Estado) "
                + "VALUES(?,?,?,?,?,?)";

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
            enviarDividido2.setString(2, paciente.getSexo());
            enviarDividido2.setString(3, paciente.getNacimiento());
            enviarDividido2.setString(4, paciente.getPeso());
            enviarDividido2.setString(5, paciente.getTipoSangre());
            enviarDividido2.setBoolean(6, paciente.isEstado());
            enviarDividido2.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
}
