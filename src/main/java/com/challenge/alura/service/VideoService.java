package com.challenge.alura.service;

import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.VideoDTO;
import com.challenge.alura.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class VideoService extends GenericService<VideoBean, VideoRepository> {

    public List<VideoBean> findAll() {
        return convertIterableToList(getRepository().findAll());
    }

    public VideoDTO getByIdDTO(Long id) {
        VideoBean video = getById(id);
        if (video == null) {
            throw new RuntimeException("Vídeo não encontrado!");
        }
        return new VideoDTO(video);
    }

    public VideoDTO salvar(VideoDTO dto) {
        if (dto.getTitulo() == null || dto.getDescricao() == null || dto.getUrl() == null) {
            throw new RuntimeException("Dados faltandos!");
        }

        confereTitulo(dto.getTitulo());

        VideoBean video = new VideoBean();
        video.setDescricao(dto.getDescricao());
        video.setTitulo(dto.getTitulo());
        video.setUrl(dto.getUrl());
        save(video);

        return new VideoDTO(video);
    }

    @Transactional
    public VideoDTO update(Long id, VideoDTO dto) {
        if (dto == null || id == null) {
            throw new RuntimeException("Dados não foram encontrados!");
        }

        VideoBean video = getRepository().findById(id).get();
        if (video.getDescricao() != null) {
            video.setDescricao(dto.getDescricao());
        }
        if (video.getTitulo() != null) {
            confereTitulo(dto.getTitulo());
            video.setTitulo(dto.getTitulo());
        }
        if (video.getUrl() != null) {
            video.setUrl(dto.getUrl());
        }
        update(video);

        return new VideoDTO(video);
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Vídeo não foi encontrado!");
        }
        VideoBean video = getById(id);
        delete(video);
    }

    public String confereTitulo(String titulo) {
        if (titulo.length() > 20) {
            throw new RuntimeException("Título muito grande. Por favor, coloque um título menor!");
        }
        return titulo;
    }

    public String confereUrl(String url) {
        return null;
    }
}
