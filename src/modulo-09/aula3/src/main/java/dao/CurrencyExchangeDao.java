/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CurrencyExchange;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    public void export() {
        List<CurrencyExchange> lista = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;DS_COIN;DT_CURRENCY_EXCHANGE;VL_RATE");
            for (CurrencyExchange currencyExchange : lista) {
                writer.println(currencyExchange.getIdCurrencyExchange() + ";"
                        + currencyExchange.getDsCoin() + ";"
                        + currencyExchange.getDtCurrencyExchange() + ";"
                        + currencyExchange.getVlRate());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }
}
