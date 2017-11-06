/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Controle.ParamQuery;
import com.fbp.projetox.Entidade.MovimentoEstoque;
import com.fbp.projetox.Entidade.Produto;
import java.util.Date;
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
public class MovimentosEstoque extends AbstractPersistence<MovimentoEstoque, Long> {

    @PersistenceContext
    EntityManager em;

    public MovimentosEstoque() {
        super(MovimentoEstoque.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<MovimentoEstoque> pesquisaMovimentacao(Produto produto, Date dataInicial, Date dataFinal) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<MovimentoEstoque> query = builder.createQuery(MovimentoEstoque.class);
        Root<MovimentoEstoque> from = query.from(MovimentoEstoque.class);

        Predicate filtros = builder.and();
        if (produto != null) {
            filtros = builder.equal(from.get("produto"), produto);
        }
        filtros = builder.between(from.<Date>get("dataMovimento"), dataInicial, dataFinal);
        TypedQuery<MovimentoEstoque> typedQuery = em.createQuery(query.select(from).where(filtros));
        return typedQuery.getResultList();

    }

}
