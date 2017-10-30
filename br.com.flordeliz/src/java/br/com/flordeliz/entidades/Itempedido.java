/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.flordeliz.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magno
 */
@Entity
@Table(name = "itempedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itempedido.findAll", query = "SELECT i FROM Itempedido i")
    , @NamedQuery(name = "Itempedido.findById", query = "SELECT i FROM Itempedido i WHERE i.id = :id")
    , @NamedQuery(name = "Itempedido.findByQuantidade", query = "SELECT i FROM Itempedido i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "Itempedido.findByTamano", query = "SELECT i FROM Itempedido i WHERE i.tamano = :tamano")
    , @NamedQuery(name = "Itempedido.findByValor", query = "SELECT i FROM Itempedido i WHERE i.valor = :valor")})
public class Itempedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamano")
    private int tamano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "idproduto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Calcado idproduto;
    @JoinColumn(name = "idpedido", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedido idpedido;

    public Itempedido() {
    }

    public Itempedido(Integer id) {
        this.id = id;
    }

    public Itempedido(Integer id, int quantidade, int tamano, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.tamano = tamano;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calcado getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Calcado idproduto) {
        this.idproduto = idproduto;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
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
        if (!(object instanceof Itempedido)) {
            return false;
        }
        Itempedido other = (Itempedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.flordeliz.entidades.Itempedido[ id=" + id + " ]";
    }
    
}
