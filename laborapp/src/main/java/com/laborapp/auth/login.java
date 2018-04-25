/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laborapp.auth;

import com.laboraapp.persistence.Usuario;
import com.laborapp.entityManager.EMF;
import com.laborapp.manager.LaborAppManager;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.math.BigDecimal;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Yeisson alvarez
 */
@Path("auth")
public class login {
    EntityManager em = EMF.createEntityManager();
    @Context
    private UriInfo context;
    
    @POST
    @Path("valiadarToken")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response valiadarToken(Usuario usuario)throws 
            Exception{
        LaborAppManager manager = new LaborAppManager();
        Boolean user = manager.consultarUsuarioToken(usuario,em);
        if(user){
            String clave = "admin";
            Long tiempo = System.currentTimeMillis();
           String jwt = Jwts.builder()
                   .signWith(SignatureAlgorithm.HS256, clave)
                   .setSubject("User")
                   .setIssuedAt(new Date(tiempo))
                   .setExpiration(new Date(tiempo+500000000))
                   .claim("imail", "yeison6340@gmail.com")
                   .compact();
           JsonObject json = Json.createObjectBuilder()
                   .add("Token", jwt).build();
            return Response.status(Response.Status.ACCEPTED).entity(json).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    
}
