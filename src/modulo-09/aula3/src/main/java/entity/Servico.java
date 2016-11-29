/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable{
//    CREATE TABLE "SERVICO" ("ID_SERVICO" NUMBER(19,0), "DS_DESCRICAO" VARCHAR2(801 CHAR),
//            "DS_PERIODICIDADE" VARCHAR2(255 CHAR), "DS_SIMBOLO_MOEDA" VARCHAR2(255 CHAR),
//            "DS_SITUACAO" VARCHAR2(255 CHAR), "DS_WEBSITE" VARCHAR2(255 CHAR), "NM_SERVICO" VARCHAR2(255 CHAR),
//            "VL_MENSAL_USD" NUMBER(17,6), "VL_TOTAL_SERVICO" NUMBER(17,6), "USUARIO_ID_USUARIO" NUMBER(19,0)) ;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idCurrencyExchange;

    @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    @Basic(optional = false)
    @Column(name = "DS_PERIDIOCIDADE")
    private String dsPeridiocidade;
    
    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;
    
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebSite;
    
    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;
    
    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private String vlsMensalUSD;
    
    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private String vlTotalServico;    
    
    @ManyToOne
    private Usuario usuario;
    
}
