/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.Servico;
import com.fbp.projetox.Entidade.TipoServico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author F.Belmonte
 */
@Stateless
public class Servicos extends AbstractPersistence<Servico, Long> {

    @PersistenceContext
    EntityManager em;

    public Servicos() {
        super(Servico.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Servico> servicoPorTipoEFilial(Filial filial) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Servico> query = builder.createQuery(Servico.class);
        Root<Servico> from = query.from(Servico.class);
        Join<TipoServico, Servico> join = from.join("tipoServico", JoinType.INNER);
        Predicate filtros = builder.and();

        if (filial != null) {
            filtros = builder.and(filtros, builder.equal(join.get("filial"), filial));
        }

        TypedQuery<Servico> typedQuery = em.createQuery(query.select(from).where(filtros));
        return typedQuery.getResultList();

    }

}
