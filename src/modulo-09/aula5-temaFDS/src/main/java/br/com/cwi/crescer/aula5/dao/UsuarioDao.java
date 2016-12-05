/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Usuario;
import br.com.cwi.crescer.aula5.utils.CriptografiaUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel
 */
public class UsuarioDao extends AbstractDao<Usuario, Long> {

    final EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Usuario t) {
        String senhaCriptografada = CriptografiaUtils.converterStringParaMd5(t.getDsPassword());
        t.setDsPassword(senhaCriptografada);
        this.getEntityManager().merge(t);
    }

    public Usuario encontrarUsuarioLogado(String email, String password) {
        //202cb962ac59075b964b07152d234b70
        String query = "SELECT u FROM Usuario u WHERE u.dsEmail = :email AND u.dsPassword = :password";
        TypedQuery<Usuario> tq = this.getEntityManager().createQuery(query, Usuario.class);
        tq.setParameter("email", email);
        tq.setParameter("password", password);
        List usuarios = tq.getResultList();
        if (!usuarios.isEmpty()) {
            return (Usuario) usuarios.get(0);
        }
        return null;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
