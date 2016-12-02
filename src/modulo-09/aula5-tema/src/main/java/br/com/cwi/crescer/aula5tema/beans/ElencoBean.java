/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.beans;

import br.com.cwi.crescer.aula5tema.repository.AbstractDao;
import br.com.cwi.crescer.aula5tema.entity.Elenco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel.figueiredo
 */
@Stateless
public class ElencoBean extends AbstractDao<Elenco, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ElencoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Elenco> list() {
        return this.getEntityManager().createQuery("select e from Elenco e").getResultList();
    }

}
