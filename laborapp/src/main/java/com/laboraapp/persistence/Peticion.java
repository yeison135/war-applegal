/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laboraapp.persistence;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "peticion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p")
    , @NamedQuery(name = "Peticion.findByIdPeticion", query = "SELECT p FROM Peticion p WHERE p.idPeticion = :idPeticion")
    , @NamedQuery(name = "Peticion.findByValorPeticion", query = "SELECT p FROM Peticion p WHERE p.valorPeticion = :valorPeticion")})
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PETICION")
    private Integer idPeticion;
    @Column(name = "VALOR_PETICION")
    private BigInteger valorPeticion;
    @JoinColumn(name = "hecho_ID_SENTENCIA", referencedColumnName = "ID_SENTENCIA")
    @ManyToOne(optional = false)
    private Hecho hechoIDSENTENCIA;

    public Peticion() {
    }

    public Peticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public BigInteger getValorPeticion() {
        return valorPeticion;
    }

    public void setValorPeticion(BigInteger valorPeticion) {
        this.valorPeticion = valorPeticion;
    }

    public Hecho getHechoIDSENTENCIA() {
        return hechoIDSENTENCIA;
    }

    public void setHechoIDSENTENCIA(Hecho hechoIDSENTENCIA) {
        this.hechoIDSENTENCIA = hechoIDSENTENCIA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeticion != null ? idPeticion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peticion)) {
            return false;
        }
        Peticion other = (Peticion) object;
        if ((this.idPeticion == null && other.idPeticion != null) || (this.idPeticion != null && !this.idPeticion.equals(other.idPeticion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laboraapp.persistence.Peticion[ idPeticion=" + idPeticion + " ]";
    }
    
}
