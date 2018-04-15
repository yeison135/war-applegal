package com.laboraapp.persistence;

import com.laboraapp.persistence.TipoPersona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-18T00:21:03")
@StaticMetamodel(TipoIdentificacion.class)
public class TipoIdentificacion_ { 

    public static volatile SingularAttribute<TipoIdentificacion, String> descripcion;
    public static volatile SingularAttribute<TipoIdentificacion, Integer> idTipIdentificacion;
    public static volatile ListAttribute<TipoIdentificacion, TipoPersona> tipoPersonaList;
    public static volatile SingularAttribute<TipoIdentificacion, Date> fechaRegistro;

}