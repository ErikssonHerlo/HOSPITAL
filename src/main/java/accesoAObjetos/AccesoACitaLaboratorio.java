/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.CitaLaboratorio;

/**
 *
 * @author erikssonherlo
 */
public class AccesoACitaLaboratorio {
        
        //------------PENDIENTE DE CULMINAR DEBIDO A LA CARGA DEL ARCHIVO PDF A ESTA TABLA
        public void insertarCitaLaboratorio(CitaLaboratorio citaLaboratorio) {
        String queryDividido1 = "INSERT INTO Cita_Laboratorio(Paciente_Usuario_Codigo, Laboratorista_Usuario_Codigo, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales de la Cita al Laboratorio a la Tabla citaLaboratorio
            enviarDividido1.setString(1, citaLaboratorio.getCodigoPaciente());
            enviarDividido1.setString(2, citaLaboratorio.getCodigoLaboratorista());
            enviarDividido1.setString(3, citaLaboratorio.getFecha());
            enviarDividido1.setString(4, citaLaboratorio.getHora());
            enviarDividido1.setBoolean(5, citaLaboratorio.isEstado());
            enviarDividido1.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    
}
