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
public class Resultado {
    private int codigo;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoLaboratorista;
    private int codigoExamen;
    private String orden;
    private String informeExamen;
    private String fecha;
    private String hora;
    private boolean estado;
/**
 * Clase Resultado, que contendra todos los datos de un Resultado creado por un
     * Laboratorista luego de haber realizado un Examen o desde la carga de Archivos
 * @param codigo
 * @param codigoPaciente
 * @param codigoMedico
 * @param codigoLaboratorista
 * @param codigoExamen
 * @param orden
 * @param informeExamen
 * @param fecha
 * @param hora
 * @param estado 
 */
    public Resultado(int codigo, String codigoPaciente, String codigoMedico, String codigoLaboratorista, int codigoExamen, String orden, String informeExamen, String fecha, String hora, boolean estado) {
        this.codigo = codigo;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoLaboratorista = codigoLaboratorista;
        this.codigoExamen = codigoExamen;
        this.orden = orden;
        this.informeExamen = informeExamen;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public int getCodigoExamen() {
        return codigoExamen;
    }

    public String getOrden() {
        return orden;
    }

    public String getInformeExamen() {
        return informeExamen;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public void setInformeExamen(String informeExamen) {
        this.informeExamen = informeExamen;
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
            
    
}
