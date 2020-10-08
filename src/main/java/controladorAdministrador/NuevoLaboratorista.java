/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAdministrador;

import accesoAObjetos.AccesoALaboratorista;
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
import objetos.Especialidad;
import objetos.Laboratorista;
import objetos.Turno;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "NuevoLaboratorista", urlPatterns = {"/NuevoLaboratorista"})
public class NuevoLaboratorista extends HttpServlet {

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
            out.println("<title>Servlet NuevoLaboratorista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoLaboratorista at " + request.getContextPath() + "</h1>");
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
        String codigo = request.getParameter("codigoLaboratorista");
        String nombre = request.getParameter("nombreLaboratorista");
        String DPI = request.getParameter("DPILaboratorista");
        String telefono = request.getParameter("telefonoLaboratorista");
        String correo = request.getParameter("correoLaboratorista");
        String password = request.getParameter("passwordLaboratorista");
        String registro = request.getParameter("registroLaboratorista");
        String fechaInicio = request.getParameter("fechaInicioLaboratorista");
        String nombreExamen = request.getParameter("examenLaboratorista");
        System.out.println(codigo);
            System.out.println(nombre);
            System.out.println(DPI);
        System.out.println(telefono);
            System.out.println(correo);
            System.out.println(password);
            System.out.println(registro);
            System.out.println(fechaInicio);
            System.out.println(nombreExamen);
            List<String> turno = new ArrayList<>();

        if (request.getParameter("Lunes") != null) {
            turno.add(request.getParameter("Lunes"));
            
        } 
        if (request.getParameter("Martes") != null) {
            turno.add(request.getParameter("Martes"));
            
        }
        if (request.getParameter("Miercoles") != null) {
            turno.add(request.getParameter("Miercoles"));
            
        } 
        if (request.getParameter("Jueves") != null) {
            turno.add(request.getParameter("Jueves"));

        }
        if (request.getParameter("Viernes") != null) {
            turno.add(request.getParameter("Viernes"));

        }
        if (request.getParameter("Sabado") != null) {
            turno.add(request.getParameter("Sabado"));

        } 
        if (request.getParameter("Domingo") != null) {
            turno.add(request.getParameter("Domingo"));

        }
        for (String string : turno) {
            System.out.println("Turno: "+string);
        }
        if (turno.isEmpty()) {
            request.setAttribute("Exitoso", false);

        } else {
            Laboratorista nuevoLaboratorista = new Laboratorista(codigo, nombre, DPI, telefono, correo, password, 2, registro, nombreExamen, fechaInicio, true, 1);
            Turno nuevoTurno = new Turno(turno);
            
            AccesoALaboratorista llenarLaboratorista = new AccesoALaboratorista();
            if (llenarLaboratorista.insertarNuevoLaboratorista(nuevoLaboratorista, nuevoTurno)) {
                request.setAttribute("Exitoso", true);
            } else {
                request.setAttribute("Exitoso", false);
            }

        }
        RequestDispatcher despachar = request.getRequestDispatcher("NuevoLaboratorista.jsp");
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
