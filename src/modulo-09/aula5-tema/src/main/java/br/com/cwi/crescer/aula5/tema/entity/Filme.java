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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author daniel.figueiredo
 */
@Entity
@Table(name = "FILME")
public class Filme {

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
    private String dtFilme;
    
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
}
