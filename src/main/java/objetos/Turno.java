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
public class Turno {

    private List diaTurno = new ArrayList<>();

    /**
     * Clase Turno, que contendra todos los dias que un Laboratorista va a
     * trabajar, por lo que es un Array creado por un Administrador o desde la
     * carga de Archivos
     *
     * @param diaTurno
     */
    public Turno(List diaTurno) {
        this.diaTurno = diaTurno;
    }

    public List getDiaTurno() {
        return diaTurno;
    }

    public void setDiaTurno(List diaTurno) {
        this.diaTurno = diaTurno;
    }

}
