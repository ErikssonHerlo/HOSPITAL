/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.CitaMedico;

/**
 *
 * @author erikssonherlo
 */
public class AccesoACitaMedico {

    /**
     *
     * El Nombre del Metodo y la Abreviatura CA = Carga del Archivo indican que
     * este metodo se utilizara solo para la Carga del Archivo XML
     */
    public void insertarCitaMedicoCA(CitaMedico citaMedico) {
        String queryDividido1 = "INSERT INTO Cita_Medico(Codigo, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Especialidad, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales de la Cita de un Medico a la Tabla Cita_Medico
            enviarDividido1.setInt(1, citaMedico.getCodigo());
            enviarDividido1.setString(2, citaMedico.getCodigoPaciente());
            enviarDividido1.setString(3, citaMedico.getCodigoMedico());
            enviarDividido1.setString(4, citaMedico.getEspecialidad());
            enviarDividido1.setString(5, citaMedico.getFecha());
            enviarDividido1.setString(6, citaMedico.getHora());
            enviarDividido1.setBoolean(7, citaMedico.isEstado());
            enviarDividido1.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    /**
     *
     * Segundo Metodo para la Creacion de una Nueva Cita con el Medico, la cual
     * podra ser realizada por el Cliente, el Medico o el Administrador desde la
     * Vista o el Frontend
     */
        public void insertarCitaMedico(CitaMedico citaMedico) {
        String queryDividido1 = "INSERT INTO Cita_Medico(Codigo, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Especialidad, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales de la Cita de un Medico a la Tabla Cita_Medico
            enviarDividido1.setInt(1, citaMedico.getCodigo());
            enviarDividido1.setString(2, citaMedico.getCodigoPaciente());
            enviarDividido1.setString(3, citaMedico.getCodigoMedico());
            enviarDividido1.setString(4, citaMedico.getEspecialidad());
            enviarDividido1.setString(5, citaMedico.getFecha());
            enviarDividido1.setString(6, citaMedico.getHora());
            enviarDividido1.setBoolean(7, citaMedico.isEstado());
            enviarDividido1.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
