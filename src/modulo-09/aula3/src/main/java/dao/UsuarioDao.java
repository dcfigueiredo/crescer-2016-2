/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Usuario;
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
public class UsuarioDao implements IDao<Usuario> {

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

    @Override
    public void export() {
        List<Usuario> lista = list();
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("client.csv")));
            writer.println("ID;DS_USERNAME;DS_EMAIL;DS_SITUACAO;NM_USUARIO;TP_PERMISSAO");
            for (Usuario usuario : lista) {
                writer.println(usuario.getIdUsuario() + ";"
                        + usuario.getDsUserName() + ";"
                        + usuario.getDsEmail() + ";"
                        + usuario.getDsSituacao() + ";"
                        + usuario.getNmUsuario() + ";"
                        + usuario.getTpPermissao());
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Empty dry cat.");
        }
    }
}
