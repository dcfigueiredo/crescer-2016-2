/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.web;

import br.com.cwi.crescer.aula5tema.beans.AtorBean;
import br.com.cwi.crescer.aula5tema.entity.Ator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
@ViewScoped
public class AtorRun {

    @EJB
    private AtorBean atorBean;

    private Ator ator;
    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.list();
        this.atores.sort((a, b) -> a.getIdAtor().compareTo(b.getIdAtor()));
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionar() {
        atorBean.insert(ator);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
