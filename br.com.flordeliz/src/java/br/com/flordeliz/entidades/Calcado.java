/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.flordeliz.entidades;

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
 * @author magno
 */
@Entity
@Table(name = "calcado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calcado.findAll", query = "SELECT c FROM Calcado c")
    , @NamedQuery(name = "Calcado.findById", query = "SELECT c FROM Calcado c WHERE c.id = :id")
    , @NamedQuery(name = "Calcado.findByNome", query = "SELECT c FROM Calcado c WHERE c.nome = :nome")
    , @NamedQuery(name = "Calcado.findByColecao", query = "SELECT c FROM Calcado c WHERE c.colecao = :colecao")
    , @NamedQuery(name = "Calcado.findByTamMax", query = "SELECT c FROM Calcado c WHERE c.tamMax = :tamMax")
    , @NamedQuery(name = "Calcado.findByTamMin", query = "SELECT c FROM Calcado c WHERE c.tamMin = :tamMin")
    , @NamedQuery(name = "Calcado.findByPrecoCusto", query = "SELECT c FROM Calcado c WHERE c.precoCusto = :precoCusto")
    , @NamedQuery(name = "Calcado.findByCor", query = "SELECT c FROM Calcado c WHERE c.cor = :cor")
    , @NamedQuery(name = "Calcado.findByValorVenda", query = "SELECT c FROM Calcado c WHERE c.valorVenda = :valorVenda")})
public class Calcado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "colecao")
    private String colecao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamMax")
    private int tamMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamMin")
    private int tamMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precoCusto")
    private double precoCusto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorVenda")
    private double valorVenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduto")
    private Collection<Itempedido> itempedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcalcado")
    private Collection<Lote> loteCollection;

    public Calcado() {
    }

    public Calcado(Integer id) {
        this.id = id;
    }

    public Calcado(Integer id, String nome, String colecao, int tamMax, int tamMin, double precoCusto, String cor, double valorVenda) {
        this.id = id;
        this.nome = nome;
        this.colecao = colecao;
        this.tamMax = tamMax;
        this.tamMin = tamMin;
        this.precoCusto = precoCusto;
        this.cor = cor;
        this.valorVenda = valorVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColecao() {
        return colecao;
    }

    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    public int getTamMax() {
        return tamMax;
    }

    public void setTamMax(int tamMax) {
        this.tamMax = tamMax;
    }

    public int getTamMin() {
        return tamMin;
    }

    public void setTamMin(int tamMin) {
        this.tamMin = tamMin;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @XmlTransient
    public Collection<Itempedido> getItempedidoCollection() {
        return itempedidoCollection;
    }

    public void setItempedidoCollection(Collection<Itempedido> itempedidoCollection) {
        this.itempedidoCollection = itempedidoCollection;
    }

    @XmlTransient
    public Collection<Lote> getLoteCollection() {
        return loteCollection;
    }

    public void setLoteCollection(Collection<Lote> loteCollection) {
        this.loteCollection = loteCollection;
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
        if (!(object instanceof Calcado)) {
            return false;
        }
        Calcado other = (Calcado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.flordeliz.entidades.Calcado[ id=" + id + " ]";
    }
    
}
