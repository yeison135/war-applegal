package com.laboraapp.persistence;

import com.laboraapp.persistence.Evidencia;
import com.laboraapp.persistence.Persona;
import com.laboraapp.persistence.SalariosMinimos;
import com.laboraapp.persistence.Sentencia;
import com.laboraapp.persistence.TipoConflicto;
import com.laboraapp.persistence.TipoContrato;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-18T19:08:48")
@StaticMetamodel(Demanda.class)
public class Demanda_ { 

    public static volatile SingularAttribute<Demanda, TipoContrato> idTipContrato;
    public static volatile SingularAttribute<Demanda, Date> fechaIngreso;
    public static volatile SingularAttribute<Demanda, TipoConflicto> idTipoConflicto;
    public static volatile SingularAttribute<Demanda, Date> fechaRegistro;
    public static volatile SingularAttribute<Demanda, String> profecion;
    public static volatile ListAttribute<Demanda, Evidencia> evidenciaList;
    public static volatile SingularAttribute<Demanda, SalariosMinimos> idSalarioMinimo;
    public static volatile ListAttribute<Demanda, Sentencia> sentenciaList;
    public static volatile SingularAttribute<Demanda, String> salarioBase;
    public static volatile SingularAttribute<Demanda, Date> fechaDespido;
    public static volatile SingularAttribute<Demanda, Integer> idDemanda;
    public static volatile SingularAttribute<Demanda, Persona> idPersona;

}