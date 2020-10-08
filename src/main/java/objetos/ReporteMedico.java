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
public class ReporteMedico {
        private int codigoCita;
    
    private String codigoPaciente;
    private int cantidadInformes;
    private String nombrePaciente;
    private String codigoMedico;
    private String tipoConsulta;    
    private String fecha;
    private String hora;
    private String nombreMedico;
    private int colegiado;
    private String horaEntrada;
    private String horaSalida;
    private String fechaInicio;
    private String titulo;
/**
 * Constructor para el Reporte No. 2 y No. 3 del Medico
 * @param codigoCita
 * @param codigoPaciente
 * @param nombrePaciente
 * @param codigoMedico
 * @param tipoConsulta
 * @param fecha
 * @param hora 
 */
    public ReporteMedico(int codigoCita, String codigoPaciente, String nombrePaciente, String codigoMedico, String tipoConsulta, String fecha, String hora) {
        this.codigoCita = codigoCita;
        this.codigoPaciente = codigoPaciente;
        this.nombrePaciente = nombrePaciente;
        this.codigoMedico = codigoMedico;
        this.tipoConsulta = tipoConsulta;
        this.fecha = fecha;
        this.hora = hora;
    }
/**
 * Constructor para el Reporte No. 4 del Medico
 * @param codigoPaciente
 * @param cantidadInformes
 * @param nombrePaciente 
 */
    public ReporteMedico(String codigoPaciente, int cantidadInformes, String nombrePaciente) {
        this.codigoPaciente = codigoPaciente;
        this.cantidadInformes = cantidadInformes;
        this.nombrePaciente = nombrePaciente;
    }
/**
 * Constructor para todos los Campos de Busqueda del Medico
 * @param codigoMedico
 * @param nombreMedico
 * @param colegiado
 * @param horaEntrada
 * @param horaSalida
 * @param fechaInicio
 * @param titulo 
 */
    public ReporteMedico(String codigoMedico, String nombreMedico, int colegiado, String horaEntrada, String horaSalida, String fechaInicio, String titulo) {
        this.codigoMedico = codigoMedico;
        this.nombreMedico = nombreMedico;
        this.colegiado = colegiado;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaInicio = fechaInicio;
        this.titulo = titulo;
    }

    public int getCodigoCita() {
        return codigoCita;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public int getCantidadInformes() {
        return cantidadInformes;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public int getColegiado() {
        return colegiado;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigoCita(int codigoCita) {
        this.codigoCita = codigoCita;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public void setCantidadInformes(int cantidadInformes) {
        this.cantidadInformes = cantidadInformes;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public void setColegiado(int colegiado) {
        this.colegiado = colegiado;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
   
    
    
}
