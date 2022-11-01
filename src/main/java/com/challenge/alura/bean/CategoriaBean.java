package com.challenge.alura.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Categoria")
public class CategoriaBean extends GenericBean {

    @Column(name = "titulo", length = 20)
    @NotBlank
    private String titulo;

    @NotBlank
    private String cor;
}
