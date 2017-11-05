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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
     public List<MovimentoEstoque> getMovimentoProduto(Produto produto){
        ParamQuery param = new ParamQuery();
        param.add("produto", produto);
        return super.listByQuery("produto = :produto", param);
        
    }

}
