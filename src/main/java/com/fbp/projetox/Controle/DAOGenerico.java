package com.fbp.projetox.Controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author D.Arantes
 * @param <T>
 */
public class DAOGenerico<T> {

    EntityManager em;
    EntityTransaction tx;

    public DAOGenerico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoX_PU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public void save(Object obj) {
        tx.begin();
        em.persist(obj);
        System.out.println(obj);
        tx.commit();

    }

    public List<T> listar() {

        Query q = em.createQuery("from ");
        return q.getResultList();

    }

    public void emClose() {
        em.close();
    }

}
