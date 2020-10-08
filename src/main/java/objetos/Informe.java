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
public class Informe {

    private int codigoInforme;
    private String codigoPaciente;
    private String codigoMedico;
    private String descripcion;
    private String fecha;
    private String hora;
    private boolean estado;
    private String codigoCitaMedica;

       /**
     * Clase Informe, que contendra todos los datos de un Informe creado por un
     * Medico despues de una consulta o desde la carga de Archivos
     *
     * @param codigoInforme
     * @param codigoPaciente
     * @param codigoMedico
     * @param descripcion
     * @param fecha
     * @param hora
     * @param estado
     * @param codigoCitaMedica
     */
    
    public Informe(int codigoInforme, String codigoPaciente, String codigoMedico, String descripcion, String fecha, String hora, boolean estado, String codigoCitaMedica) {
        this.codigoInforme = codigoInforme;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.codigoCitaMedica = codigoCitaMedica;
    }

    public int getCodigoInforme() {
        return codigoInforme;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getCodigoCitaMedica() {
        return codigoCitaMedica;
    }

    public void setCodigoInforme(int codigoInforme) {
        this.codigoInforme = codigoInforme;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCodigoCitaMedica(String codigoCitaMedica) {
        this.codigoCitaMedica = codigoCitaMedica;
    }
 


    
  
}
