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
public class Laboratorista extends Usuario {

    private String registro;
    private String nombreExamen;
    private String fechaInicio;
    private boolean estado;
    private int codigoExamen;

    /**
     * Clase Hija de la Clase Usuario, comparte los atributos:
     * @param codigo
     * @param nombre
     * @param DPI
     * @param telefono
     * @param correo
     * @param password
     * @param tipoUsuario
     * Atributos Unicos de la Clase Laboratorista:
     * @param registro
     * @param nombreExamen
     * @param fechaInicio
     * @param estado
     * @param codigoExamen 
     */
    public Laboratorista(String codigo, String nombre, String DPI, String telefono, String correo, String password, int tipoUsuario, String registro, String nombreExamen, String fechaInicio, boolean estado, int codigoExamen) {
        super(codigo, nombre, DPI, telefono, correo, password, tipoUsuario);
        this.registro = registro;
        this.nombreExamen = nombreExamen;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.codigoExamen = codigoExamen;
    }

    public String getRegistro() {
        return registro;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getCodigoExamen() {
        return codigoExamen;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

  
}
