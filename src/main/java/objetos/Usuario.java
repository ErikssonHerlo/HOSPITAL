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
public class Usuario {

    private String codigo;
    private String nombre;
    private String DPI;
    private String telefono;
    private String correo;
    private String password;
    private int tipoUsuario;
    
    /**
     * Clase Padre o super Clase Uso de Herencia en las Clases Paciente, Medico,
     * Laboratorista y Administrador 
     * Parametros Generales:
     * @param codigo
     * @param nombre
     * @param DPI
     * @param telefono
     * @param correo
     * @param password
     * @param tipoUsuario: Administrador = 1
     *                     Laboratorista = 2
     *                     Paciente = 3
     *                     Medico = 4
     */                    
    public Usuario(String codigo, String nombre, String DPI, String telefono, String correo, String password, int tipoUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.DPI = DPI;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.tipoUsuario= tipoUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

   

}
