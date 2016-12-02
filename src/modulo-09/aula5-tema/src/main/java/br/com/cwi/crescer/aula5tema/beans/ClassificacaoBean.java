/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.beans;

import br.com.cwi.crescer.aula5tema.entity.Classificacao;
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
public class ClassificacaoBean extends AbstractDao<Classificacao, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Classificacao> list() {
        return this.getEntityManager().createQuery("select c from Classificacao c").getResultList();
    }

}
