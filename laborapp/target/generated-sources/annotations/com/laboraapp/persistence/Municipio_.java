package com.laboraapp.persistence;

import com.laboraapp.persistence.Departamento;
import com.laboraapp.persistence.Oficina;
import com.laboraapp.persistence.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T13:17:17")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, Departamento> idDepartamento;
    public static volatile ListAttribute<Municipio, Persona> personaList;
    public static volatile SingularAttribute<Municipio, Integer> idMunicipio;
    public static volatile ListAttribute<Municipio, Oficina> oficinaList;
    public static volatile SingularAttribute<Municipio, Integer> codigoDane;
    public static volatile SingularAttribute<Municipio, String> nombre;

}