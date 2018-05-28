/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laborapp.resource;

import com.laboraapp.persistence.Demanda;
import com.laboraapp.persistence.Hecho;
import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.TipoConflicto;
import com.laboraapp.persistence.TipoContrato;
import com.laboraapp.persistence.Usuario;
import com.laborapp.entityManager.EMF;
import com.laborapp.filtroDTO.FiltroDTO;
import com.laborapp.manager.LaborAppManager;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author yalvarez
 */
@Path("legalapp")
public class LegalappResource {

    EntityManager em = EMF.createEntityManager();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LegalappResource
     */
    public LegalappResource() {
    }

    @GET
    @Path("consultarUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarUsuarios(@HeaderParam("Authorization") String userAgent) {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            List<Usuario> user = manager.consultarUsuarios(em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Path("consultarTipoConflicto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ConsultarTipoConflicto(@HeaderParam("Authorization") String userAgent) {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            List<TipoConflicto> tipo = manager.ConsultarTipoConflicto(em);
            return Response.status(Response.Status.ACCEPTED).entity(tipo).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Path("consultarTipoContrato")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ConsultarTipoContrato(@HeaderParam("Authorization") String userAgent) {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            List<TipoContrato> tipoContrato = manager.ConsultarTipoContrato(em);
            return Response.status(Response.Status.ACCEPTED).entity(tipoContrato).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(@HeaderParam("Authorization") String userAgent, Usuario usuario) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            Integer user = manager.registrarUsuario(usuario, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("registrarDemanda")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarDemanda(@HeaderParam("Authorization") String userAgent, Demanda demanda) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            Integer user = manager.registrarDemanda(demanda, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("registrarHecho")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarHecho(@HeaderParam("Authorization") String userAgent, Hecho hecho) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            Integer user = manager.registrarEcho(hecho, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("registrarPersona")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarPersona(@HeaderParam("Authorization") String userAgent, Persona persona) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            Integer user = manager.registrarPersona(persona, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    
     @POST
    @Path("consultarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarUsuario(@HeaderParam("Authorization") String userAgent, FiltroDTO filtro) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            Usuario user = manager.consultarUsuario(filtro, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    
    @POST
    @Path("consultarUsuarioId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarUsuarioId(@HeaderParam("Authorization") String userAgent, FiltroDTO filtro) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            Usuario user = manager.consultarUsuarioId(filtro, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("consultarDemanda")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarDemanda(@HeaderParam("Authorization") String userAgent, FiltroDTO filtro) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            Demanda demanda = manager.consultarDemanda(filtro, em);
            if (demanda != null) {
                return Response.status(Response.Status.ACCEPTED).entity(demanda).build();
            } else {
                return Response.status(Response.Status.ACCEPTED).entity(null).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("consultarHechos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarHechos(@HeaderParam("Authorization") String userAgent, FiltroDTO filtro) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            List<Hecho> hechos = manager.consultarHechos(filtro, em);
            if (hechos != null) {
                return Response.status(Response.Status.ACCEPTED).entity(hechos).build();
            } else {
                return Response.status(Response.Status.ACCEPTED).entity(null).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("consultarPersona")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarPersona(@HeaderParam("Authorization") String userAgent, FiltroDTO filtro) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            Usuario user = manager.consultarPersona(filtro, em);
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("actualizarPersona")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarPersona(@HeaderParam("Authorization") String userAgent, Persona persona) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            Boolean valPersona = manager.actualizarPersona(persona, em);
            return Response.status(Response.Status.ACCEPTED).entity(valPersona).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("actualizarTutorial")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarTutorial(@HeaderParam("Authorization") String userAgent, Usuario usuario) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent != null && userAgent.equals("Admin")) {
            Boolean valPersona = manager.actualizarTutorial(usuario, em);
            return Response.status(Response.Status.ACCEPTED).entity(valPersona).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("envioCorreo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response envioCorreo(@HeaderParam("Authorization") String userAgent, Persona personaP) throws
            Exception {
        LaborAppManager manager = new LaborAppManager();
        if (userAgent.equals("Admin")) {
            final String username = "yeison6340@gmail.com";
            final String password = "03216549877894561230";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "25");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(username, password);
                }
            });
            Persona persona = manager.consultarPersonaCorreo(personaP, em);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yeison6340@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("yeison6340@gmail.com"));
            message.setSubject("Notificación contacto");
            message.setText("Buen dia"
                    + "\n\n Nombre: " + persona.getNombre() + " " + persona.getApellido()
                    + "\n\n Correo: " + personaP.getCorreo()
                    + "\n\n Telefono: " + personaP.getNumeroTelefono()
                    + "\n\n Ciudad: " + personaP.getCiudadDomicilio()
                    + "\n\n\n\n  Descripcion: " + personaP.getDirreccion());
            Transport.send(message);
            System.out.println("Done");

            return Response.status(Response.Status.ACCEPTED).entity(persona).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    /**
     * PUT method for updating or creating an instance of LegalappResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
