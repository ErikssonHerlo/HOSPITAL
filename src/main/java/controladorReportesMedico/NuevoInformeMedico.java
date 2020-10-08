/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorReportesMedico;

import accesoAObjetos.AccesoACitaMedico;
import accesoAObjetos.AccesoAInforme;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.CitaMedico;
import objetos.Informe;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "NuevoInformeMedico", urlPatterns = {"/NuevoInformeMedico"})
public class NuevoInformeMedico extends HttpServlet {

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
            out.println("<title>Servlet NuevoInformeMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoInformeMedico at " + request.getContextPath() + "</h1>");
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
        String codigoPaciente = request.getParameter("codigoPaciente");
         String codigoMedico = (String)request.getSession().getAttribute("codigoUsuario");     
        
        String descripcion = request.getParameter("descripcionInforme");
        String fechaInforme = request.getParameter("fechaInforme");
        String horaInforme = request.getParameter("horaInforme");
        String codigoCitaMedica = request.getParameter("codigoConsulta");
        
        Informe nuevoInforme = new Informe(1, codigoPaciente, codigoMedico, descripcion, fechaInforme, horaInforme, true, codigoCitaMedica);
        AccesoAInforme ingresar = new AccesoAInforme();
        if(ingresar.insertarNuevoInforme(nuevoInforme)){
            request.setAttribute("Exitoso", true);
        } else {
            request.setAttribute("Exitoso", false);
        }
        
        RequestDispatcher despachar = request.getRequestDispatcher("NuevoInforme_Medico.jsp");
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
