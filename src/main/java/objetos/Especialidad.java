/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erikssonherlo
 */
public class Especialidad {

    
    private List<String> titulo = new ArrayList<>();
    private boolean estado;

    /**
     * Clase Especialidad, que contendra todos los datos de una Especialidad
     * asignada a un Medico, por lo que es un Array creado por un Administrador
     * o desde la carga de Archivos
     *
     * @param titulo
     * @param estado
     */
    public Especialidad(List titulo, boolean estado) {
        this.titulo = titulo;
        this.estado = estado;
    }

    public List getTitulo() {
        return titulo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setTitulo(List titulo) {
        this.titulo = titulo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
