/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.beans;

import br.com.cwi.crescer.aula5tema.entity.Idioma;
import br.com.cwi.crescer.aula5tema.repository.AbstractDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel.figueiredo
 */
@Stateless
public class IdiomaBean extends AbstractDao<Idioma, Long> {
 
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public IdiomaBean() {
        super(Idioma.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Idioma> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select i from Idioma i").getResultList();
    }

}
