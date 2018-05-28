package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T13:17:17")
@StaticMetamodel(TipoConflicto.class)
public class TipoConflicto_ { 

    public static volatile SingularAttribute<TipoConflicto, String> descripcion;
    public static volatile SingularAttribute<TipoConflicto, Integer> idTipoConflicto;
    public static volatile SingularAttribute<TipoConflicto, String> estado;
    public static volatile ListAttribute<TipoConflicto, Demanda> demandaList;
    public static volatile SingularAttribute<TipoConflicto, Date> fechaRegistro;

}