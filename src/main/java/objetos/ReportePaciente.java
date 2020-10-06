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
    private int codigoInforme;
    private String nombrePaciente;
    private String nombreMedico;
    private String codigoMedico;
    private String descripcion;
    
    private String codigoLaboratorista;
    private String nombreLaboratorista;
    private String nombreExamen;
    private String informeExamen;
    private String fecha;
    private String hora;
/**
 * CONSTRUCTOR PARA EL PRIMER REPORTE
 * @param codigoResultado
 * @param nombrePaciente
 * @param nombreLaboratorista
 * @param nombreExamen
 * @param informeExamen
 * @param fecha
 * @param hora 
 */
    public ReportePaciente(int codigoResultado, String nombrePaciente, String nombreLaboratorista, String nombreExamen, String informeExamen, String fecha, String hora) {
        this.codigoResultado = codigoResultado;
        this.nombrePaciente = nombrePaciente;
        this.nombreLaboratorista = nombreLaboratorista;
        this.nombreExamen = nombreExamen;
        this.informeExamen = informeExamen;
        this.fecha = fecha;
        this.hora = hora;
    }
/**
 * CONSTRUCTOR PARA EL TERCER REPORTE DEL PACIENTE
 * @param codigoInforme
 * @param nombrePaciente
 * @param nombreMedico
 * @param descripcion
 * @param fecha
 * @param hora 
 */
        public ReportePaciente(int codigoInforme, String nombrePaciente, String nombreMedico, String descripcion, String fecha, String hora) {
        this.codigoInforme = codigoInforme;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigoInforme() {
        return codigoInforme;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getDescripcion() {
        return descripcion;
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

    public String getNombreLaboratorista() {
        return nombreLaboratorista;
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

    public void setCodigoInforme(int codigoInforme) {
        this.codigoInforme = codigoInforme;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public void setNombreLaboratorista(String nombreLaboratorista) {
        this.nombreLaboratorista = nombreLaboratorista;
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
