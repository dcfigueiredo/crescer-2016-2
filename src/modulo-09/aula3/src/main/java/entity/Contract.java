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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CONTRACT")
public class Contract implements Serializable{
//    CREATE TABLE "CONTRACT" ("ID_CONTRACT" NUMBER(19,0),
//            "DS_DESCRIPTION" VARCHAR2(801 CHAR), "DS_STATE" VARCHAR2(255 CHAR), "DS_WEBSITE" VARCHAR2(255 CHAR),
//            "NM_CONTRACT" VARCHAR2(255 CHAR), "CLIENT_ID_CLIENT" NUMBER(19,0)) ;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT")
    private Long idContract;

    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescription;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebSite;

    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;

    @ManyToOne
    private Client client;
    
    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsWebSite() {
        return dsWebSite;
    }

    public void setDsWebSite(String dsWebSite) {
        this.dsWebSite = dsWebSite;
    }

    public String getNmContract() {
        return nmContract;
    }

    public void setNmContract(String nmContract) {
        this.nmContract = nmContract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
