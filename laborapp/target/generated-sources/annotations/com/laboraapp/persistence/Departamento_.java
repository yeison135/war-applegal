package com.laboraapp.persistence;

import com.laboraapp.persistence.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T20:54:32")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile SingularAttribute<Departamento, Integer> codigoDepartamento;
    public static volatile ListAttribute<Departamento, Municipio> municipioList;
    public static volatile SingularAttribute<Departamento, String> nombre;

}