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
@Table(name = "USUARIO")
public class Usuario implements Serializable{
//    CREATE TABLE "USUARIO" ("ID_USUARIO" NUMBER(19,0), "DS_EMAIL" VARCHAR2(255 CHAR),
//            "DS_SENHA" VARCHAR2(255 CHAR), "DS_SITUACAO" VARCHAR2(255 CHAR),
//            "DS_USER_NAME" VARCHAR2(255 CHAR), "NM_USUARIO" VARCHAR2(255 CHAR),
//            "TP_PERMISSAO" VARCHAR2(255 CHAR)) ;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    
    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
    
    @Basic(optional = false)
    @Column(name = "TP_PERMISSAO")
    private String tpPermissao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getTpPermissao() {
        return tpPermissao;
    }

    public void setTpPermissao(String tpPermissao) {
        this.tpPermissao = tpPermissao;
    }
    
    
}
