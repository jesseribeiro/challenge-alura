package com.challenge.alura.dto;

import com.challenge.alura.bean.CategoriaBean;
import com.challenge.alura.bean.VideoBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO extends GenericDTO<CategoriaBean> {

    private String titulo;
    private String cor;

    public CategoriaDTO(CategoriaBean bean){
        id = bean.getId();
        titulo = bean.getTitulo();
        cor = bean.getCor();
    }
}
