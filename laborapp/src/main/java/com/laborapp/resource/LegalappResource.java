/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laborapp.resource;

import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.Usuario;
import com.laborapp.entityManager.EMF;
import com.laborapp.filtroDTO.FiltroDTO;
import com.laborapp.manager.LaborAppManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

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
    public List<Usuario> consultarUsuarios() {
        LaborAppManager manager = new LaborAppManager();
        List<Usuario> user = manager.consultarUsuarios(em);
        return user;
    }
    
    @POST
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer registrarUsuario(Usuario usuario)throws 
            Exception{
        LaborAppManager manager = new LaborAppManager();
        Integer user = manager.registrarUsuario(usuario,em);
        return user;
    }
      
    
    @POST
    @Path("registrarPersona")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer registrarPersona(Persona persona)throws 
            Exception{
        LaborAppManager manager = new LaborAppManager();
        Integer user = manager.registrarPersona(persona,em);
        return user;
    }
    
     @POST
    @Path("consultarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario consultarUsuario(FiltroDTO filtro)throws 
            Exception{
        LaborAppManager manager = new LaborAppManager();
        Usuario user = manager.consultarUsuario(filtro,em);
        return user;
    }


    /**
     * PUT method for updating or creating an instance of LegalappResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
