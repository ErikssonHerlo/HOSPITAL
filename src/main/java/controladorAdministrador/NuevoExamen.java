/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAdministrador;

import accesoAObjetos.AccesoAAdministrador;
import accesoAObjetos.AccesoAExamen;
import conexionMySQL.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Administrador;
import objetos.Examen;

/**
 *
 * @author erikssonherlo
 */
@WebServlet("/NuevoExamen")
public class NuevoExamen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigoExamen"));
        String nombre = request.getParameter("nombreExamen");
        boolean orden = Boolean.parseBoolean(request.getParameter("orden"));
        String descripcion = request.getParameter("descripcionExamen");
        double costo = Double.parseDouble(request.getParameter("costoExamen"));
        String formato;
        if(orden){
             formato = request.getParameter("formatoInforme");
        } else{
            formato = "";
        }
        
        Examen nuevoExamen = new Examen(codigo, nombre, orden, descripcion, costo, formato, true);
        AccesoAExamen llenarExamen = new AccesoAExamen();
        

        if (llenarExamen.insertarNuevoExamen(nuevoExamen)) {
        request.setAttribute("Exitoso", true);    
        }
        else {
        request.setAttribute("Exitoso", false);
        }
        RequestDispatcher despachar = request.getRequestDispatcher("NuevoExamen.jsp");
        despachar.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
