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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = TCategorie.FIND_ALL, query = "SELECT t FROM TCategorie t")
    , @NamedQuery(name = "TCategorie.findByIdCategoria", query = "SELECT t FROM TCategorie t WHERE t.idCategoria = :idCategoria")
    , @NamedQuery(name = "TCategorie.findByNome", query = "SELECT t FROM TCategorie t WHERE t.nome = :nome")
    , @NamedQuery(name = TCategorie.FIND_BY_USER_AND_GENERAL,
            query = "SELECT t FROM TCategorie t WHERE t.idUtente = :idUtente AND t.idUtente = 1")})//trova categorie utente loggato e utente generale

public class TCategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<TMovimenti> tMovimentiCollection;
    @JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private TUtenti idUtente;

    public static final String FIND_ALL = "TCategorie.findAll";
    public static final String FIND_BY_USER_AND_GENERAL = "TCategorie.findByUserAndGeneral";

    public TCategorie() {
    }

    public TCategorie(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TCategorie(Integer idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<TMovimenti> getTMovimentiCollection() {
        return tMovimentiCollection;
    }

    public void setTMovimentiCollection(Collection<TMovimenti> tMovimentiCollection) {
        this.tMovimentiCollection = tMovimentiCollection;
    }

    public TUtenti getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(TUtenti idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCategorie)) {
            return false;
        }
        TCategorie other = (TCategorie) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpeseApp.entity.TCategorie[ idCategoria=" + idCategoria + " ]";
    }

}
