/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCargaArchivo;

import accesoAObjetos.AccesoAAdministrador;
import cargaArchivos.LecturaArchivo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import objetos.Administrador;

/**
 *
 * @author erikssonherlo
 */
@MultipartConfig(maxFileSize = 16177215) //Maximo = 16mb
@WebServlet("/ControladorCargaArchivo")
public class ControladorCargaArchivo extends HttpServlet {

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
            out.println("<title>Servlet ControladorCargaArchivo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCargaArchivo at " + request.getContextPath() + "</h1>");
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
            //Guardar el Archivo XML en la carpeta ArchivosDB
             Part archivo = request.getPart("archivoDB");
             String nombreArchivo = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
             System.out.println("Path del Archivo: "+nombreArchivo);
             String pathAbsolutoArchivo = "/home/erikssonherlo/NetBeansProjects/HOSPITAL/src/main/webapp/ArchivosDB/"+nombreArchivo;
             //nombreArchivo = data.xml
             guardarArchivos(archivo, nombreArchivo);
             
             //Guardar todos los Archivos que estan incluidos dentro de la carga del Archivo en la carpeta ArchivosDB
                 
             ArrayList<Part> filePartArchivosDB = (ArrayList<Part>) request.getParts();       
             for (Part part : filePartArchivosDB) {
             String rutaArchivo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            guardarArchivos(part, rutaArchivo);
            }
             //
             LecturaArchivo lectura = new LecturaArchivo();
             lectura.dividirEtiquetas(pathAbsolutoArchivo);
             AccesoAAdministrador admin = new AccesoAAdministrador();
             if(admin.verificarEstadoDB())
             {
                    request.setAttribute("Exitoso", true);
     
             }else
             {
                request.setAttribute("Exitoso", false);
     
             }

        RequestDispatcher despachar = request.getRequestDispatcher("CargaArchivo.jsp");
        despachar.forward(request, response);
        
    }

    private void guardarArchivos(Part filePart,String rutaArchivo){
        File rutaDestino = new File("/home/erikssonherlo/NetBeansProjects/HOSPITAL/src/main/webapp/ArchivosDB");
        File file = new File(rutaDestino,rutaArchivo);

        try(InputStream inputS = filePart.getInputStream()) {
            Files.copy(inputS, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace(System.out);
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
