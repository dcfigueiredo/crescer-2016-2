/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "CLIENT")
public class Client implements Serializable {
//    CREATE TABLE "CLIENT" ("ID_CLIENT" NUMBER(19,0), "DS_EMAIL" VARCHAR2(255 CHAR), "DS_PASSWORD" VARCHAR2(255 CHAR),
//            "DS_PREFERRED_COIN" VARCHAR2(255 CHAR), "DS_STATE" VARCHAR2(255 CHAR), "DS_USER_NAME" VARCHAR2(255 CHAR),
//            "NM_CLIENT" VARCHAR2(255 CHAR),
//            "TP_PERMISSION" VARCHAR2(255 CHAR)) ;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private Long idCliente;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Basic(optional = false)
    @Column(name = "DS_PASSWORD")
    private String dsPassword;

    @Basic(optional = false)
    @Column(name = "DS_PREFERRED_COIN")
    private String dsPreferredCoin;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;

    @Basic(optional = false)
    @Column(name = "NM_CLIENT")
    private String nmClient;

    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPERMISSION;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public String getDsPreferredCoin() {
        return dsPreferredCoin;
    }

    public void setDsPreferredCoin(String dsPreferredCoin) {
        this.dsPreferredCoin = dsPreferredCoin;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmClient() {
        return nmClient;
    }

    public void setNmClient(String nmClient) {
        this.nmClient = nmClient;
    }

    public String getTpPERMISSION() {
        return tpPERMISSION;
    }

    public void setTpPERMISSION(String tpPERMISSION) {
        this.tpPERMISSION = tpPERMISSION;
    }

}
