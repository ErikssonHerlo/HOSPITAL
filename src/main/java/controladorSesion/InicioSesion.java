/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorSesion;

import accesoAObjetos.AccesoAAdministrador;
import accesoAObjetos.AccesoAUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Administrador;
import objetos.Laboratorista;
import objetos.Medico;
import objetos.Paciente;
import sun.jvm.hotspot.utilities.soql.SOQLException;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

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
            out.println("<title>Servlet InicioSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InicioSesion at " + request.getContextPath() + "</h1>");
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
        try {
            String codigoUsuario = request.getParameter("usuarioCodigo");
        String passwordUsuario = request.getParameter("usuarioPassword");
        AccesoAUsuario acceso = new AccesoAUsuario();
        
        Administrador adminSesion = acceso.loginAdmin(codigoUsuario, passwordUsuario);
        Laboratorista labSesion = acceso.loginLaboratorista(codigoUsuario, passwordUsuario);
        Paciente pacienteSesion = acceso.loginPaciente(codigoUsuario, passwordUsuario);
        Medico medicoSesion = acceso.loginMedico(codigoUsuario, passwordUsuario);
            System.out.println("Recibi los parametros");
        if(adminSesion != null)
        {
            System.out.println("Ingresamos al Usuario: "+adminSesion.getNombre());
            request.getSession().setAttribute("codigoUsuario", adminSesion.getCodigo());
            request.getSession().setAttribute("nombreUsuario", adminSesion.getNombre());
            request.getSession().setAttribute("tipoUsuario", adminSesion.getTipoUsuario());
            request.getSession().setAttribute("objetoUsuario", adminSesion);
            response.sendRedirect(request.getContextPath()+"/InicioAdmin.jsp");
                    
        } else if(labSesion != null)
        {
            System.out.println("Ingresamos al Usuario: "+labSesion.getNombre());
            request.getSession().setAttribute("codigoUsuario", labSesion.getCodigo());
            request.getSession().setAttribute("nombreUsuario", labSesion.getNombre());
            request.getSession().setAttribute("tipoUsuario", labSesion.getTipoUsuario());
            request.getSession().setAttribute("objetoUsuario", labSesion);
            response.sendRedirect(request.getContextPath()+"/InicioLaboratorista.jsp");
                    
        }  else if(pacienteSesion != null)
        {
            System.out.println("Ingresamos al Usuario: "+pacienteSesion.getNombre());
            request.getSession().setAttribute("codigoUsuario", pacienteSesion.getCodigo());
            request.getSession().setAttribute("nombreUsuario", pacienteSesion.getNombre());
            request.getSession().setAttribute("tipoUsuario", pacienteSesion.getTipoUsuario());
            request.getSession().setAttribute("objetoUsuario", pacienteSesion);
            response.sendRedirect(request.getContextPath()+"/InicioPaciente.jsp");
                    
        }  
         else if(medicoSesion != null)
        {
            System.out.println("Ingresamos al Usuario: "+medicoSesion.getNombre());
            request.getSession().setAttribute("codigoUsuario", medicoSesion.getCodigo());
            request.getSession().setAttribute("nombreUsuario", medicoSesion.getNombre());
            request.getSession().setAttribute("tipoUsuario", medicoSesion.getTipoUsuario());
            request.getSession().setAttribute("objetoUsuario", medicoSesion);
            response.sendRedirect(request.getContextPath()+"/InicioMedico.jsp");
                    
        }  else {
         request.setAttribute("Exitoso", false);
        
        RequestDispatcher despachar = request.getRequestDispatcher("Login.jsp");
        despachar.forward(request, response);
        
        }
       
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
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
