/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAObjetos;

import conexionMySQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Administrador;

/**
 *
 * @author erikssonherlo
 */
public class AccesoAAdministrador {
    
    public boolean insertarNuevoAdministrador(Administrador administrador) {
        
        String queryDividido1 = "INSERT INTO Usuario(Codigo, Nombre, DPI, Telefono, Correo, Password, Tipo_Usuario) "
                + "VALUES(?,?,?,?,?,?,?)";

        String queryDividido2 = "INSERT INTO Administrador(Usuario_Codigo, Nombre) "
                + "VALUES(?,?)";

        try {

            PreparedStatement enviarDividido1 = Conexion.conexion.prepareStatement(queryDividido1);

            //Envio de los Datos Principales del administrador a la Tabla Usuario
            enviarDividido1.setString(1, administrador.getCodigo());
            enviarDividido1.setString(2, administrador.getNombre());
            enviarDividido1.setString(3, administrador.getDPI());
            enviarDividido1.setString(4, administrador.getTelefono());
            enviarDividido1.setString(5, administrador.getCorreo());
            enviarDividido1.setString(6, administrador.getPassword());
            enviarDividido1.setInt(7, 1);
            enviarDividido1.executeUpdate();

            //Envia los Datos Complementarios del Administrador a la tabla administrador
            PreparedStatement enviarDividido2 = Conexion.conexion.prepareStatement(queryDividido2);
            enviarDividido2.setString(1, administrador.getCodigo());
            enviarDividido2.setString(2, administrador.getNombre());
            enviarDividido2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
       

    }
    /**
     * VERIFICACION DEL INGRESO ADECUADO DE LOS ADMINISTRADORES A LA BASE DE DATOS
     * @return 
     */
        public boolean verificarEstadoDB(){
        
        Administrador admin = null;
 
        ResultSet rs = Conexion.getTabla("SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario FROM Usuario u INNER JOIN Administrador a ON a.Usuario_Codigo = u.Codigo");
        try {
            while (rs.next()) {
                admin = new Administrador(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"));
                
            }

        } catch (Exception e) {

        }
           if(admin == null)
           {
               return false;
           } else
           {
           return true;
           }
    
    }
        
        
        
        
     
        /**
         * Metodo de Validacion, recibe los parametros desde el formulario, verifica si existe el usuario
         * y si este existe, verifica que su contraseña sea correcta
         * @param codigoAdmin
         * @param password
         * @return
         * @throws SQLException 
         */
        public Administrador validacionLogin(String codigoAdmin, String password) throws SQLException {
        Administrador admin = obtenerAdministrador(codigoAdmin);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
        /**
         * Obtenemos el Administrador con una busqueda entorno a su codigo
         * @param codigoAdministrador
         * @return 
         */
      public Administrador obtenerAdministrador(String codigoAdministrador){
        
        Administrador admin = null;
 
        try {
        String query ="SELECT u.Codigo, u.Nombre, u.DPI, u.Telefono, u.Correo, u.Password, u.Tipo_Usuario FROM Usuario u INNER JOIN Administrador a ON a.Usuario_Codigo = u.Codigo WHERE a.Usuario_Codigo = ?";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, codigoAdministrador);
        
        rs=enviar.executeQuery();   
        
            while (rs.next()) {
                admin = new Administrador(rs.getString("Codigo"), rs.getString("Nombre"),rs.getString("DPI"), rs.getString("Telefono"), rs.getString("Correo"), rs.getString("Password"), rs.getInt("Tipo_Usuario"));
                
            }
          
        } catch (Exception e) {

        }
          
    return admin;
    }

}
/*
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_USUARIO);
        preSt.setInt(1, idUsuario);
        ResultSet result = preSt.executeQuery();

        Usuario usuario = null;

        while (result.next()) {
            usuario = new Usuario(
                    result.getInt(Usuario.USUARIO_ID_DB_NAME),
                    result.getString(Usuario.NOMBRE_DB_NAME),
                    result.getString(Usuario.PROFESION_DB_NAME),
                    result.getString(Usuario.PASSWORD_DB_NAME)
            );
        }
        return usuario;
*/
/* ASI HICE CONSULTAS CON PARAMETROS
v    private void mostrarTablaBusqueda(String fechaInicioConsulta, String fechaFinalConsulta) throws SQLException {
        //NITDelCliente = NITCliente;
        DefaultTableModel model = new DefaultTableModel();
        try {
        String query ="SELECT SUM(Cantidad_Venta),Codigo_Producto,GROUP_CONCAT(DISTINCT v.Fecha) FROM DETALLE_VENTAS d INNER JOIN VENTAS v ON d.Id_Ventas=v.Id_Ventas WHERE v.Fecha BETWEEN ? AND ? GROUP BY Codigo_Producto ORDER BY SUM(Cantidad_Venta) DESC LIMIT 10";
        PreparedStatement enviar = Conexion.conexion.prepareStatement(query);
        ResultSet rs = null;
        
        
        enviar.setString(1, fechaInicioConsulta);
        enviar.setString(2, fechaFinalConsulta);
        
        rs=enviar.executeQuery();
        model.setColumnIdentifiers(new Object[]{"Cantidad de Productos Vendidos", "Codigo Producto", "Fecha en la que se Vendieron más Productos"});
        
     
        
            while (rs.next()) {               
              model.addRow(new Object[]{rs.getInt("SUM(Cantidad_Venta)"), rs.getString("Codigo_Producto"), rs.getString("GROUP_CONCAT(DISTINCT v.Fecha)")});
        }
            tablePedidos.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
*/