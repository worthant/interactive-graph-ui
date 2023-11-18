package com.example.eclipselinkormjsfdemo.worthant.jsfgraph.db;

import com.example.eclipselinkormjsfdemo.worthant.jsfgraph.entity.ResultEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

public class ResultDAOImpl implements ResultDAO {
    private final EntityManager entityManager = JPAUtils.getFactory().createEntityManager();

    @Override
    public void addNewResult(ResultEntity result) {
        entityManager.getTransaction().begin();
        entityManager.persist(result);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateResult(Long result_id, ResultEntity result) {
        entityManager.getTransaction().begin();
        entityManager.merge(result);
        entityManager.getTransaction().commit();
    }

    @Override
    public ResultEntity getResultById(Long result_id) {
        return entityManager.getReference(ResultEntity.class, result_id);
    }

    @Override
    public Collection<ResultEntity> getAllResults() {
        var cm = entityManager.getCriteriaBuilder().createQuery(ResultEntity.class);
        Root<ResultEntity> root = cm.from(ResultEntity.class);
        return entityManager.createQuery(cm.select(root)).getResultList();
    }

    @Override
    public void deleteResult(ResultEntity result) {
        entityManager.getTransaction().begin();
        entityManager.remove(result);
        entityManager.getTransaction().commit();
    }

    @Override
    public void clearResults() {
        entityManager.clear();
    }
}
