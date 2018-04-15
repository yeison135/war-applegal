package com.laboraapp.persistence;

import com.laboraapp.persistence.Empresa;
import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.TipoIdentificacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-18T00:21:03")
@StaticMetamodel(TipoPersona.class)
public class TipoPersona_ { 

    public static volatile SingularAttribute<TipoPersona, String> tipoPersona;
    public static volatile ListAttribute<TipoPersona, Empresa> empresaList;
    public static volatile SingularAttribute<TipoPersona, TipoIdentificacion> idTipIdentificacion;
    public static volatile SingularAttribute<TipoPersona, Integer> idTipoPersona;
    public static volatile SingularAttribute<TipoPersona, Persona> idPersona;

}