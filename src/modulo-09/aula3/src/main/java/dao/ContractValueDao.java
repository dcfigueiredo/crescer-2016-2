/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
import entity.ContractValue;
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
    
    @Override
    public void export() {
        List<ContractValue> lista = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;CONTRACT_ID_CONTRACT;DS_AMOUNT_CONTRACT_VALUE;DS_COIN;DS_PERIODICITY;VL_MONTHLY_USD");
            for (ContractValue contractValue : lista) {
                writer.println(contractValue.getIdContractValue()+ ";"
                        + contractValue.getContract().getIdContract()+ ";"
                        + contractValue.getDsAmountContractValue()+ ";"
                        + contractValue.getDsCoin()+ ";"
                        + contractValue.getDsPeriodicity()+ ";"
                        + contractValue.getVlMonthlyUSD());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }
}
