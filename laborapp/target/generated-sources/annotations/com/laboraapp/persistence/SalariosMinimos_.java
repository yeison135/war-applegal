package com.laboraapp.persistence;

import com.laboraapp.persistence.Demanda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-24T21:22:52")
@StaticMetamodel(SalariosMinimos.class)
public class SalariosMinimos_ { 

    public static volatile ListAttribute<SalariosMinimos, Demanda> demandaList;
    public static volatile SingularAttribute<SalariosMinimos, Integer> idSalarioMinimo;
    public static volatile SingularAttribute<SalariosMinimos, String> salario;
    public static volatile SingularAttribute<SalariosMinimos, String> añoSalario;

}