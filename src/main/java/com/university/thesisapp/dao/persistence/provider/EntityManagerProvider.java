package com.university.thesisapp.dao.persistence.provider;

import com.university.thesisapp.util.Validation;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Gábor on 2015.07.13..
 */
@Component
public class EntityManagerProvider {
    private static EntityManagerFactory entityManagerFactory = null;

    public EntityManagerHolder createEntityManagerWithTransaction() {
        if (Validation.empty(entityManagerFactory)) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jcg-JPA");
        }

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return new EntityManagerHolder(entityManager);
    }

    public void commitTransactionAndCloseConnection(EntityManagerHolder entityManagerHolder) {
        EntityManager entityManager = entityManagerHolder.getEntityManager();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
        entityManagerFactory = null;
    }
}
