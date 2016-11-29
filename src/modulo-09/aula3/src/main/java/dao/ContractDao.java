/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
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

    @Override
    public void export() {
        List<Contract> listaContracts = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;ID_CLIENT;NM_CONTRACT;DS_STATE;DS_WEBSITE;DS_DESCRIPTION");
            for (Contract contract : listaContracts) {
                writer.println(contract.getIdContract() + ";"
                        + contract.getClient().getIdCliente() + ";"
                        + contract.getNmContract() + ";"
                        + contract.getDsState() + ";"
                        + contract.getDsWebSite() + ";"
                        + contract.getDsDescription());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }

}
