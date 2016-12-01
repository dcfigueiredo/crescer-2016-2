/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.beans;

import br.com.cwi.crescer.aula5tema.entity.Genero;
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
public class GeneroBean extends AbstractDao<Genero, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Genero> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
