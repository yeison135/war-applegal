package com.laboraapp.persistence;

import com.laboraapp.persistence.Hecho;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-25T12:54:05")
@StaticMetamodel(Evidencia.class)
public class Evidencia_ { 

    public static volatile SingularAttribute<Evidencia, String> descripcion;
    public static volatile SingularAttribute<Evidencia, Hecho> hechoIDSENTENCIA;
    public static volatile SingularAttribute<Evidencia, Integer> idEvidencia;
    public static volatile SingularAttribute<Evidencia, byte[]> foto;
    public static volatile SingularAttribute<Evidencia, String> archivo;
    public static volatile SingularAttribute<Evidencia, String> fechaRegistro;

}