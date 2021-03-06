package com.laborapp.manager;

import com.laboraapp.persistence.Demanda;
import com.laboraapp.persistence.Hecho;
import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.TipoConflicto;
import com.laboraapp.persistence.TipoContrato;
import com.laboraapp.persistence.Usuario;
import com.laborapp.filtroDTO.FiltroDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LaborAppManager {

    public List<Usuario> consultarUsuarios(EntityManager em) {
        Query consulta = em.createNamedQuery("Usuario.findAll");
        List<Usuario> Personas = consulta.getResultList();
        return Personas;
    }

    public List<TipoConflicto> ConsultarTipoConflicto(EntityManager em) {
        Query consulta = em.createNamedQuery("TipoConflicto.findAll");
        List<TipoConflicto> conflicto = consulta.getResultList();
        return conflicto;
    }

    public List<TipoContrato> ConsultarTipoContrato(EntityManager em) {
        Query consulta = em.createNamedQuery("TipoContrato.findAll");
        List<TipoContrato> salarios = consulta.getResultList();
        return salarios;
    }

    public Integer registrarUsuario(Usuario usuario, EntityManager em)
            throws Exception {
        Integer registro;
        try {
            usuario.setFechaRegistro(new Date());
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            registro = usuario.getIdUsuario();
        } catch (Exception e) {
            registro = null;
        }
        return registro;
    }

    public Integer registrarPersona(Persona persona, EntityManager em)
            throws Exception {
        Integer registro;
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            registro = persona.getIdPersona();
        } catch (Exception e) {
            registro = null;
        }
        return registro;
    }

    public Integer registrarDemanda(Demanda demanda, EntityManager em)
            throws Exception {
        Integer registro;
        demanda.setFechaRegistro(new Date());
        try {
            em.getTransaction().begin();
            em.persist(demanda);
            em.getTransaction().commit();
            registro = demanda.getIdDemanda();
        } catch (Exception e) {
            registro = null;
        }
        return registro;
    }

    public Integer registrarEcho(Hecho hecho, EntityManager em)
            throws Exception {
        Integer registro;
        hecho.setFechaRegistro(new Date());
        try {
            em.getTransaction().begin();
            em.persist(hecho);
            em.getTransaction().commit();
            registro = hecho.getIdSentencia();
        } catch (Exception e) {
            registro = null;
        }
        return registro;
    }

    public Usuario consultarUsuario(FiltroDTO filtro, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.contrasena =:contrasena");
        Query query = em.createQuery(queryString.toString());
        if (filtro.getFiltroUno() != null && filtro.getFiltroDos() != null) {
            query.setParameter("usuario", filtro.getFiltroUno());
            query.setParameter("contrasena", filtro.getFiltroDos());
        }
        Usuario usuario = new Usuario();
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            usuario = new Usuario();
        }

        return usuario;
    }

    public Usuario consultarUsuarioId(FiltroDTO filtro, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u FROM Usuario u WHERE u.idUsuario =:idUsuario");
        Query query = em.createQuery(queryString.toString());
        if (filtro.getFiltroId() != null) {
            query.setParameter("idUsuario", filtro.getFiltroId());
        }
        Usuario usuario = new Usuario();
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            usuario = null;
        }

        return usuario;
    }
    
     public Demanda consultarDemanda(FiltroDTO filtro, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Demanda d WHERE d.idDemanda =:idDemanda");
        Query query = em.createQuery(queryString.toString());
        if (filtro.getFiltroId() != null) {
            query.setParameter("idDemanda", filtro.getFiltroId());
        }
        Demanda demanda = new Demanda();
        try {
            demanda = (Demanda) query.getSingleResult();
        } catch (Exception e) {
            demanda = null;
        }
        return demanda;
    }

    public Usuario consultarPersona(FiltroDTO filtro, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u FROM Usuario u WHERE u.idUsuario =:idUsuario");
        Query query = em.createQuery(queryString.toString());
        if (filtro.getFiltroId() != null) {
            query.setParameter("idUsuario", filtro.getFiltroId());
        }
        Usuario usuario = new Usuario();
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            usuario = null;
        }
        return usuario;
    }

    public Persona consultarPersonaCorreo(Persona persona, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        Persona personaR = new Persona();
        queryString.append("SELECT u FROM Usuario u WHERE u.idUsuario =:idUsuario");
        Query query = em.createQuery(queryString.toString());
        if (persona.getIdPersona() != null) {
            query.setParameter("idUsuario", persona.getIdPersona());
        }
        Usuario usuario = new Usuario();
        try {
            usuario = (Usuario) query.getSingleResult();
            personaR = usuario.getIdPersona();
        } catch (Exception e) {
            usuario = null;
        }
        return personaR;
    }
    
      public List<Hecho> consultarHechos(FiltroDTO filtro, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT h FROM Hecho h WHERE h.idDemanda.idDemanda =:idDemanda");
        Query query = em.createQuery(queryString.toString());
        if (filtro.getFiltroId() != null) {
            query.setParameter("idDemanda", filtro.getFiltroId());
        }
        List<Hecho> hecho = new ArrayList<Hecho>();
        try {
            hecho =  query.getResultList();
        } catch (Exception e) {
            hecho = null;
        }
        return hecho;
    }

    public Boolean actualizarPersona(Persona persona, EntityManager em) {
        Boolean valReturn;
        Usuario personaR = em.find(Usuario.class, persona.getIdPersona());
        if (personaR != null) {
            em.getTransaction().begin();
            personaR.getIdPersona().setNombre(persona.getNombre());
            personaR.getIdPersona().setApellido(persona.getApellido());
            personaR.getIdPersona().setDirreccion(persona.getDirreccion());
            personaR.getIdPersona().setNumeroIdentificacion(persona.getNumeroIdentificacion());
            personaR.getIdPersona().setNumeroTelefono(persona.getNumeroTelefono());
            em.getTransaction().commit();
            valReturn = true;
        } else {
            valReturn = false;
        }
        return valReturn;
    }
    
       public Boolean actualizarTutorial(Usuario usuario, EntityManager em) {
        Boolean valReturn;
        Usuario usuarior = em.find(Usuario.class, usuario.getIdUsuario());        
        if (usuarior.getIdUsuario() != null) {
            usuarior.setIndicador(1);
            em.getTransaction().begin();
            em.merge(usuarior);
            em.getTransaction().commit();
            valReturn = true;
        } else {
            valReturn = false;
        }
        return valReturn;
    }
       
        public Boolean actualizarCorreo(Usuario usuario, EntityManager em) {
        Boolean valReturn;
        Usuario usuarior = em.find(Usuario.class, usuario.getIdUsuario());        
        if (usuarior.getIdUsuario() != null) {
            usuarior.setCorreo(1);
            em.getTransaction().begin();
            em.merge(usuarior);
            em.getTransaction().commit();
            valReturn = true;
        } else {
            valReturn = false;
        }
        return valReturn;
    }

    public Boolean consultarUsuarioToken(Usuario usuario, EntityManager em) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.contrasena =:contrasena");
        Query query = em.createQuery(queryString.toString());
        if (usuario.getUsuario() != null && usuario.getContrasena() != null) {
            query.setParameter("usuario", usuario.getUsuario());
            query.setParameter("contrasena", usuario.getContrasena());
        }
        Usuario usuarioR = new Usuario();
        Boolean valUser = true;
        try {
            usuarioR = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            usuarioR = null;
        }
        if (usuarioR != null) {
            valUser = true;
        } else {
            valUser = false;
        }
        return valUser;
    }
}
