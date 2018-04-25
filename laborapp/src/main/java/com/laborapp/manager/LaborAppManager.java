package com.laborapp.manager;

import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.SalariosMinimos;
import com.laboraapp.persistence.TipoConflicto;
import com.laboraapp.persistence.TipoContrato;
import com.laboraapp.persistence.Usuario;
import com.laborapp.filtroDTO.FiltroDTO;
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

    public List<SalariosMinimos> ConsultarSalarios(EntityManager em) {
        Query consulta = em.createNamedQuery("SalariosMinimos.findAll");
        List<SalariosMinimos> salarios = consulta.getResultList();
        return salarios;
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
            usuario = null;
        }

        return usuario;
    }
}
