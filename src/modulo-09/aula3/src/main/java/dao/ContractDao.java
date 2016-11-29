/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Client;
import entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ContractDao implements IDao<Contract> {

    private EntityManager em;

    public ContractDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Contract contract) {
        em.getTransaction().begin();
        try {
            em.persist(contract);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Contract contract) {
        em.getTransaction().begin();
        try {
            em.merge(contract);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Contract contract) {
        em.getTransaction().begin();
        try {
            em.remove(contract);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Contract> list() {
        return em.createQuery("Select c from Contract c").getResultList();
    }

}
