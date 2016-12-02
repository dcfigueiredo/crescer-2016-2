/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.web;

import br.com.cwi.crescer.aula5tema.beans.ClassificacaoBean;
import br.com.cwi.crescer.aula5tema.entity.Classificacao;
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
public class ClassificacaoMBean {

    @EJB
    private ClassificacaoBean classificacaoBean;

    private Classificacao classificacao;
    private List<Classificacao> classificacoes;

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacoes = classificacaoBean.list();
        this.classificacoes.sort((a, b) -> a.getIdClassificacao().compareTo(b.getIdClassificacao()));
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public void adicionar() {
        classificacaoBean.insert(classificacao);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
