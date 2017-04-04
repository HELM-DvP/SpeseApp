/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_tipi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipi.findAll", query = "SELECT t FROM TTipi t")
    , @NamedQuery(name = "TTipi.findByIdTipo", query = "SELECT t FROM TTipi t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TTipi.findByTipo", query = "SELECT t FROM TTipi t WHERE t.tipo = :tipo")})
public class TTipi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Tipo")
    private Collection<TMovimenti> tMovimentiCollection;

    public TTipi() {
    }

    public TTipi(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TTipi(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<TMovimenti> getTMovimentiCollection() {
        return tMovimentiCollection;
    }

    public void setTMovimentiCollection(Collection<TMovimenti> tMovimentiCollection) {
        this.tMovimentiCollection = tMovimentiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipi)) {
            return false;
        }
        TTipi other = (TTipi) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpeseApp.entity.TTipi[ idTipo=" + idTipo + " ]";
    }
    
}
