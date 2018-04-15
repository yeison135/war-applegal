package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-18T00:21:03")
@StaticMetamodel(Sentencia.class)
public class Sentencia_ { 

    public static volatile SingularAttribute<Sentencia, String> descripcion;
    public static volatile SingularAttribute<Sentencia, String> diasACancelar;
    public static volatile SingularAttribute<Sentencia, Double> total;
    public static volatile SingularAttribute<Sentencia, Date> fechaRegistro;
    public static volatile SingularAttribute<Sentencia, Integer> idSentencia;
    public static volatile SingularAttribute<Sentencia, Demanda> idDemanda;

}