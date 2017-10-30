/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.flordeliz.entidades;

import java.io.Serializable;
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
 * @author magno
 */
@Entity
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
    , @NamedQuery(name = "Lote.findById", query = "SELECT l FROM Lote l WHERE l.id = :id")
    , @NamedQuery(name = "Lote.findByCodigoProducao", query = "SELECT l FROM Lote l WHERE l.codigoProducao = :codigoProducao")
    , @NamedQuery(name = "Lote.findByDtProducao", query = "SELECT l FROM Lote l WHERE l.dtProducao = :dtProducao")
    , @NamedQuery(name = "Lote.findByTamanhoCalcado", query = "SELECT l FROM Lote l WHERE l.tamanhoCalcado = :tamanhoCalcado")
    , @NamedQuery(name = "Lote.findByQuantidadeProduzido", query = "SELECT l FROM Lote l WHERE l.quantidadeProduzido = :quantidadeProduzido")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigoProducao")
    private String codigoProducao;
    @Column(name = "dtProducao")
    @Temporal(TemporalType.DATE)
    private Date dtProducao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamanhoCalcado")
    private int tamanhoCalcado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadeProduzido")
    private int quantidadeProduzido;
    @JoinColumn(name = "idcalcado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Calcado idcalcado;

    public Lote() {
    }

    public Lote(Integer id) {
        this.id = id;
    }

    public Lote(Integer id, String codigoProducao, int tamanhoCalcado, int quantidadeProduzido) {
        this.id = id;
        this.codigoProducao = codigoProducao;
        this.tamanhoCalcado = tamanhoCalcado;
        this.quantidadeProduzido = quantidadeProduzido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoProducao() {
        return codigoProducao;
    }

    public void setCodigoProducao(String codigoProducao) {
        this.codigoProducao = codigoProducao;
    }

    public Date getDtProducao() {
        return dtProducao;
    }

    public void setDtProducao(Date dtProducao) {
        this.dtProducao = dtProducao;
    }

    public int getTamanhoCalcado() {
        return tamanhoCalcado;
    }

    public void setTamanhoCalcado(int tamanhoCalcado) {
        this.tamanhoCalcado = tamanhoCalcado;
    }

    public int getQuantidadeProduzido() {
        return quantidadeProduzido;
    }

    public void setQuantidadeProduzido(int quantidadeProduzido) {
        this.quantidadeProduzido = quantidadeProduzido;
    }

    public Calcado getIdcalcado() {
        return idcalcado;
    }

    public void setIdcalcado(Calcado idcalcado) {
        this.idcalcado = idcalcado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.flordeliz.entidades.Lote[ id=" + id + " ]";
    }
    
}
