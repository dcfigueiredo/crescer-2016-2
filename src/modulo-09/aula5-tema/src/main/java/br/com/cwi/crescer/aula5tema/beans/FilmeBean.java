/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.beans;

import br.com.cwi.crescer.aula5tema.entity.Filme;
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
public class FilmeBean extends AbstractDao<Filme, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Filme> list() {
        return this.getEntityManager().createQuery("select f from Filme f").getResultList();
    }

}
