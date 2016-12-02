/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author daniel.figueiredo
 */
@Entity
@Table(name = "FILME")
public class Filme implements Serializable{

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long idFilme;
            
    @Basic(optional = false)
    @Column(name = "NM_FILME")
    private String nmFilme;

    @Basic(optional = false)
    @Column(name = "DATE_FILME")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtFilme;
    
    @Basic(optional = false)
    @Column(name = "NM_DIRETO")
    private String nmDiretor;
    
    @OneToOne
    private Elenco elenco;
    
    @OneToOne
    private Genero genero;
    
    @OneToOne
    private Idioma idioma;
    
    @OneToOne
    private Classificacao classificacao;

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getNmFilme() {
        return nmFilme;
    }

    public void setNmFilme(String nmFilme) {
        this.nmFilme = nmFilme;
    }

    public Date getDtFilme() {
        return dtFilme;
    }

    public void setDtFilme(Date dtFilme) {
        this.dtFilme = dtFilme;
    }

    public String getNmDiretor() {
        return nmDiretor;
    }

    public void setNmDiretor(String nmDiretor) {
        this.nmDiretor = nmDiretor;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    
}
