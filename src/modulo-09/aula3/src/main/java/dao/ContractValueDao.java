/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
import entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ContractValueDao implements IDao<ContractValue> {

    private EntityManager em;

    public ContractValueDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(ContractValue contractValue) {
        em.getTransaction().begin();
        try {
            em.persist(contractValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(ContractValue contractValue) {
        em.getTransaction().begin();
        try {
            em.merge(contractValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ContractValue contractValue) {
        em.getTransaction().begin();
        try {
            em.remove(contractValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<ContractValue> list() {
        return em.createQuery("Select cv from ContractValue cv").getResultList();
    }
}
