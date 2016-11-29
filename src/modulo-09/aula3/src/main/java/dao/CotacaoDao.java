/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cotacao;
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

    @Override
    public void export() {
        List<Cotacao> lista = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;DT_COTACAO;DS_COTACAO_DOLLAR_AUSTRALIANO;DS_COTACAO_DOLLAR_CANADENSE;DS_COTACAO_EURO"
                    + ";DS_COTACAO_FRANCOSUICO;DS_COTACAO_LIBRA;DS_COTACAO_REAL;DS_COTACAO_YEN;DS_COTACAO_YUAN");
            for (Cotacao cotacao : lista) {
                writer.println(cotacao.getIdCotacao() + ";"
                        + cotacao.getDtCotacao() + ";"
                        + cotacao.getDsCotacaoDollarAustraliano() + ";"
                        + cotacao.getDsCotacaoDollarCanadense() + ";"
                        + cotacao.getDsCotacaoEuro() + ";"
                        + cotacao.getDsCotacaoFrancoSuico() + ";"
                        + cotacao.getDsCotacaoLibra() + ";"
                        + cotacao.getDsCotacaoReal() + ";"
                        + cotacao.getDsCotacaoYen() + ";"
                        + cotacao.getDsCotacaoYuan());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }
}
