/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.flordeliz.entidades.bean;

import br.com.flordeliz.entidades.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author magno
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "br.com.flordelizPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
}
