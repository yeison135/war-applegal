/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laboraapp.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "hecho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hecho.findAll", query = "SELECT h FROM Hecho h")
    , @NamedQuery(name = "Hecho.findByIdSentencia", query = "SELECT h FROM Hecho h WHERE h.idSentencia = :idSentencia")
    , @NamedQuery(name = "Hecho.findByDescripcion", query = "SELECT h FROM Hecho h WHERE h.descripcion = :descripcion")
    , @NamedQuery(name = "Hecho.findByDiasACancelar", query = "SELECT h FROM Hecho h WHERE h.diasACancelar = :diasACancelar")
    , @NamedQuery(name = "Hecho.findByFechaRegistro", query = "SELECT h FROM Hecho h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Hecho.findByTotal", query = "SELECT h FROM Hecho h WHERE h.total = :total")})
public class Hecho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SENTENCIA")
    private Integer idSentencia;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "DIAS_A_CANCELAR")
    private String diasACancelar;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private Double total;
    @JoinColumn(name = "ID_DEMANDA", referencedColumnName = "ID_DEMANDA")
    @ManyToOne(optional = false)
    private Demanda idDemanda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hechoIDSENTENCIA")
    @JsonBackReference(value = "evidenciaList")
    private List<Evidencia> evidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hechoIDSENTENCIA")
    @JsonBackReference(value = "peticionList")
    private List<Peticion> peticionList;

    public Hecho() {
    }

    public Hecho(Integer idSentencia) {
        this.idSentencia = idSentencia;
    }

    public Integer getIdSentencia() {
        return idSentencia;
    }

    public void setIdSentencia(Integer idSentencia) {
        this.idSentencia = idSentencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiasACancelar() {
        return diasACancelar;
    }

    public void setDiasACancelar(String diasACancelar) {
        this.diasACancelar = diasACancelar;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Demanda getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Demanda idDemanda) {
        this.idDemanda = idDemanda;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @XmlTransient
    public List<Peticion> getPeticionList() {
        return peticionList;
    }

    public void setPeticionList(List<Peticion> peticionList) {
        this.peticionList = peticionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSentencia != null ? idSentencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hecho)) {
            return false;
        }
        Hecho other = (Hecho) object;
        if ((this.idSentencia == null && other.idSentencia != null) || (this.idSentencia != null && !this.idSentencia.equals(other.idSentencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laboraapp.persistence.Hecho[ idSentencia=" + idSentencia + " ]";
    }
    
}
