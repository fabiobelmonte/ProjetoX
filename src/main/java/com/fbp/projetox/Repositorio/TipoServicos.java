/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.TipoServico;
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
public class TipoServicos extends AbstractPersistence<TipoServico, Long> {

    @PersistenceContext
    EntityManager em;

    public TipoServicos() {
        super(TipoServico.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<TipoServico> tipoServicoPorFilial(Filial filial) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TipoServico> query = builder.createQuery(TipoServico.class);
        Root<TipoServico> from = query.from(TipoServico.class);

        Predicate filtros = builder.and();

        if (filial != null) {
            filtros = builder.and(filtros, builder.equal(from.get("filial"), filial));
        }
      
        TypedQuery<TipoServico> typedQuery = em.createQuery(query.select(from).where(filtros));
        return typedQuery.getResultList();

    }

}
