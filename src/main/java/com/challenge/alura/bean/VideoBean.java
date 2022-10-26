package com.challenge.alura.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Video")
public class VideoBean extends GenericBean {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String url;
}
