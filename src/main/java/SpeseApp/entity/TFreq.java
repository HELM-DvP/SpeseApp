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
@Table(name = "t_freq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFreq.findAll", query = "SELECT t FROM TFreq t")
    , @NamedQuery(name = "TFreq.findByIdFreq", query = "SELECT t FROM TFreq t WHERE t.idFreq = :idFreq")
    , @NamedQuery(name = "TFreq.findByFrequenza", query = "SELECT t FROM TFreq t WHERE t.frequenza = :frequenza")})
public class TFreq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_freq")
    private Integer idFreq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "frequenza")
    private String frequenza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFreq")
    private Collection<TMovimenti> tMovimentiCollection;

    public TFreq() {
    }

    public TFreq(Integer idFreq) {
        this.idFreq = idFreq;
    }

    public TFreq(Integer idFreq, String frequenza) {
        this.idFreq = idFreq;
        this.frequenza = frequenza;
    }

    public Integer getIdFreq() {
        return idFreq;
    }

    public void setIdFreq(Integer idFreq) {
        this.idFreq = idFreq;
    }

    public String getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(String frequenza) {
        this.frequenza = frequenza;
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
        hash += (idFreq != null ? idFreq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFreq)) {
            return false;
        }
        TFreq other = (TFreq) object;
        if ((this.idFreq == null && other.idFreq != null) || (this.idFreq != null && !this.idFreq.equals(other.idFreq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpeseApp.entity.TFreq[ idFreq=" + idFreq + " ]";
    }
    
}
