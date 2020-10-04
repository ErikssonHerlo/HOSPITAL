/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Informe;


/**
 *
 * @author erikssonherlo
 */
public class AccesoAInforme {
    /**
     * La Abreviatura CA = Carga del Archivo, por lo que este metodo sera utilizado unicamente en la carga del archivo.
     * @param informe
     * @return 
     */
    public boolean insertarNuevoInformeCA(Informe informe) {
        String queryDividido1 = "INSERT INTO Informe(idInforme, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Descripcion, Fecha, Hora, Estado) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del informe a la Tabla Informe
            enviarDividido1.setInt(1, informe.getCodigoInforme());
            enviarDividido1.setString(2, informe.getCodigoPaciente());
            enviarDividido1.setString(3, informe.getCodigoMedico());
            enviarDividido1.setString(4, informe.getDescripcion());
            enviarDividido1.setString(5, informe.getFecha());
            enviarDividido1.setString(6, informe.getHora());
            enviarDividido1.setBoolean(7, informe.isEstado());
            enviarDividido1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }
}
