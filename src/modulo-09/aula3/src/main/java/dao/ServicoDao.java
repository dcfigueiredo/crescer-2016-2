/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Servico;
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

    @Override
    public void export() {
        List<Servico> lista = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;DS_DESCRICAO;DS_PERIDIOCIDADE;DS_SIMBOLO_MOEDA;DS_SITUACAO;DS_WEBSITE;NM_SERVICO;VL_TOTAL_SERVICO;VL_MENSAL_USD;SERVICO_ID_SERVICO;USUARIO_ID_USUARIO");
            for (Servico servico : lista) {
                writer.println(servico.getIdServico() + ";"
                        + servico.getDsDescricao() + ";"
                        + servico.getDsPeridiocidade() + ";"
                        + servico.getDsSimboloMoeda() + ";"
                        + servico.getDsSituacao() + ";"
                        + servico.getDsWebSite() + ";"
                        + servico.getNmServico() + ";"
                        + servico.getVlTotalServico() + ";"
                        + servico.getVlsMensalUSD() + ";"
                        + servico.getIdServico() + ";"
                        + servico.getUsuario().getIdUsuario());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }

}
