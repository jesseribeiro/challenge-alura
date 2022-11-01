package com.challenge.alura.service;

import com.challenge.alura.bean.CategoriaBean;
import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.CategoriaDTO;
import com.challenge.alura.dto.VideoDTO;
import com.challenge.alura.repository.CategoriaRepository;
import com.challenge.alura.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CategoriaService extends GenericService<CategoriaBean, CategoriaRepository> {

    @Autowired
    VideoRepository videoRepository;

    public List<CategoriaBean> findAll() {
        return convertIterableToList(getRepository().findAll());
    }

    public CategoriaDTO getByIdDTO(Long id) {
        CategoriaBean categoria = getById(id);
        if (categoria == null) {
            throw new RuntimeException("Categoria não encontrada!");
        }
        return new CategoriaDTO(categoria);
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        if (dto.getTitulo() == null) {
            throw new RuntimeException("Título é obrigatório!");
        }

        if (dto.getCor() == null) {
            throw new RuntimeException("Cor é obrigatório!");
        }

        CategoriaBean categoria = new CategoriaBean();
        categoria.setCor(dto.getCor());
        categoria.setTitulo(dto.getTitulo());
        save(categoria);

        return new CategoriaDTO(categoria);
    }

    @Transactional
    public CategoriaDTO update(Long id, CategoriaDTO dto) {
        if (dto == null || id == null) {
            throw new RuntimeException("Dados não foram encontrados!");
        }

        CategoriaBean categoria = getRepository().findById(id).get();
        if (dto.getCor() != null) {
            categoria.setCor(dto.getCor());
        }
        if (dto.getTitulo() != null) {
            categoria.setTitulo(dto.getTitulo());
        }
        update(categoria);

        return new CategoriaDTO(categoria);
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Categoria não foi encontrada!");
        }
        CategoriaBean categoria = getById(id);
        delete(categoria);
    }

    public List<VideoDTO> getVideosIdCategoria(Long id) {
        return videoRepository.findVideosByCategoria(id);
    }
}
