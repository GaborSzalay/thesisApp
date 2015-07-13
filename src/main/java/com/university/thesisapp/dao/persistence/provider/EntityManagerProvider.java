package com.university.thesisapp.dao.persistence.provider;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class EntityManagerProvider {
    public EntityManagerParams createEntityManagerWithTransaction() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        return new EntityManagerParams(entityManager, emf);
    }

    public void commitTransactionAndCloseConnection(EntityManagerParams entityManagerParams) {
        EntityManager entityManager = entityManagerParams.getEntityManager();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerParams.getEntityManagerFactory().close();
    }
}
