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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CONTRACT_VALUE")
public class ContractValue implements Serializable{
    
//    CREATE TABLE "CONTRACT_VALUE" ("ID_CONTRACT_VALUE" NUMBER(19,0), "DS_COIN" VARCHAR2(255 CHAR),
//            "DS_PERIODICITY" VARCHAR2(255 CHAR), "VL_AMOUNT_CONTRACT_VALUE" NUMBER(17,6),
//            "VL_MONTHLY_USD" NUMBER(17,6), "CONTRACT_ID_CONTRACT" NUMBER(19,0)) ;
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private Long idContractValue;
    
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    
    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;
    
    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    private String dsAmountContractValue;
    
    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD")
    private String vlMonthlyUSD;
    
    @OneToOne
    private Contract contract;

    public Long getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(Long idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public String getDsAmountContractValue() {
        return dsAmountContractValue;
    }

    public void setDsAmountContractValue(String dsAmountContractValue) {
        this.dsAmountContractValue = dsAmountContractValue;
    }

    public String getVlMonthlyUSD() {
        return vlMonthlyUSD;
    }

    public void setVlMonthlyUSD(String vlMonthlyUSD) {
        this.vlMonthlyUSD = vlMonthlyUSD;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
    
    
}
