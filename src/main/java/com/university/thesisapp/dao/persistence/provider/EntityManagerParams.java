package com.university.thesisapp.dao.persistence.provider;

import javax.persistence.EntityManager;

/**
 * Created by Gábor on 2015.07.13..
 */
public class EntityManagerParams {
    private EntityManager entityManager;

    public EntityManagerParams(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
