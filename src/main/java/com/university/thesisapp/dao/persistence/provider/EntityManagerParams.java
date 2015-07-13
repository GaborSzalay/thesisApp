package com.university.thesisapp.dao.persistence.provider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Gábor on 2015.07.13..
 */
public class EntityManagerParams {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerParams(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
