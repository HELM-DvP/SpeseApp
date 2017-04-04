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
@Table(name = "t_utenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = TUtenti.FIND_ALL, query = "SELECT t FROM TUtenti t")
    , @NamedQuery(name = "TUtenti.findByIdUtente", query = "SELECT t FROM TUtenti t WHERE t.idUtente = :idUtente")
    , @NamedQuery(name = "TUtenti.findByUser", query = "SELECT t FROM TUtenti t WHERE t.user = :user")
    , @NamedQuery(name = "TUtenti.findByPwd", query = "SELECT t FROM TUtenti t WHERE t.pwd = :pwd")
    , @NamedQuery(name = "TUtenti.findByMail", query = "SELECT t FROM TUtenti t WHERE t.mail = :mail")
    , @NamedQuery(name = TUtenti.FIND_BY_USER_AND_PWD, query = "SELECT t FROM TUtenti t WHERE t.user= :user AND t.pwd= :pwd")
})
public class TUtenti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utente")
    private Integer idUtente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "mail")
    private String mail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Utente")
    private Collection<TMovimenti> tMovimentiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Utente")
    private Collection<TCategorie> tCategorieCollection;

    public static final String FIND_ALL = "TUtenti.findAll";
    public static final String FIND_BY_USER_AND_PWD = "TUtenti.findByUserPwd";

    public TUtenti() {
    }

    public TUtenti(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public TUtenti(Integer idUtente, String user, String pwd, String mail) {
        this.idUtente = idUtente;
        this.user = user;
        this.pwd = pwd;
        this.mail = mail;
    }

    public TUtenti(String user, String pwd, String mail) {
        this.user = user;
        this.pwd = pwd;
        this.mail = mail;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @XmlTransient
    public Collection<TMovimenti> getTMovimentiCollection() {
        return tMovimentiCollection;
    }

    public void setTMovimentiCollection(Collection<TMovimenti> tMovimentiCollection) {
        this.tMovimentiCollection = tMovimentiCollection;
    }

    @XmlTransient
    public Collection<TCategorie> getTCategorieCollection() {
        return tCategorieCollection;
    }

    public void setTCategorieCollection(Collection<TCategorie> tCategorieCollection) {
        this.tCategorieCollection = tCategorieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtente != null ? idUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUtenti)) {
            return false;
        }
        TUtenti other = (TUtenti) object;
        if ((this.idUtente == null && other.idUtente != null) || (this.idUtente != null && !this.idUtente.equals(other.idUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpeseApp.entity.TUtenti[ idUtente=" + idUtente + " ]";
    }

}
