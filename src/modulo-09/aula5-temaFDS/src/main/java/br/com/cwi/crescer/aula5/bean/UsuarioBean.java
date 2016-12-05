/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.bean;
import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
@Stateless
public class UsuarioBean extends AbstractBean<Usuario, Long, UsuarioDao>{

    private UsuarioDao dao;
    
    @Override
    public EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public UsuarioDao getDao() {
        if (dao == null) {
            dao = new UsuarioDao(this.getEntityManager());
        }
        return dao;
    }        
        
}
