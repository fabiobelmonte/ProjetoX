/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Controle.ParamQuery;
import com.fbp.projetox.Entidade.Familia;
import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Enums.Situacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author F.Belmonte
 */
@Stateless
public class Produtos extends AbstractPersistence<Produto, Long> {

    @PersistenceContext
    EntityManager em;

    public Produtos() {
        super(Produto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Produto> getSaldoProduto(Long id) {
        ParamQuery param = new ParamQuery();
        param.add("id", id);
        return super.listByQuery("id = :id", param);

    }

    public List<Produto> pesquisaSaldoProduto(Long id) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();
        if (id != null) {
            filtros = builder.equal(from.get("id"), id);
        }

        TypedQuery<Produto> typedQuery = em.createQuery(query.select(from).where(filtros));
        return typedQuery.getResultList();

    }

}
