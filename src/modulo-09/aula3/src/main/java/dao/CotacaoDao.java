/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
import entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class CotacaoDao implements IDao<Cotacao> {

    private EntityManager em;

    public CotacaoDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Cotacao cotacao) {
        em.getTransaction().begin();
        try {
            em.persist(cotacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Cotacao cotacao) {
        em.getTransaction().begin();
        try {
            em.merge(cotacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cotacao cotacao) {
        em.getTransaction().begin();
        try {
            em.remove(cotacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Cotacao> list() {
        return em.createQuery("Select c from Contract c").getResultList();
    }
}
