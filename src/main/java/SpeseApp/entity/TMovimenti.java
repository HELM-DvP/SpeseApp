/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_movimenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = TMovimenti.FIND_ALL, query = "SELECT t FROM TMovimenti t")
    , @NamedQuery(name = "TMovimenti.findByIdMovimento", query = "SELECT t FROM TMovimenti t WHERE t.idMovimento = :idMovimento")
    , @NamedQuery(name = "TMovimenti.findByData", query = "SELECT t FROM TMovimenti t WHERE t.data = :data")
    , @NamedQuery(name = "TMovimenti.findByImporto", query = "SELECT t FROM TMovimenti t WHERE t.importo = :importo")
    , @NamedQuery(name = "TMovimenti.findByDescrizione", query = "SELECT t FROM TMovimenti t WHERE t.descrizione = :descrizione")
    , @NamedQuery(name= TMovimenti.FIND_BY_USER, query="SELECT t FROM TMovimenti t WHERE t.Utente.idUtente= :idUtente")
    })
public class TMovimenti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimento")
    private Integer idMovimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "importo")
    private BigDecimal importo;
    @Size(max = 50)
    @Column(name = "descrizione")
    private String descrizione;
    @JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private TUtenti Utente;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private TCategorie Categoria;
    @JoinColumn(name = "id_freq", referencedColumnName = "id_freq")
    @ManyToOne(optional = false)
    private TFreq Freq;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TTipi Tipo;
    
    public static final String FIND_ALL="TMovimenti.findAll";
    public static final String FIND_BY_USER="TMovimenti.findByUser";

    public TMovimenti() {
    }

    public TMovimenti(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public TMovimenti(Integer idMovimento, Date data, BigDecimal importo) {
        this.idMovimento = idMovimento;
        this.data = data;
        this.importo = importo;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TUtenti getUtente() {
        return Utente;
    }

    public void setUtente(TUtenti Utente) {
        this.Utente = Utente;
    }

    public TCategorie getCategoria() {
        return Categoria;
    }

    public void setCategoria(TCategorie Categoria) {
        this.Categoria = Categoria;
    }

    public TFreq getFreq() {
        return Freq;
    }

    public void setFreq(TFreq Freq) {
        this.Freq = Freq;
    }

    public TTipi getTipo() {
        return Tipo;
    }

    public void setTipo(TTipi Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimento != null ? idMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMovimenti)) {
            return false;
        }
        TMovimenti other = (TMovimenti) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpeseApp.entity.TMovimenti[ idMovimento=" + idMovimento + " ]";
    }
    
}
