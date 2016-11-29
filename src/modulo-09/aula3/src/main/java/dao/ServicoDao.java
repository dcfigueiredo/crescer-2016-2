/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Servico;
import entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ServicoDao implements IDao<Servico> {

    private EntityManager em;

    public ServicoDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Servico servico) {
        em.getTransaction().begin();
        try {
            em.persist(servico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Servico servico) {
        em.getTransaction().begin();
        try {
            em.merge(servico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Servico servico) {
        em.getTransaction().begin();
        try {
            em.remove(servico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Servico> list() {
        return em.createQuery("Select s from Servico s").getResultList();
    }

}
