/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import objetos.Especialidad;
import objetos.Medico;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAMedico {

    public void insertarNuevoMedico(Medico medico, Especialidad especialidad) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Medico(Usuario_Codigo, Colegiado, Hora_Entrada, Hora_Salida, Fecha_Inicio, Estado) "
                + "VALUES(?,?,?,?,?,?)";

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
            enviarDividido2.setInt(2, medico.getColegiado());
            enviarDividido2.setString(3, medico.getHoraEntrada());
            enviarDividido2.setString(4, medico.getHoraSalida());
            enviarDividido2.setString(5, medico.getFechaInicio());
            enviarDividido2.setBoolean(6, medico.isEstado());
            enviarDividido2.executeUpdate();

            ////Envio de los Datos de la Especialidad perteneciente a un Medico en Especifico en la Tabla Especialidad
            PreparedStatement enviarDividido3 = Conexion.conexion.prepareStatement(queryDividido3);
            //ERROR DEBIDO A QUE NECESITO RECORRER UN ARRAYLIST Y NO SE COMO
            
            for(int i=0; i< especialidad.getTitulo().size();i++){
                enviarDividido3.setString(1, especialidad.getTitulo().get(i).toString());
                enviarDividido3.setBoolean(2, especialidad.isEstado());
                enviarDividido3.setString(3, medico.getCodigo()); //Envio del Codigo del Medico, al cual se le asigno dicha especialidad
                enviarDividido3.executeUpdate();
            }
           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
