/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Laboratorista;
import objetos.Turno;

/**
 *
 * @author erikssonherlo
 */
public class AccesoALaboratorista {

    public void insertarNuevoLaboratorista(Laboratorista laboratorista, Turno turno) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Laboratorista(Usuario_Codigo, Registro, Nombre_Examen, Fecha_Inicio, Estado) "
                + "VALUES(?,?,?,?,?)";

        String queryDividido3 = "INSERT INTO Turno(Dia_Turno, Laboratorista_Usuario_Codigo) "
                + "VALUES(?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del Laboratorista a la Tabla Usuario
            enviarDividido1.setString(1, laboratorista.getCodigo());
            enviarDividido1.setString(2, laboratorista.getNombre());
            enviarDividido1.setString(3, laboratorista.getDPI());
            enviarDividido1.setString(4, laboratorista.getTelefono());
            enviarDividido1.setString(5, laboratorista.getCorreo());
            enviarDividido1.setString(6, laboratorista.getPassword());
            enviarDividido1.setInt(7, 2);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Laboratorista a la Tabla Laboratorista
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, laboratorista.getCodigo());
            enviarDividido2.setString(2, laboratorista.getRegistro());
            enviarDividido2.setString(3, laboratorista.getNombreExamen());
            enviarDividido2.setString(4, laboratorista.getFechaInicio());
            enviarDividido2.setBoolean(5, laboratorista.isEstado());
            enviarDividido2.executeUpdate();

            //Envio de los Datos del Turno Perteneciente a un Laboratorista en la Tabla Turno
            PreparedStatement enviarDividido3 = Conexion.conexion.prepareStatement(queryDividido3);
           //USO DE FOREACH CON ARRAYLIST
            for (int i = 0;i<=turno.getDiaTurno().size();i++) {  
                enviarDividido3.setString(1, turno.getDiaTurno().get(i).toString());
                enviarDividido3.setString(2, laboratorista.getCodigo()); //Envio del Codigo del laboratorista, al cual se le asigno dicho Turno
                enviarDividido3.executeUpdate();
            }
           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
