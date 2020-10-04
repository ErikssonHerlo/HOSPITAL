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
public class Consulta {

    private String tipo;
    private double costo;

    /**
     * Clase Consulta, que contendra todos los datos de un Tipo de Consulta
     * Especifica que presta el Hospital creada por un Administrador desde la
     * Vista o desde la carga de Archivos
     *
     * @param tipo
     * @param costo
     */
    public Consulta(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
