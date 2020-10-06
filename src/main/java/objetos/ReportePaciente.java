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
public class ReportePaciente {
    private int codigoResultado;
    private String nombrePaciente;
    private String codigoLaboratorista;
    private String nombreExamen;
    private String informeExamen;
    private String fecha;
    private String hora;
/**
 * CONSTRUCTOR PARA OBTENER EL PRIMER REPORTE DE LOS PACIENTES
 * @param codigoResultado
 * @param nombrePaciente
 * @param codigoLaboratorista
 * @param nombreExamen
 * @param informeExamen
 * @param fecha
 * @param hora 
 */
    public ReportePaciente(int codigoResultado, String nombrePaciente, String codigoLaboratorista, String nombreExamen, String informeExamen, String fecha, String hora) {
        this.codigoResultado = codigoResultado;
        this.nombrePaciente = nombrePaciente;
        this.codigoLaboratorista = codigoLaboratorista;
        this.nombreExamen = nombreExamen;
        this.informeExamen = informeExamen;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigoResultado() {
        return codigoResultado;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public String getInformeExamen() {
        return informeExamen;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setCodigoResultado(int codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public void setInformeExamen(String informeExamen) {
        this.informeExamen = informeExamen;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
