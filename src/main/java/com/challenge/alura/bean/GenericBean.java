package com.challenge.alura.bean;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public abstract class GenericBean {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long id;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCadastro;

    @Column(name = "data_exclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataExclusao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Calendar dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
