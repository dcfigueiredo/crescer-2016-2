package br.com.cwi.crescer.aula8.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable {

    private static final String SQ_NAME = "SQ_ELENCO";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_ELENCO")
    private Long id;

    @Basic(optional = false)
    @Size(min = 1, max = 255, message = "Descrição inválida {0}")
    @Column(name = "DS_ELENCO")
    private String descricao;
    
    @NotNull
    @OneToMany(cascade = ALL)
    @Basic(optional = false)
    private List<Ator> atores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
