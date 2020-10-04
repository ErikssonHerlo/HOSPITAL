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
public class Examen {

    private int codigoExamen;
    private String nombre;
    private boolean orden;
    private String descripcion;
    private double costo;
    private String formato;
    private boolean estado;

    /**
     * Clase Examen, que contendra todos los datos de un Examen creado por un
     * Administrador o desde la carga de Archivos
     *
     * @param codigoExamen
     * @param nombre
     * @param orden
     * @param descripcion
     * @param costo
     * @param formato
     * @param estado
     */
    public Examen(int codigoExamen, String nombre, boolean orden, String descripcion, double costo, String formato, boolean estado) {
        this.codigoExamen = codigoExamen;
        this.nombre = nombre;
        this.orden = orden;
        this.descripcion = descripcion;
        this.costo = costo;
        this.formato = formato;
        this.estado = estado;
    }

    public int getCodigoExamen() {
        return codigoExamen;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isOrden() {
        return orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public String getFormato() {
        return formato;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrden(boolean orden) {
        this.orden = orden;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
