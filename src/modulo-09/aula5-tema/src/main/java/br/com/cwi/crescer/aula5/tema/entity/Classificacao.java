/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.tema.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author daniel.figueiredo
 */
@Entity
@Table(name = "CLASSIFICACAO")
public class Classificacao {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long idClassificacao;

    @Basic(optional = false)
    @Column(name = "NM_CLASSIFICACAO")
    private String nmClassificacao;

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public String getNmClassificacao() {
        return nmClassificacao;
    }

    public void setNmClassificacao(String nmClassificacao) {
        this.nmClassificacao = nmClassificacao;
    }
    
    
}
