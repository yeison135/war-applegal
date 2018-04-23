package com.laboraapp.persistence;

import com.laboraapp.persistence.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-18T19:08:48")
@StaticMetamodel(Oficina.class)
public class Oficina_ { 

    public static volatile SingularAttribute<Oficina, String> horario;
    public static volatile SingularAttribute<Oficina, Municipio> dMunicipio;
    public static volatile SingularAttribute<Oficina, Integer> idOficina;
    public static volatile SingularAttribute<Oficina, String> direccion;
    public static volatile SingularAttribute<Oficina, String> telefono;

}