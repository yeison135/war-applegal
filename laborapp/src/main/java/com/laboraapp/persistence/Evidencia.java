/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laboraapp.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "evidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e")
    , @NamedQuery(name = "Evidencia.findByIdEvidencia", query = "SELECT e FROM Evidencia e WHERE e.idEvidencia = :idEvidencia")
    , @NamedQuery(name = "Evidencia.findByDescripcion", query = "SELECT e FROM Evidencia e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Evidencia.findByArchivo", query = "SELECT e FROM Evidencia e WHERE e.archivo = :archivo")
    , @NamedQuery(name = "Evidencia.findByFechaRegistro", query = "SELECT e FROM Evidencia e WHERE e.fechaRegistro = :fechaRegistro")})
public class Evidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVIDENCIA")
    private Integer idEvidencia;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "ARCHIVO")
    private String archivo;
    @Size(max = 45)
    @Column(name = "FECHA_REGISTRO")
    private String fechaRegistro;
    @JoinColumn(name = "Hecho_ID_SENTENCIA", referencedColumnName = "ID_SENTENCIA")
    @ManyToOne(optional = false)
    private Hecho hechoIDSENTENCIA;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    public Evidencia() {
    }

    public Evidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public Integer getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        hash += (idEvidencia != null ? idEvidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidencia)) {
            return false;
        }
        Evidencia other = (Evidencia) object;
        if ((this.idEvidencia == null && other.idEvidencia != null) || (this.idEvidencia != null && !this.idEvidencia.equals(other.idEvidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laboraapp.persistence.Evidencia[ idEvidencia=" + idEvidencia + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
