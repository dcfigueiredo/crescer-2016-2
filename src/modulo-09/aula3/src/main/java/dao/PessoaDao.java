/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel.figueiredo
 */
public class PessoaDao implements IDao<Pessoa, Long> {
  
    private EntityManager em;

    public PessoaDao(EntityManager entityManager) {        
        em = entityManager;
    }

    @Override
    public void insert(Pessoa pessoa) {        
            em.getTransaction().begin();
            try {
                if (pessoa.getIdPessoa() != null) {
                    em.merge(pessoa);
                } else {
                    em.persist(pessoa);
                }
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }        
    }

    @Override
    public void delete(Pessoa pessoa) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        if (em.isOpen()) {
            em.getTransaction().begin();;
            try {
                em.remove(pessoa);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Pessoa find(Long id) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.close();
            emf.close();
            return pessoa;
        }
        em.close();
        emf.close();
        System.out.println("PEssoa nao encontrada");

        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return em.createQuery("Select p from Pessoa p").getResultList();
    }
}
