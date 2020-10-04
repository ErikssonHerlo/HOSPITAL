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
public class CitaLaboratorio {

    private int codigo;
    private String codigoPaciente;
    private String codigoLaboratorista;
    private String fecha;
    private String hora;
    private boolean estado;

    /**
     * Clase CitaLaboratorio, que contendra todos los datos de una Cita creada
     * por un Administrador, un Medico o un Paciente desde la Vista o desde la
     * carga de Archivos
     *
     * @param codigo
     * @param codigoPaciente
     * @param codigoLaboratorista
     * @param fecha
     * @param hora
     * @param estado
     */
    public CitaLaboratorio(int codigo, String codigoPaciente, String codigoLaboratorista, String fecha, String hora, boolean estado) {
        this.codigo = codigo;
        this.codigoPaciente = codigoPaciente;
        this.codigoLaboratorista = codigoLaboratorista;
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

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
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

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
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
