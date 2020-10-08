/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorPaciente;

import accesoAObjetos.AccesoACitaMedico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.CitaMedico;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "NuevaCitaMedico", urlPatterns = {"/NuevaCitaMedico"})
public class NuevaCitaMedico extends HttpServlet {

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
            out.println("<title>Servlet NuevaCitaMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevaCitaMedico at " + request.getContextPath() + "</h1>");
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
        String codigoUsuario = (String)request.getSession().getAttribute("codigoUsuario");     
        String codigoMedico = request.getParameter("codigoMedico");
        String tituloEspecialidad = request.getParameter("tituloEspecialidad");
        String horaEntrada = request.getParameter("horaEntrada");
        String horaSalida = request.getParameter("horaSalida");
                
                
        AccesoACitaMedico acceso = new AccesoACitaMedico();
        int codigoCitaMedica = acceso.obtenerCodigoCitaMedica();
         request.setAttribute("codigoCitaMedica", codigoCitaMedica);
         request.setAttribute("codigoUsuario", codigoUsuario);
         request.setAttribute("codigoMedico", codigoMedico);
         request.setAttribute("tituloEspecialidad", tituloEspecialidad);
         request.setAttribute("horaEntrada", horaEntrada);
         request.setAttribute("horaSalida", horaSalida);
                 
        
     
        
        RequestDispatcher despachar = request.getRequestDispatcher("NuevaCitaMedica.jsp");
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
        int codigoCita = Integer.parseInt(request.getParameter("codigoCita"));
         String codigoUsuario = (String)request.getSession().getAttribute("codigoUsuario");     
        String codigoMedico = request.getParameter("codigoMedico");
        String tipoConsulta = request.getParameter("tipoConsulta");
        String fechaCitaMedica = request.getParameter("fechaCitaMedica");
        String horaCitaMedica = request.getParameter("horaCitaMedica");
                 
        CitaMedico nuevaCita = new CitaMedico(codigoCita, codigoUsuario, codigoMedico, tipoConsulta, fechaCitaMedica, horaCitaMedica, true);
        AccesoACitaMedico agendar = new AccesoACitaMedico();
        
        if(agendar.insertarCitaMedicoCA(nuevaCita)){
            request.setAttribute("Exitoso", true);
        } else {
            request.setAttribute("Exitoso", false);
        }
        
        RequestDispatcher despachar = request.getRequestDispatcher("NuevaCitaMedica.jsp");
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
