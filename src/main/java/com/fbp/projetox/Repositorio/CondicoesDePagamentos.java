/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Entidade.CondicaoDePagamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author F.Belmonte
 */
@Stateless
public class CondicoesDePagamentos extends AbstractPersistence<CondicaoDePagamento, Long> {

    @PersistenceContext
    EntityManager em;

    public CondicoesDePagamentos() {
        super(CondicaoDePagamento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
