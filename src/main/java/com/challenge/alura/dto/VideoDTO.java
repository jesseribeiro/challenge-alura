package com.challenge.alura.dto;

import com.challenge.alura.bean.VideoBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO extends GenericDTO<VideoBean> {

    private String titulo;
    private String descricao;
    private String url;

    public VideoDTO(VideoBean bean){
        id = bean.getId();
        titulo = bean.getTitulo();
        descricao = bean.getDescricao();
        url = bean.getUrl();
    }
}
