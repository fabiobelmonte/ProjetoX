/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Repositorio;

import com.fbp.projetox.Controle.AbstractPersistence;
import com.fbp.projetox.Controle.ParamQuery;
import com.fbp.projetox.Entidade.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author F.Belmonte
 */
@Stateless
public class Usuarios extends AbstractPersistence<Usuario, Long> {

    @PersistenceContext
    EntityManager em;

    public Usuarios() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Usuario> validaUsuario(String usuario, String senha) {
        ParamQuery param = new ParamQuery();
        param.add("usuario", usuario);
        param.add("senha", senha);
        return super.listByQuery("usuario = :usuario and senha =:senha", param);
    }

}
