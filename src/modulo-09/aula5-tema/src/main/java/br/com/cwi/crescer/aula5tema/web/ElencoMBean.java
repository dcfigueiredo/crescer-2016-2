/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.web;

import br.com.cwi.crescer.aula5tema.beans.AtorBean;
import br.com.cwi.crescer.aula5tema.beans.ElencoBean;
import br.com.cwi.crescer.aula5tema.entity.Ator;
import br.com.cwi.crescer.aula5tema.entity.Elenco;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Daniel
 */
public class ElencoMBean {
    
    @EJB
    private ElencoBean elencoBean;
    
    @EJB
    private AtorBean atorBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;
    private List<Ator> atores;
    private List<String> nomeAtores;

    @PostConstruct
    public void init(){
        this.elenco = new Elenco();
        this.elencos = elencoBean.list();
        this.elencos.sort((a,b) -> a.getIdElenco().compareTo(b.getIdElenco()));
        this.atores = atorBean.list();
    }
    
    
    public void adicionar(){
        //... dar jeito de pegar a string que vem da página e 
        //... transformar em um ator pra adicionar na lista de atores e depois adicionar a lista ao elenco.
    }
    
    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }   

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public List<String> getNomeAtores() {
        return nomeAtores;
    }

    public void setNomeAtores(List<String> nomeAtores) {
        this.nomeAtores = nomeAtores;
    }
   
}
