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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad")
    , @NamedQuery(name = "Persona.findByNumeroTelefono", query = "SELECT p FROM Persona p WHERE p.numeroTelefono = :numeroTelefono")
    , @NamedQuery(name = "Persona.findByDirreccion", query = "SELECT p FROM Persona p WHERE p.dirreccion = :dirreccion")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByNumeroIdentificacion", query = "SELECT p FROM Persona p WHERE p.numeroIdentificacion = :numeroIdentificacion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EDAD")
    private Integer edad;
    @Size(max = 45)
    @Column(name = "NUMERO_TELEFONO")
    private String numeroTelefono;
    @Size(max = 45)
    @Column(name = "DIRRECCION")
    private String dirreccion;
    @Size(max = 45)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    @JsonBackReference(value = "demandaList")
    private List<Demanda> demandaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    @JsonBackReference(value = "tipoPersonaList")
    private List<TipoPersona> tipoPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    @JsonBackReference(value = "usuarioList")
    private List<Usuario> usuarioList;
    @Size(max = 45)
    @Column(name = "CIUDAD_DOMICILIO")
    private String ciudadDomicilio;
    @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO")
    @ManyToOne
    private Municipio idMunicipio;
    @Size(max = 45)
    @Column(name = "TIPO_INDEN")
    private String tipoInden;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @XmlTransient
    public List<Demanda> getDemandaList() {
        return demandaList;
    }

    public void setDemandaList(List<Demanda> demandaList) {
        this.demandaList = demandaList;
    }

    @XmlTransient
    public List<TipoPersona> getTipoPersonaList() {
        return tipoPersonaList;
    }

    public void setTipoPersonaList(List<TipoPersona> tipoPersonaList) {
        this.tipoPersonaList = tipoPersonaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laboraapp.persistence.Persona[ idPersona=" + idPersona + " ]";
    }

    public String getCiudadDomicilio() {
        return ciudadDomicilio;
    }

    public void setCiudadDomicilio(String ciudadDomicilio) {
        this.ciudadDomicilio = ciudadDomicilio;
    }

    public Municipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getTipoInden() {
        return tipoInden;
    }

    public void setTipoInden(String tipoInden) {
        this.tipoInden = tipoInden;
    }
    
}
