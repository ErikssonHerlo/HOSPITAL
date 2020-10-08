/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author erikssonherlo
 */
public class ReporteAdmin {
     private int idIngresos;
     private String codigoPaciente;
     private String nombrePaciente;
     private String codigoMedico;
     private String nombreMedico;
     private String fecha;
     private Double total;
     private int codigoCita;
    /**
      * CONSTRUCTOR UTILIZADO PARA EL REPORTE 2 Y 6 DEL ADMINISTRADOR, ALTERNANDO EL NOMBRE DEL PACIENTE, CON EL NOMBRE DEL MEDICO
       * @param idIngresos
      * @param codigoPaciente
      * @param nombrePaciente
      * @param codigoMedico
      * @param nombreMedico
      * @param fecha
      * @param total
      * @param codigoCita 
      */

    public ReporteAdmin(int idIngresos, String codigoPaciente, String nombrePaciente, String codigoMedico, String nombreMedico, String fecha, Double total, int codigoCita) {
        this.idIngresos = idIngresos;
        this.codigoPaciente = codigoPaciente;
        this.nombrePaciente = nombrePaciente;
        this.codigoMedico = codigoMedico;
        this.nombreMedico = nombreMedico;
        this.fecha = fecha;
        this.total = total;
        this.codigoCita = codigoCita;
    }

    public int getIdIngresos() {
        return idIngresos;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getTotal() {
        return total;
    }

    public int getCodigoCita() {
        return codigoCita;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setCodigoCita(int codigoCita) {
        this.codigoCita = codigoCita;
    }

 


     
     
}
