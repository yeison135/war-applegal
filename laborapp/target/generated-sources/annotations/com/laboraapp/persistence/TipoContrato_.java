package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T20:54:32")
@StaticMetamodel(TipoContrato.class)
public class TipoContrato_ { 

    public static volatile SingularAttribute<TipoContrato, Integer> idTipContrato;
    public static volatile ListAttribute<TipoContrato, Demanda> demandaList;
    public static volatile SingularAttribute<TipoContrato, String> fechaRegistro;
    public static volatile SingularAttribute<TipoContrato, String> descipcion;

}