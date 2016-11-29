/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Usuario;
import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class UsuarioDao implements IDao<Usuario>{

    private EntityManager em;

    public UsuarioDao(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Usuario usuario) {
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Usuario usuario) {
        em.getTransaction().begin();
        try {
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        em.getTransaction().begin();
        try {
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Usuario> list() {
        return em.createQuery("Select u from Usuario u").getResultList();
    }

}
