/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import objetos.CitaMedico;
import objetos.ReporteMedico;
import objetos.ReportePaciente;

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
    public boolean insertarCitaMedicoCA(CitaMedico citaMedico) {
        //SI LA FECHA, HORA Y MEDICO ESTAN DISPONIBLES, SE HACE LA INSERCION DE DATOS
        if (verificarFHM(citaMedico.getCodigoMedico(), citaMedico.getFecha(), citaMedico.getHora())) {
            String queryDividido1 = "INSERT INTO Cita_Medico(Codigo, Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Consulta_Tipo, Fecha, Hora, Estado) "
                    + "VALUES(?,?,?,?,?,?,?)";

            String queryDividido2 = "INSERT INTO Ingresos_Medico(Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Fecha, Total, Cita_Medico_Codigo) "
                    + "VALUES(?,?,?, (SELECT Costo FROM Consulta WHERE Tipo = ? LIMIT 1),?)";

            try {

                PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

                //Envio de los Datos Principales de la Cita de un Medico a la Tabla Cita_Medico
                enviarDividido1.setInt(1, citaMedico.getCodigo());
                enviarDividido1.setString(2, citaMedico.getCodigoPaciente());
                enviarDividido1.setString(3, citaMedico.getCodigoMedico());
                enviarDividido1.setString(4, citaMedico.getTipoConsulta());
                enviarDividido1.setString(5, citaMedico.getFecha());
                enviarDividido1.setString(6, citaMedico.getHora());
                enviarDividido1.setBoolean(7, citaMedico.isEstado());
                enviarDividido1.executeUpdate();

                PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);

                //Envio de los Datos Principales de la Cita de un Medico a la Tabla Ingresos_Medico
                enviarDividido2.setString(1, citaMedico.getCodigoPaciente());
                enviarDividido2.setString(2, citaMedico.getCodigoMedico());
                enviarDividido2.setString(3, citaMedico.getFecha());
                enviarDividido2.setString(4, citaMedico.getTipoConsulta());
                enviarDividido2.setInt(5, citaMedico.getCodigo());

                enviarDividido2.executeUpdate();
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                return false;
            }
            //SI LA FECHA ESTA OCUPADA, NO SE INGRESA 
        } else {
            return false;
        }

    }

    /**
     * METODO QUE VERIFICA SI UN MEDICO ESTA DISPONIBLE PARA AGENDAR UNA CITA EN
     * UNA FECHA Y HORARIO ESPECIFICO
     *
     * @param codigoMedico
     * @param fechaCita
     * @param horaCita
     * @return
     */
    public boolean verificarFHM(String codigoMedico, String fechaCita, String horaCita) {

        List<String> reporte = new ArrayList<>();
        reporte.clear();
        try {
            String query = "SELECT Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Fecha, Hora FROM Cita_Medico WHERE Medico_Usuario_Codigo = ? AND Fecha = ? AND Hora = ? LIMIT 1";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            enviar.setString(1, codigoMedico);
            enviar.setString(2, fechaCita);
            enviar.setString(3, horaCita);
            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(rs.getString("Paciente_Usuario_Codigo"));
                reporte.add(rs.getString("Medico_Usuario_Codigo"));
                reporte.add(rs.getString("Fecha"));
                reporte.add(rs.getString("Hora"));

            }

        } catch (Exception e) {

        }

        if (reporte.isEmpty()) {
            //SI EL REPORTE SE ENCUENTRA VACIO, ES PORQUE LA FECHA ESTA DISPONIBLE
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Segundo Metodo para la Creacion de una Nueva Cita con el Medico, la cual
     * podra ser realizada por el Cliente, el Medico o el Administrador desde la
     * Vista o el Frontend
     */
    /**
     * public boolean insertarCitaMedicoCA(CitaMedico citaMedico) { String
     * queryDividido1 = "INSERT INTO Cita_Medico(Codigo,
     * Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Consulta_Tipo, Fecha,
     * Hora, Estado) " + "VALUES(?,?,?,?,?,?,?)";
     *
     * String queryDividido2 = "INSERT INTO
     * Ingresos_Medico(Paciente_Usuario_Codigo, Medico_Usuario_Codigo, Fecha,
     * Total, Cita_Medico_Codigo) " + "VALUES(?,?,?, (SELECT Costo FROM Consulta
     * WHERE Tipo = ? LIMIT 1),?)";
     *
     * try {
     *
     * PreparedStatement enviarDividido1 =
     * Conexion.conexion.prepareStatement(queryDividido1);
     *
     * //Envio de los Datos Principales de la Cita de un Medico a la Tabla
     * Cita_Medico enviarDividido1.setInt(1, citaMedico.getCodigo());
     * enviarDividido1.setString(2, citaMedico.getCodigoPaciente());
     * enviarDividido1.setString(3, citaMedico.getCodigoMedico());
     * enviarDividido1.setString(4, citaMedico.getTipoConsulta());
     * enviarDividido1.setString(5, citaMedico.getFecha());
     * enviarDividido1.setString(6, citaMedico.getHora());
     * enviarDividido1.setBoolean(7, citaMedico.isEstado());
     * enviarDividido1.executeUpdate();
     *
     * PreparedStatement enviarDividido2 =
     * Conexion.conexion.prepareStatement(queryDividido2);
     *
     * //Envio de los Datos Principales de la Cita de un Medico a la Tabla
     * Ingresos_Medico enviarDividido2.setString(1,
     * citaMedico.getCodigoPaciente()); enviarDividido2.setString(2,
     * citaMedico.getCodigoMedico()); enviarDividido2.setString(3,
     * citaMedico.getFecha()); enviarDividido2.setString(4,
     * citaMedico.getTipoConsulta()); enviarDividido2.setInt(5,
     * citaMedico.getCodigo());
     *
     * enviarDividido2.executeUpdate(); return true;
     *
     * } catch (SQLException ex) { ex.printStackTrace(System.out); return false;
     * }
     *
     * }
     */
    /**
     * Metodo que devuelve una Lista de Objetos de Tipo ReporteMedico y que nos
     * servira para Obtener las Citas Agendadas con un Medico en un Intervalo de
     * Tiempo
     *
     * @param codigoUsuario
     * @param fechaInicio
     * @param fechaFinal
     * @return
     */
    public List<ReporteMedico> reporte2Medico(String codigoUsuario, String fechaInicio, String fechaFinal) {

        List<ReporteMedico> reporte = new ArrayList<>();
        reporte.clear();

        try {
            String query = "SELECT c.Codigo, c.Paciente_Usuario_Codigo, p.Nombre, c.Medico_Usuario_Codigo, c.Consulta_Tipo, c.Fecha, c.Hora FROM Cita_Medico c INNER JOIN Paciente p ON p.Usuario_Codigo = c.Paciente_Usuario_Codigo WHERE Medico_Usuario_Codigo = ? AND Fecha <= ? AND Fecha>= ? ORDER BY Fecha ASC";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            enviar.setString(1, codigoUsuario);
            enviar.setString(2, fechaFinal);
            enviar.setString(3, fechaInicio);
            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(new ReporteMedico(rs.getInt("Codigo"),
                        rs.getString("Paciente_Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("Medico_Usuario_Codigo"),
                        rs.getString("Consulta_Tipo"),
                        rs.getString("Fecha"),
                        rs.getString("Hora")));

            }

        } catch (Exception e) {

        }

        return reporte;
    }

    /**
     * Metodo que devuelve una Lista de Objetos de Tipo ReporteMedico y que nos
     * servira para Obtener las Citas Agendadas con un Medico para el dia de hoy
     *
     * @param codigoUsuario
     * @return
     */
    public List<ReporteMedico> reporte3Medico(String codigoUsuario) {

        List<ReporteMedico> reporte = new ArrayList<>();
        reporte.clear();
        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //Date fecha = new Date();
        // DateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        //String fechaActual = formato.format(fecha);

        System.out.println("Fecha de Hoy: " + fecha.toString());
        try {
            String query = "SELECT c.Codigo, c.Paciente_Usuario_Codigo, p.Nombre, c.Medico_Usuario_Codigo, c.Consulta_Tipo, c.Fecha, c.Hora FROM Cita_Medico c INNER JOIN Paciente p ON p.Usuario_Codigo = c.Paciente_Usuario_Codigo WHERE Medico_Usuario_Codigo = ? AND Fecha = ? ORDER BY Hora ASC";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            enviar.setString(1, codigoUsuario);
            enviar.setString(2, fecha.toString());

            rs = enviar.executeQuery();

            while (rs.next()) {
                reporte.add(new ReporteMedico(rs.getInt("Codigo"),
                        rs.getString("Paciente_Usuario_Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("Medico_Usuario_Codigo"),
                        rs.getString("Consulta_Tipo"),
                        rs.getString("Fecha"),
                        rs.getString("Hora")));

            }

        } catch (Exception e) {

        }

        return reporte;
    }

    public int obtenerCodigoCitaMedica() {
        int codigoCitaMedica = 1;
        try {
            String query = "SELECT Codigo FROM Cita_Medico WHERE Codigo = (SELECT MAX(Codigo) FROM Cita_Medico)";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            rs = enviar.executeQuery();

            while (rs.next()) {
                codigoCitaMedica = rs.getInt("Codigo") + 1;

            }

        } catch (Exception e) {

        }
        return codigoCitaMedica;

    }
}
