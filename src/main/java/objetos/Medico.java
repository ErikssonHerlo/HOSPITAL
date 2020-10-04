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
public class Medico extends Usuario {

    private int colegiado;
    private String horaEntrada;
    private String horaSalida;
    private String fechaInicio;
    private boolean estado;
    

    /**
     * Clase Hija de la Clase Usuario, comparte los atributos:
     *
     * @param codigo
     * @param nombre
     * @param DPI
     * @param telefono
     * @param correo
     * @param password 
     * @param tipoUsuario
     * Atributos unicos pertenecientes a la Clase Medico:
     * @param colegiado
     * @param horaEntrada
     * @param horaSalida
     * @param fechaInicio
     * @param estado
     */
    public Medico(String codigo, String nombre, String DPI, String telefono, String correo, String password, int tipoUsuario, int colegiado, String horaEntrada, String horaSalida, String fechaInicio, boolean estado) {
        super(codigo, nombre, DPI, telefono, correo, password, tipoUsuario);
        this.colegiado = colegiado;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
