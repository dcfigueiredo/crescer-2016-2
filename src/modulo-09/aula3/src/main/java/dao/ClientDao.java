/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ClientDao implements IDao<Client> {

    private EntityManager em;

    public ClientDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Client client) {
        em.getTransaction().begin();
        try {
            em.persist(client);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client client) {
        em.getTransaction().begin();
        try {
            em.merge(client);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client client) {
        em.getTransaction().begin();
        try {
            em.remove(client);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Client> list() {
        return em.createQuery("Select c from Client c").getResultList();
    }

    @Override
    public void export() {
        List<Client> listaClients = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;NAME;USERNAME;EMAIL;STATE;PREFERRED COIN;PERMISSION;PASSWORD");
            for (Client client : listaClients) {
                writer.println(client.getIdCliente() + ";"
                        + client.getNmClient() + ";"
                        + client.getDsUserName() + ";"
                        + client.getDsEmail() + ";"
                        + client.getDsState() + ";"
                        + client.getDsPreferredCoin() + ";"
                        + client.getTpPERMISSION() + ";"
                        + client.getDsPassword());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Dry cat.");
        }
    }
}
