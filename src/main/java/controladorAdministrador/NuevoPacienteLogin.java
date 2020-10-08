/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAdministrador;

import accesoAObjetos.AccesoAPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Paciente;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "NuevoPacienteLogin", urlPatterns = {"/NuevoPacienteLogin"})
public class NuevoPacienteLogin extends HttpServlet {

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
            out.println("<title>Servlet NuevoPacienteLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoPacienteLogin at " + request.getContextPath() + "</h1>");
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
        String codigo = request.getParameter("codigoPaciente");
        String nombre = request.getParameter("nombrePaciente");
        String DPI = request.getParameter("DPIPaciente");
        String telefono = request.getParameter("telefonoPaciente");
        String correo = request.getParameter("correoPaciente");
        String password = request.getParameter("passwordPaciente");
        String sexo = request.getParameter("sexoPaciente");
        String nacimiento = request.getParameter("nacimientoPaciente");
        String peso = request.getParameter("pesoPaciente");
        String tipoSangre = request.getParameter("tipoSangrePaciente");
        Paciente nuevoPaciente = new Paciente(codigo, nombre, DPI, telefono, correo, password, 3, sexo, nacimiento, peso, tipoSangre, true);
        AccesoAPaciente llenarPaciente = new AccesoAPaciente();
        if (llenarPaciente.insertarNuevoPaciente(nuevoPaciente)) {
        System.out.println("Ingresamos al Usuario: "+nuevoPaciente.getNombre());
            request.getSession().setAttribute("codigoUsuario", nuevoPaciente.getCodigo());
            request.getSession().setAttribute("nombreUsuario", nuevoPaciente.getNombre());
            request.getSession().setAttribute("tipoUsuario", nuevoPaciente.getTipoUsuario());
            request.getSession().setAttribute("objetoUsuario", nuevoPaciente);
            response.sendRedirect(request.getContextPath()+"/InicioPaciente.jsp");
        }
        else {
        request.setAttribute("Exitoso", false);
        RequestDispatcher despachar = request.getRequestDispatcher("NuevoPacienteLogin.jsp");
        despachar.forward(request, response);
        }
        
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
