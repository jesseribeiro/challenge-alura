package com.challenge.alura.service;

import com.challenge.alura.bean.CategoriaBean;
import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.VideoDTO;
import com.challenge.alura.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class VideoService extends GenericService<VideoBean, VideoRepository> {

    @Autowired
    CategoriaService categoriaService;

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
        CategoriaBean categoria;
        if (dto.getCategoria() != null) {
            categoria = categoriaService.getById(dto.getCategoria());
        } else {
            categoria = categoriaService.getById(1L);
        }

        VideoBean video = new VideoBean();
        video.setDescricao(dto.getDescricao());
        video.setTitulo(dto.getTitulo());
        video.setUrl(dto.getUrl());
        video.setCategoria(categoria);
        save(video);

        return new VideoDTO(video);
    }

    @Transactional
    public VideoDTO update(Long id, VideoDTO dto) {
        if (dto == null || id == null) {
            throw new RuntimeException("Dados não foram encontrados!");
        }

        VideoBean video = getRepository().findById(id).get();
        if (dto.getDescricao() != null) {
            video.setDescricao(dto.getDescricao());
        }
        if (dto.getTitulo() != null) {
            video.setTitulo(dto.getTitulo());
        }
        if (dto.getUrl() != null) {
            video.setUrl(dto.getUrl());
        }
        CategoriaBean categoria;
        if (dto.getCategoria() != null) {
            categoria = categoriaService.getById(dto.getCategoria());
        } else {
            categoria = categoriaService.getById(1L);
        }
        video.setCategoria(categoria);

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

    public List<VideoDTO> getVideosByTItulo(String titulo) {
        return getRepository().findByTitulo(titulo);
    }
}
