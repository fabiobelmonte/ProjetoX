/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Controle;

/**
 *
 * @author F.Belmonte
 */

import com.fbp.projetox.Entidade.AbstractEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author Diego Arantes
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractPersistence<T extends AbstractEntity, PK extends Number> {

    /**
     * Classe da entidade, necessário para o método
     * <code>EntityManager.find</code>.
     */
    private Class<T> entityClass;

    @Resource(lookup = "java:/jboss/datasources/dbbel")
    DataSource datasource;

    public AbstractPersistence(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T save(T e) {
        if (e.getId() != null) {
            return getEntityManager().merge(e);
        } else {
            getEntityManager().persist(e);
            return e;
        }
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        return getEntityManager().createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    public int count() {
        Query q = getEntityManager().createQuery("from " + entityClass.getSimpleName(), entityClass);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * @param condicao
     * @param param
     * @return Objetos Filtrados pela condição e seus parâmetros
     */
    public List listByQuery(String condicao, ParamQuery param) {
        Query q = getEntityManager().createQuery("from " + entityClass.getSimpleName() + " where " + condicao);
        for (ParamQuery parametro : param.getParams()) {
            q.setParameter(parametro.getParam(), parametro.getObject());
        }
        return q.getResultList();
    }

    /**
     * @return retorna uma conexão jdbc
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    /**
     * Exige a definição do <code>EntityManager</code> responsável pelas
     * operações de persistência.
     *
     * @return
     */
    protected abstract EntityManager getEntityManager();
}
