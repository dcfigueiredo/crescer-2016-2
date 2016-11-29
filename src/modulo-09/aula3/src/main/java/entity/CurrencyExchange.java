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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange implements Serializable{
//    CREATE TABLE "CURRENCY_EXCHANGE" ("ID_CURRENCY_EXCHANGE" NUMBER(19,0),
//            "DS_COIN" VARCHAR2(255 CHAR), "DT_CURRENCY_EXCHANGE" RAW(255),
//            "VL_RATE" NUMBER(17,6)) ;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private Long idCurrencyExchange;

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Basic(optional = false)
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private String dtCurrencyExchange;
    
    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private Double vlRate;

    public Long getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(Long idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(String dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public Double getVlRate() {
        return vlRate;
    }

    public void setVlRate(Double vlRate) {
        this.vlRate = vlRate;
    }
    
    
}
