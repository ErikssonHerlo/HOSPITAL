/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Administrador;
import objetos.Laboratorista;
import objetos.Medico;
import objetos.Turno;

/**
 *
 * @author erikssonherlo
 */
public class AccesoALaboratorista {

    /**
     * Metodo para Insertar Nuevo Laboratorista desde la Carga del Archivo y
     * desde la Vista del Administrador
     * VERIFICACION PREVIA
     * Que el Nombre del Examen se encuentre registrado en la Base de Datos, para poder registrar todos los datos del  Laboratorista
     * y que no ocurra un desface en los datos
     * @param laboratorista
     * @param turno
     * @return
     */
    public boolean insertarNuevoLaboratorista(Laboratorista laboratorista, Turno turno) {
        
        if(verificarExamen(laboratorista.getNombreExamen()))
        {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Laboratorista(Usuario_Codigo, Nombre, Registro, Nombre_Examen, Fecha_Inicio, Estado, Examen_Codigo) "
                + "VALUES(?,?,?,?,?,?, "
                + "(SELECT Codigo FROM Examen WHERE Nombre = ? LIMIT 1))";

        String queryDividido3 = "INSERT INTO Turno(Dia_Turno, Laboratorista_Usuario_Codigo) "
                + "VALUES(?,?)";
        
        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del Laboratorista a la Tabla Usuario
            enviarDividido1.setString(1, laboratorista.getCodigo());
            enviarDividido1.setString(2, laboratorista.getNombre());
            enviarDividido1.setString(3, laboratorista.getDPI());
            enviarDividido1.setString(4, laboratorista.getTelefono());
            enviarDividido1.setString(5, laboratorista.getCorreo());
            enviarDividido1.setString(6, laboratorista.getPassword());
            enviarDividido1.setInt(7, 2);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Laboratorista a la Tabla Laboratorista
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, laboratorista.getCodigo());
            enviarDividido2.setString(2, laboratorista.getNombre());
            enviarDividido2.setString(3, laboratorista.getRegistro());
            enviarDividido2.setString(4, laboratorista.getNombreExamen());
            enviarDividido2.setString(5, laboratorista.getFechaInicio());
            enviarDividido2.setBoolean(6, laboratorista.isEstado());
            enviarDividido2.setString(7, laboratorista.getNombreExamen());
            enviarDividido2.executeUpdate();

            //Envio de los Datos del Turno Perteneciente a un Laboratorista en la Tabla Turno
            PreparedStatement enviarDividido3 = Conexion.conexion.prepareStatement(queryDividido3);
            //USO DE FOREACH CON ARRAYLIST
            for (int i = 0; i < turno.getDiaTurno().size(); i++) {
                enviarDividido3.setString(1, turno.getDiaTurno().get(i).toString());
                enviarDividido3.setString(2, laboratorista.getCodigo()); //Envio del Codigo del laboratorista, al cual se le asigno dicho Turno
                enviarDividido3.executeUpdate();
            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
        } else {
        return false;
        }

    }
       public boolean insertarNuevoLaboratoristaBackUp(Laboratorista laboratorista, Turno turno) {
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Laboratorista(Usuario_Codigo, Nombre, Registro, Nombre_Examen, Fecha_Inicio, Estado, Examen_Codigo) "
                + "VALUES(?,?,?,?,?,?, "
                + "(SELECT Codigo FROM Examen WHERE Nombre = ? LIMIT 1))";

        String queryDividido3 = "INSERT INTO Turno(Dia_Turno, Laboratorista_Usuario_Codigo) "
                + "VALUES(?,?)";
        
        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del Laboratorista a la Tabla Usuario
            enviarDividido1.setString(1, laboratorista.getCodigo());
            enviarDividido1.setString(2, laboratorista.getNombre());
            enviarDividido1.setString(3, laboratorista.getDPI());
            enviarDividido1.setString(4, laboratorista.getTelefono());
            enviarDividido1.setString(5, laboratorista.getCorreo());
            enviarDividido1.setString(6, laboratorista.getPassword());
            enviarDividido1.setInt(7, 2);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Laboratorista a la Tabla Laboratorista
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, laboratorista.getCodigo());
            enviarDividido2.setString(2, laboratorista.getNombre());
            enviarDividido2.setString(3, laboratorista.getRegistro());
            enviarDividido2.setString(4, laboratorista.getNombreExamen());
            enviarDividido2.setString(5, laboratorista.getFechaInicio());
            enviarDividido2.setBoolean(6, laboratorista.isEstado());
            enviarDividido2.setString(7, laboratorista.getNombreExamen());
            enviarDividido2.executeUpdate();

            //Envio de los Datos del Turno Perteneciente a un Laboratorista en la Tabla Turno
            PreparedStatement enviarDividido3 = Conexion.conexion.prepareStatement(queryDividido3);
            //USO DE FOREACH CON ARRAYLIST
            for (int i = 0; i < turno.getDiaTurno().size(); i++) {
                enviarDividido3.setString(1, turno.getDiaTurno().get(i).toString());
                enviarDividido3.setString(2, laboratorista.getCodigo()); //Envio del Codigo del laboratorista, al cual se le asigno dicho Turno
                enviarDividido3.executeUpdate();
            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }

/**
 * METODO QUE VERIFICA SI EL EXAMEN QUE EL USUARIO DESEA ASIGNARLE AL LABORATORISTA SI EXISTE
 * @param nombreExamen
 * @return 
 */
    public boolean verificarExamen(String nombreExamen) {

        String codigoExamen = "";

        try {
            String query = "SELECT Codigo FROM Examen WHERE Nombre = ? LIMIT 1";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
            ResultSet rs = null;

            enviar.setString(1, nombreExamen);

            rs = enviar.executeQuery();

            while (rs.next()) {
                codigoExamen = rs.getString("Codigo");
            }

        } catch (Exception e) {

        }

        if (codigoExamen.equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
           public List<Laboratorista> listarLaboratositas(){
        
        List<Laboratorista> reporte = new ArrayList<>();
        reporte.clear();
 
        try {
            String query = "SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, l.Registro, l.Nombre_Examen, l.Fecha_Inicio, l.Examen_Codigo FROM Usuario u INNER JOIN Laboratorista l ON l.Usuario_Codigo = u.Codigo";
            PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
       
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                reporte.add(new Laboratorista(rs.getString("Codigo"), 
                        rs.getString("Nombre"),
                        rs.getString("DPI"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        "vacio", 2, rs.getString("Registro"),
                        rs.getString("Nombre_Examen"), 
                        rs.getString("Fecha_Inicio"),
                        true, rs.getInt("Examen_Codigo")));
                        
                        
                                        
            }
          
        } catch (Exception e) {

        }
          
    return reporte;
    }
}
