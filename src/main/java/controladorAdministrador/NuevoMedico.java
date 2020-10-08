/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAdministrador;

import accesoAObjetos.AccesoAAdministrador;
import accesoAObjetos.AccesoAMedico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Administrador;
import objetos.Especialidad;
import objetos.Medico;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "NuevoMedico", urlPatterns = {"/NuevoMedico"})
public class NuevoMedico extends HttpServlet {

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
            out.println("<title>Servlet NuevoMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoMedico at " + request.getContextPath() + "</h1>");
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
        String codigo = request.getParameter("codigoMedico");
        String nombre = request.getParameter("nombreMedico");
        String DPI = request.getParameter("DPIMedico");
        String telefono = request.getParameter("telefonoMedico");
        String correo = request.getParameter("correoMedico");
        String password = request.getParameter("passwordMedico");
        int colegiado = Integer.parseInt(request.getParameter("colegiadoMedico"));
        String fechaInicio = request.getParameter("fechaInicioMedico");
        String horaEntrada = request.getParameter("horaEntradaMedico");
        String horaSalida = request.getParameter("horaSalidaMedico");
        List<String> titulo = new ArrayList<>();
        titulo.add(request.getParameter("especialidad1Medico"));
        if(!request.getParameter("especialidad2Medico").equals("")){
        titulo.add(request.getParameter("especialidad2Medico"));
        }
        Medico nuevoMedico = new Medico(codigo, nombre, DPI, telefono, correo, password, 4, colegiado, horaEntrada, horaSalida, fechaInicio, true);
        Especialidad nuevaEspecialidad = new Especialidad(titulo, true);
        AccesoAMedico llenarMedico = new AccesoAMedico();
        if (llenarMedico.insertarNuevoMedico(nuevoMedico, nuevaEspecialidad)) {
        request.setAttribute("Exitoso", true);    
        }
        else {
        request.setAttribute("Exitoso", false);
        }
        RequestDispatcher despachar = request.getRequestDispatcher("NuevoMedico.jsp");
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
