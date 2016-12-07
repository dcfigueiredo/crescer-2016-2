package br.com.cwi.crescer.aula8.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "CLASSIFICACAO")
public class Classificacao implements Serializable {

    private static final String SQ_NAME = "SQ_CLASSIFICACAO";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_CLASSIFICACAO")
    private Long id;

    @Basic(optional = false)
    @Size(min = 1, max = 255, message = "Descrição inválida {0}")
    @Column(name = "DS_CLASSIFICACAO")
    private String descricao;

    @Basic(optional = false)
    @Min(value = 1)
    @Max(value = 200)
    @Column(name = "NR_IDADE")
    private Integer idade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
