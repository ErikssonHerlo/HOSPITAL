/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorPaciente;

import accesoAObjetos.AccesoAInforme;
import accesoAObjetos.AccesoAResultado;
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
import objetos.ReportePaciente;

/**
 *
 * @author erikssonherlo
 */
@WebServlet(name = "HistorialMedicoPaciente", urlPatterns = {"/HistorialMedicoPaciente"})
public class HistorialMedicoPaciente extends HttpServlet {

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
        //HISTORIAL MEDICO
                
               AccesoAInforme accesoMedico = new AccesoAInforme();
        String codigoUsuario = (String)request.getSession().getAttribute("codigoUsuario");
      // if(!accesoMedico.historialMedico(codigoUsuario).isEmpty())
       //{
            request.setAttribute("HistorialMedico", accesoMedico.historialMedico(codigoUsuario));
       /*}else {
             List<ReportePaciente> reporteVacio = new ArrayList<>();
             reporteVacio.add(new ReportePaciente(0, "El Paciente No Cuenta con Ninguna Consulta en Nuestro Hospital", "", "", "", ""));
           request.setAttribute("HistorialMedico", reporteVacio);
           
     
        }*/
        
        
        for (Object elementos: accesoMedico.historialMedico(codigoUsuario)) {
            System.out.println("Elemento: "+elementos);
        }
        //HISTORIAL LABORATORIO
                    AccesoAResultado accesoLab = new AccesoAResultado();
       //if(!accesoLab.historialLaboratorio(codigoUsuario).isEmpty())
       //{
            request.setAttribute("HistorialLaboratorio", accesoLab.historialLaboratorio(codigoUsuario));
         /*     } else {
              List<ReportePaciente> reporteVacio = new ArrayList<>();
              reporteVacio.add(new ReportePaciente(0, "El Paciente No Cuenta con Ningun Resultado en Nuestro Laboratorio", "", "", "", "", ""));
            request.setAttribute("HistorialLaboratorio", reporteVacio);
           
     
        }*/
        RequestDispatcher despachar = request.getRequestDispatcher("Historial_Paciente.jsp");
        despachar.forward(request, response);
        for (Object elementos: accesoLab.historialLaboratorio(codigoUsuario)) {
            System.out.println("Elemento: "+elementos);
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
