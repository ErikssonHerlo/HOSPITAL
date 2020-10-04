/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;

/**
 *
 * @author erikssonherlo
 */
public class Administrador extends Usuario implements Serializable {

    /**
     * Clase Hija de la Clase Usuario, comparte los atributos:
     *
     * @param codigo
     * @param nombre
     * @param DPI
     * @param telefono
     * @param correo
     * @param password
     * @param tipoUsuario No contiene Atributos Unicos
     */
    public Administrador(String codigo, String nombre, String DPI, String telefono, String correo, String password, int tipoUsuario) {
        super(codigo, nombre, DPI, telefono, correo, password, tipoUsuario);
    }

 


}
