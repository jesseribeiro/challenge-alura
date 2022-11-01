package com.challenge.alura.repository;

import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.VideoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<VideoBean, Long>, GenericRepository  {

    @Query("Select new com.challenge.alura.dto.VideoDTO(x) from Video x where x.categoria.id =:id")
    List<VideoDTO> findVideosByCategoria(@Param("id") Long categoriaId);

    @Query("SELECT new com.challenge.alura.dto.VideoDTO(x) FROM Video x where " +
            " (:titulo is null or LOWER(x.titulo) LIKE LOWER(CONCAT('%',:titulo,'%'))) ")
    List<VideoDTO> findByTitulo(@Param("titulo") String titulo);
}
