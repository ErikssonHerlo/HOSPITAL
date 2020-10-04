/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargaArchivos;

import accesoAObjetos.AccesoAAdministrador;
import accesoAObjetos.AccesoAConsulta;
import accesoAObjetos.AccesoAExamen;
import accesoAObjetos.AccesoALaboratorista;
import accesoAObjetos.AccesoAMedico;
import accesoAObjetos.AccesoAPaciente;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import objetos.Administrador;
import objetos.Consulta;
import objetos.Especialidad;
import objetos.Examen;
import objetos.Laboratorista;
import objetos.Medico;
import objetos.Paciente;
import objetos.Turno;
import objetos.Usuario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author erikssonherlo
 */
public class LecturaArchivo {
    private int idAgenda;


    public void dividirEtiquetas(String nombreArchivo) {
        
       //String path = "/home/julio/Documentos/IPC/Hospital/Proyecto2/data.xml";
       String path = "/home/erikssonherlo/NetBeansProjects/HOSPITAL/src/main/webapp/ArchivosDB/"+nombreArchivo;
        try {
            
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File(path));

            // Cojo todas las etiquetas admin del documento
            NodeList listaDoctores = documento.getElementsByTagName("doctor");
            NodeList listaAdmins = documento.getElementsByTagName("admin");
            NodeList listaLaboratoristas = documento.getElementsByTagName("laboratorista");
            NodeList listaPaciente = documento.getElementsByTagName("paciente");
            NodeList listadoExamen = documento.getElementsByTagName("examen");

            NodeList listadoInforme = documento.getElementsByTagName("reporte");
            NodeList listadoResultado = documento.getElementsByTagName("resultado");
            NodeList listadoCita = documento.getElementsByTagName("cita");
            NodeList listadoConsulta = documento.getElementsByTagName("consulta");

            etiquetaAdminDB(listaAdmins);
            //etiquetaDoctorDB(listaDoctores);
            //etiquetaLaboratoristaDB(listaLaboratoristas);
            etiquetaPacienteDB(listaPaciente);
            //etiquetaExamenDB(listadoExamen);
            //tagInforme(listadoInforme);
            //tagResultado(listadoResultado);
           // tagCita(listadoCita);
           // tagConsulta(listadoConsulta);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Recibe todos los atributos con la etiqueta <admin> y lo envia al accesoAObjetos y se rellena la base de Datos
     * DB indica el envio a la base de datos
     * @param listaAdmin 
     */
    public void etiquetaAdminDB(NodeList listaAdmin) {

        Administrador admin; // Recorro las etiquetas
        System.out.println(" <========>Especialidad");
        for (int i = 0; i < listaAdmin.getLength(); i++) {
            admin  = new Administrador("", "", "", "", "", "", 1);
       
            // Cojo el nodo actual
            Node nodo = listaAdmin.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido
                        if (!hijo.getNodeName().equalsIgnoreCase("horario")) {
                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                            switch (hijo.getNodeName().toUpperCase()) {
                                case "CODIGO":
                                    admin.setCodigo(hijo.getTextContent());
                                    break;
                                case "DPI":
                                    admin.setDPI(hijo.getTextContent());
                                    break;
                                case "NOMBRE":
                                    admin.setNombre(hijo.getTextContent());
                                    break;
                                case "PASSWORD":
                                    admin.setPassword(hijo.getTextContent());
                                    break;
                                default:
                                    System.out.println("Mostrar error, etiqueta no conocida");
                                //throw new AssertionError();
                            }

                        }

                    }

                }
                AccesoAAdministrador  nuevoAdmin = new AccesoAAdministrador();
                if(nuevoAdmin.insertarNuevoAdministrador(admin)){
                    System.out.println("Administrador Agregado Correctamente");
                }

            }

        }
    }

    /**
     * Recibe todos los atributos con la etiqueta <doctor> y lo envia al accesoAObjetos y se rellena la base de Datos
     * DB indica el envio a la base de datos
     * @param listaDoctor 
     */
    public void etiquetaDoctorDB(NodeList listaDoctor) {
        // Recorro las etiquetas
        
        Medico medico ;
        String[] horario = new String[2];
        List<String> especialidades = new ArrayList<>();

        for (int i = 0; i < listaDoctor.getLength(); i++) {
            medico = new Medico("", "", "", "", "", "", 2, 0, "", "", "", true);
       
            // Cojo el nodo actual
            Node nodo = listaDoctor.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        if (hijo.getNodeName().equalsIgnoreCase("horario")) {

                            horario = tagHorario(hijo);

                        } else if (hijo.getNodeName().equalsIgnoreCase("especialidad")) {
                            especialidades = tagEspecialidad(hijo);

                        } else {
                            crearMedico(medico, hijo.getNodeName(), hijo.getTextContent());

                        }
                    }

                }
                //Ultimos Atributos del Objeto Medico, para enviar al DAO
                medico.setHoraEntrada((String) horario[0]+":00");
                medico.setHoraSalida((String) horario[1]+":00");
                //Creacion de la especialidad, para enviarla a la base de datos
                Especialidad es = new Especialidad(especialidades, true);
                    
                    
                AccesoAMedico nuevoMedico = new AccesoAMedico();
                nuevoMedico.insertarNuevoMedico(medico, es);
                System.out.println("");
            }

        }
    }

    /**
     * Recibe todos los atributos con la etiqueta <laboratorista> y lo envia al accesoAObjetos y se rellena la base de Datos
     * DB indica el envio a la base de datos
     * @param listadoLaboratorista 
     */
    public void etiquetaLaboratoristaDB(NodeList listadoLaboratorista) {
        // Recorro las etiquetas
        System.out.println(" <========>Laboratorista");

        Laboratorista laboratorista;
        String[] horario ;
        List<String> turnos ;
        
        for (int i = 0; i < listadoLaboratorista
                .getLength(); i++) {
            
            //---------------------------PREGUNTAR LAS DIFERENCIAS DE INSTANCIAR EL OBJETO ANTES DEL FOR (MEDICO Y ADMIN) VS. DENTRO DEL FOR (LABORATORISTA)
            laboratorista = new Laboratorista("", "", "", "", "", "", 2,"", "", "", true);
            horario = new String[2];
            turnos = new ArrayList<>();
            
            // Cojo el nodo actual
            Node nodo = listadoLaboratorista.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        if (!hijo.getNodeName().equalsIgnoreCase("trabajo")) {

                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                            crearLaboratorista(laboratorista, hijo.getNodeName(), hijo.getTextContent());
                        } else {
                            //dias que trabaja
                            turnos = tagTrabajo(hijo);
                        }
                    }

                }
                
                
             
                    Turno nuevoTurno = new Turno(turnos);
                    
               
                   AccesoALaboratorista nuevoLaboratorista = new AccesoALaboratorista();
                   nuevoLaboratorista.insertarNuevoLaboratorista(laboratorista, nuevoTurno);
                   System.out.println("");
            }

        }
    }
/**
 * Recibe todos los atributos con la etiqueta <paciente> y lo envia al accesoAObjetos y se rellena la base de Datos
 * DB indica el envio a la base de datos
 * @param listadoPaciente 
 */
    public void etiquetaPacienteDB(NodeList listadoPaciente) {
        // Recorro las etiquetas
        System.out.println(" <========>Paciente");
        
        Paciente paciente;
        
        for (int i = 0; i < listadoPaciente.getLength(); i++) {
            
            paciente = new Paciente("", "", "", "", "", "", 3, "", "", "", "", true);
            
            // Cojo el nodo actual
            Node nodo = listadoPaciente.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        crearPaciente(paciente, hijo.getNodeName(), hijo.getTextContent());
             
                    }

                }
                /**
                 * Envio a la Base de Datos
                 */
                AccesoAPaciente nuevoPaciente = new AccesoAPaciente();
                nuevoPaciente.insertarNuevoPaciente(paciente);
                System.out.println("");
            }

        }
    }
/**
 * Recibe todos los atributos con la etiqueta <examen> y lo envia al accesoAObjetos y se rellena la base de Datos
 * DB indica el envio a la base de datos
 * @param listadoExamen 
 */
    public void etiquetaExamenDB(NodeList listadoExamen) {
        // Recorro las etiquetas
        System.out.println(" <========>Examen");
        Examen examen;
        
        for (int i = 0; i < listadoExamen.getLength(); i++) {
            
            examen = new Examen(0, "", true, "", 0.00, "", true);
            // Cojo el nodo actual
            Node nodo = listadoExamen.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        crearExamen(examen, hijo.getNodeName(), hijo.getTextContent());
             
                    }

                }
                AccesoAExamen nuevoExamen = new AccesoAExamen();
                nuevoExamen.insertarNuevoExamen(examen);
                System.out.println("");
            }

        }
    }

    public static void tagInforme(NodeList listadoInforme) {
        // Recorro las etiquetas
        System.out.println(" <========>Examen");
        for (int i = 0; i < listadoInforme.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = listadoInforme.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());

                    }

                }
                System.out.println("");
            }

        }
    }

    public static void tagResultado(NodeList listadoResultado) {
        // Recorro las etiquetas
        System.out.println(" <========>Examen");
        for (int i = 0; i < listadoResultado.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = listadoResultado.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        

                    }

                }
                System.out.println("");
            }

        }
    }
/*
    public void tagCita(NodeList listadoDeCitas) {
        // Recorro las etiquetas
        System.out.println(" <========>Examen");
        for (int i = 0; i < listadoDeCitas.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = listadoDeCitas.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Integer agenda = 0;
                Agenda agendaMedica = null;
                Dia dia = null;
                java.sql.Time horaCita = null;
                java.sql.Date fechaCita = null;

                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                Cita cita = new Cita();
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        String value = hijo.getTextContent();

                        switch (hijo.getNodeName().toUpperCase()) {
                            case "CODIGO":
                                cita.setCodigo(value);

                                break;
                            case "PACIENTE":
                                //CONSULTA,VERIFICA QUE EL PACIENTE EXISTA DENTRO DE LA DB

                                //if (agendaMedica != null) {
                                if (manager.getPacientesDAO().obtener(value) == null) {

                                    System.out.println("Aun no Existe agenda, crear");

                                } else {

                                    cita.setPacientes_codigo(value);

                                }

                                //}
                                break;
                            case "MEDICO":
                                if (agendaMedica != null) {

                                } else {

                                    if (manager.getMedicoDAO().obtener(Integer.parseInt(value)) == null) {
                                        System.out.println("Mostrar error el Medico no existe");
                                    } else {

                                        if (manager.getAgendaDAO().obtenerAgendaMedica(Integer.parseInt(value)) == null) {
                                            Agenda nueva = new Agenda(Integer.parseInt(value));

                                            manager.getAgendaDAO().insert(nueva);

                                            agenda = manager.getAgendaDAO().lastInsertId();

                                        } else {
                                            agendaMedica = manager.getAgendaDAO().obtenerAgendaMedica(Integer.parseInt(value));

                                        }
                                        //cita.set(Integer.parseInt(value));

                                    }

                                }

                                break;

                            case "FECHA":

                                fechaCita = java.sql.Date.valueOf(value);

                                break;
                            case "HORA":

                                horaCita = java.sql.Time.valueOf(value + ":00");
                                //dia.setHora(java.sql.Time.valueOf(value+":00"));

                                break;
                            default:

                        }

                    }

                }

                if (cita.getPacientes_codigo() != null) {

                    //verifico que no exista una cita con esa fecha y hora, en la agenda del doctor
                    if (manager.getDiaDAO().searchCoincidenceByDateHourAndAgenda(fechaCita, horaCita, agendaMedica.getCodigo()) != null) {

                        manager.getCitaDAO().insert(cita);
                        //(int idDia, java.sql.Date fecha, String descripcion, int Agenda_codigo, int Cita_codigo, java.sql.Time hora) {
                        dia = new Dia(0, fechaCita, "", agendaMedica.getCodigo(), cita.getCodigo(), horaCita);
                        manager.getDiaDAO().insert(dia);
                        

                    } else {
                        System.out.println(" Lanzar Error Cita existe en fecha y hora   ");
                    }
                }else{
                    System.out.println("no se puede crear cita, falta paciente");
                }
                System.out.println("");
            }

        }
    }
/**
 * Recibe todos los atributos con la etiqueta <consulta> y lo envia al accesoAObjetos y se rellena la base de Datos
 * DB indica el envio a la base de datos
 * @param listadoDeConsultas 
 */
    /*
    public void etiquetaConsultaDB(NodeList listadoDeConsultas) {
        Consulta consulta;
        // Recorro las etiquetas
        System.out.println(" <========>Consultas");
        for (int i = 0; i < listadoDeConsultas.getLength(); i++) {
            consulta = new Consulta("",0.00);
            // Cojo el nodo actual
            Node nodo = listadoDeConsultas.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido

                        System.out.println("Propiedad: " + hijo.getNodeName()
                                + ", Valor: " + hijo.getTextContent());
                        crearConsulta(consulta,hijo.getNodeName(), hijo.getTextContent());
                    }

                }
                AccesoAConsulta nuevaConsulta = new AccesoAConsulta();
                nuevaConsulta.insertarNuevaConsulta(consulta);
                System.out.println("");
            }

        }
    }
*/
    public List<String> tagEspecialidad(Node especialidad) {
        // Recorro las etiquetas
        List<String> especilidadesMedicas = new ArrayList<>();
        System.out.println("<========>Especialidad<========>Especialidad<========>");
        // for (int i = 0; i < especialidad.getLength(); i++) {
        // Cojo el nodo actual
        Node nodo = especialidad;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido

                    especilidadesMedicas.add(hijo.getTextContent());
                }

            }
            System.out.println("");
        }

        return especilidadesMedicas;
    }

    public String[] tagHorario(Node nodeHorario) {
        // Recorro las etiquetas
        String[] horario = new String[2];
        System.out.println("<========>HORARIO<========>HORARIO<========>");
        // for (int i = 0; i < especialidad.getLength(); i++) {
        // Cojo el nodo actual
        Node nodo = nodeHorario;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido
                    //horario[0][0] = hijo.getNodeName();
                    //horario[0][j] = hijo.getTextContent();
                    System.out.println("Propiedad: " + hijo.getNodeName()
                            + ", Valor: " + hijo.getTextContent());

                    if (hijo.getNodeName().equalsIgnoreCase("inicio")) {
                        horario[0] = hijo.getTextContent();
                    } else {
                        horario[1] = hijo.getTextContent();
                    }
                }

            }
            System.out.println("");
        }

        return horario;
    }

    public List<String> tagTrabajo(Node trabajoLab) {

        System.out.println("<========>DIas de Trabajo Laboratorista<========>");

        List<String> diasDeTrabajo = new ArrayList<>();
        Node nodo = trabajoLab;
        // Compruebo si el nodo es un elemento
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Lo transformo a Element
            Element e = (Element) nodo;
            // Obtengo sus hijos
            NodeList hijos = e.getChildNodes();
            // Recorro sus hijos
            for (int j = 0; j < hijos.getLength(); j++) {
                // Obtengo al hijo actual
                Node hijo = hijos.item(j);
                // Compruebo si es un nodo
                if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    // Muestro el contenido

                    System.out.println("Propiedad: " + hijo.getNodeName()
                            + ", Valor: " + hijo.getTextContent());

                    diasDeTrabajo.add(hijo.getTextContent());

                }

            }
            System.out.println("");
        }

        return diasDeTrabajo;
    }


    /**
     * Metodo que recibe la etiqueta y el atributo y lo almacena dentro del objeto
     * @param medico = objeto
     * @param tag = etiqueta del Archivo XML
     * @param atributo = valor que llenara al objeto
     */
    public void crearMedico(Medico medico, String tag, String atributo) {
        
        switch (tag.toUpperCase()) {
            case "CODIGO":
                medico.setCodigo(atributo);
                break;
            case "NOMBRE":
                medico.setNombre(atributo);
                break;
            case "COLEGIADO":
                medico.setColegiado(Integer.parseInt(atributo));
                break;
            case "DPI":
                medico.setDPI(atributo);
                break;
            case "TELEFONO":
                medico.setTelefono(atributo);
                break;
            case "CORREO":
                medico.setCorreo(atributo);
                break;
            case "TRABAJO":
                medico.setFechaInicio(atributo);
                break;
            case "PASSWORD":
                medico.setPassword(atributo);
                break;
            default:
        }
    }

    public void crearLaboratorista(Laboratorista lab, String tag, String atributo) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                lab.setCodigo(atributo);
                break;
            case "NOMBRE":
                lab.setNombre(atributo);
                break;
            case "REGISTRO":
                lab.setRegistro(atributo);
                break;
            case "DPI":
                lab.setDPI(atributo);
                break;
            case "TELEFONO":
                lab.setTelefono(atributo);
                break;
            case "EXAMEN": 
                lab.setNombreExamen(atributo);
                break;
            case "CORREO":
                lab.setCorreo(atributo);
                break;
           
                //case para la Etiqueta Trabajo, ira en un arraylist arriba
           
            case "TRABAJOF":
                lab.setFechaInicio(atributo);
                break;
            case "PASSWORD":
                lab.setPassword(atributo);
                break;
            default:

        }

    }

    public void crearPaciente(Paciente paciente, String tag, String atributo) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                paciente.setCodigo(atributo);
                break;
            case "NOMBRE":
                paciente.setNombre(atributo);
                break;
            case "SEXO":
                paciente.setSexo(atributo);
                break;
            case "BIRTH":
                paciente.setNacimiento(atributo);
                break;
            case "DPI":
                paciente.setDPI(atributo);
                break;
            case "TELEFONO":
                paciente.setTelefono(atributo);
                break;
            case "PESO": 
                paciente.setPeso(atributo);
                break;
            case "SANGRE":
                paciente.setTipoSangre(atributo);
                break;
            case "CORREO":
                paciente.setCorreo(atributo);
                break;
            case "PASSWORD":
                paciente.setPassword(atributo);
                break;
            default:

        }

    }

    public void crearExamen(Examen examen, String tag, String atributo) {

        switch (tag.toUpperCase()) {
            case "CODIGO":
                examen.setCodigoExamen(Integer.parseInt(atributo));
                break;
            case "NOMBRE":
                examen.setNombre(atributo);
                break;
            case "ORDEN":
                
                if (atributo.equalsIgnoreCase("true")) {
                    examen.setOrden(true);
                } else if (atributo.equalsIgnoreCase("false")) {
                    examen.setOrden(false);
                } else {
                    System.out.println("Lanzar error, no se reconoce token");//==========================================no se reconcoce si es verdadero o falso
                }
                break;
            case "DESCRIPCION":
                examen.setDescripcion(atributo);
                break;

            case "COSTO":
                examen.setCosto(Double.parseDouble(atributo));
                break;
            case "INFORME":
                examen.setFormato(atributo);
                break;

            default:

        }
    }
/*
    public void crearInforme(Informe informe, String tag, String value) {

        switch (tag.toUpperCase()) {
            case "CODIGO":

                informe.setIdInforme(value);
                break;
            case "PACIENTE":
                //CONSULTA,VERIFICA QUE EL PACIENTE EXISTA DENTRO DE LA DB

                if (manager.getPacientesDAO().obtener(value) == null) {
                    System.out.println("Mostrar error el paciente no existe");
                } else {
                    informe.setPacientes_codigo(value);
                }

                break;
            case "MEDICO":

                if (manager.getMedicoDAO().obtener(Integer.parseInt(value)) == null) {
                    System.out.println("Mostrar error el paciente no existe");
                } else {
                    informe.setMedico_colegiado(Integer.parseInt(value));
                }

                break;
            case "INFORME":

                informe.setDescripcion(value);
                break;

            case "FECHA":
                informe.setFechaHora(java.sql.Date.valueOf(value));

                break;
            case "HORA":

                informe.setHora(java.sql.Time.valueOf(value + ":00"));

                break;

            default:

        }

    }

    public void crearResultado(Resultado informe, String tag, String value) {

        switch (tag.toUpperCase()) {
            case "CODIGO":

                informe.setResultadoCodigo(value);
                break;
            case "PACIENTE":
                //CONSULTA,VERIFICA QUE EL PACIENTE EXISTA DENTRO DE LA DB

                if (manager.getPacientesDAO().obtener(value) == null) {
                    System.out.println("Mostrar error el paciente no existe");
                } else {
                    informe.setPacientes_codigo(value);
                }

                break;
            case "MEDICO":

                if (manager.getMedicoDAO().obtener(Integer.parseInt(value)) == null) {
                    System.out.println("Mostrar error el paciente no existe");
                } else {
                    informe.setMedicoColegiado(Integer.parseInt(value));
                }

                break;
            case "EXAMEN":

                if (manager.getExamenDAO().obtener(Integer.parseInt(value)) == null) {
                    System.out.println("Mostrar error el Examen no existe");
                } else {

                    informe.setExamen_Codigo(tag);
                }
                break;

            case "LABORATORISTA":

                if (manager.getLaboratoristasDAO().obtener(Integer.parseInt(value)) == null) {
                    System.out.println("Mostrar error el paciente no existe");
                } else {
                    informe.setLaboratoristasRegistro(Integer.parseInt(value));
                }

                break;
            case "FECHA":
                informe.setFechaHora(java.sql.Date.valueOf(value));

                break;
            case "ORDEN":

                //CARGAR IMAEN O ARCHIVO
                //====================================================================================================================================REVISAR
                break;

            case "INFORME":

                //CARGAR IMAEN O ARCHIVO
                //====================================================================================================================================REVISAR
                break;

            case "HORA":

                informe.setHora(java.sql.Time.valueOf(value + ":00"));

                break;

            default:

        }

    }

    public void crearConsulta(Consulta consulta ,String tag, String atributo) {

        switch (tag.toUpperCase()) {
            case "TIPO":
                consulta.setTipo(atributo);
                
                break;
            case "COSTO":
                consulta.setCosto(Double.parseDouble(atributo));
                break;
            default:
                System.out.println("Valor no permitido");
        }
    }
*/
    
}
