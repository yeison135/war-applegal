package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-18T00:21:03")
@StaticMetamodel(Evidencia.class)
public class Evidencia_ { 

    public static volatile SingularAttribute<Evidencia, String> descripcion;
    public static volatile SingularAttribute<Evidencia, Integer> idEvidencia;
    public static volatile SingularAttribute<Evidencia, byte[]> foto;
    public static volatile SingularAttribute<Evidencia, String> archivo;
    public static volatile SingularAttribute<Evidencia, String> fechaRegistro;
    public static volatile SingularAttribute<Evidencia, Demanda> idDemanda;

}