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
public class Paciente extends Usuario{
    private String sexo;
    private String nacimiento;
    private String peso;
    private String tipoSangre;
    private boolean estado;
    
    /**
     * Clase Hija de la Clase Usuario, comparte los atributos:
     * @param codigo
     * @param nombre
     * @param DPI
     * @param telefono
     * @param correo
     * @param password
     * @param tipoUsuario
     * Atributos Unicos de la Clase Paciente:
     * @param sexo
     * @param nacimiento
     * @param peso
     * @param tipoSangre
     * @param estado 
     */
    public Paciente(String codigo, String nombre, String DPI, String telefono, String correo, String password, int tipoUsuario, String sexo, String nacimiento, String peso, String tipoSangre, boolean estado) {
        super(codigo, nombre, DPI, telefono, correo, password, tipoUsuario);
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
        this.estado = estado;
    }
    
    public String getSexo() {
        return sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getPeso() {
        return peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    
    
}
