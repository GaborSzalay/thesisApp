package com.university.thesisapp.dao.persistence.provider;

import javax.persistence.EntityManager;

/**
 * Created by Gábor on 2015.07.13..
 */
public class EntityManagerHolder {
    private EntityManager entityManager;

    public EntityManagerHolder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
