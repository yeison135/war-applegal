package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import com.laboraapp.persistence.Municipio;
import com.laboraapp.persistence.TipoPersona;
import com.laboraapp.persistence.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T13:17:17")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> dirreccion;
    public static volatile ListAttribute<Persona, Usuario> usuarioList;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, String> numeroIdentificacion;
    public static volatile ListAttribute<Persona, Demanda> demandaList;
    public static volatile ListAttribute<Persona, TipoPersona> tipoPersonaList;
    public static volatile SingularAttribute<Persona, Municipio> idMunicipio;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Integer> edad;
    public static volatile SingularAttribute<Persona, String> ciudadDomicilio;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> correo;
    public static volatile SingularAttribute<Persona, Integer> idPersona;
    public static volatile SingularAttribute<Persona, String> numeroTelefono;

}