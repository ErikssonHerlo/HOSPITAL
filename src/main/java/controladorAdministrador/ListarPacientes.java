/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAdministrador;

import accesoAObjetos.AccesoAMedico;
import accesoAObjetos.AccesoAPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "ListarPacientes", urlPatterns = {"/ListarPacientes"})
public class ListarPacientes extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarPacientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarPacientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    
        String nombre = (String)request.getParameter("nombre");
        String codigo = (String)request.getParameter("codigo");
        
        AccesoAPaciente acceso = new AccesoAPaciente();
        if(!nombre.equals("") && codigo.equals("")){
        request.setAttribute("Reporte", acceso.listarPacientesNombre(nombre));
            System.out.println("Busqueda por Nombre");
        } 
        else if(nombre.equals("") && !codigo.equals("")){
        request.setAttribute("Reporte", acceso.listarPacientesCodigo(codigo));
            System.out.println("Busqueda por Codigo");
        } 
        else if(!nombre.equals("") && !codigo.equals("")){
        request.setAttribute("Reporte", acceso.listarPacientesCodigoNombre(codigo, nombre));
        System.out.println("Busqueda por Nombre y Codigo");
        } else {
        request.setAttribute("Reporte", acceso.listarPacientes());
        System.out.println("Busqueda General");
        }
        
            
        RequestDispatcher despachar = request.getRequestDispatcher("ListarPacientes.jsp");
        despachar.forward(request, response);
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
        processRequest(request, response);
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
