/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
import entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class CurrencyExchangeDao implements IDao<CurrencyExchange> {

    private EntityManager em;

    public CurrencyExchangeDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(CurrencyExchange currencyExchange) {
        em.getTransaction().begin();
        try {
            em.persist(currencyExchange);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(CurrencyExchange currencyExchange) {
        em.getTransaction().begin();
        try {
            em.merge(currencyExchange);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(CurrencyExchange currencyExchange) {
        em.getTransaction().begin();
        try {
            em.remove(currencyExchange);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<CurrencyExchange> list() {
        return em.createQuery("Select ce from CurrencyExchange ce").getResultList();
    }
}
