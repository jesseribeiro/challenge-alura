package com.challenge.alura.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Video")
public class VideoBean extends GenericBean {

    private String titulo;
    private String descricao;
    private String url;
}
