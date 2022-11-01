package com.challenge.alura.controller;

import com.challenge.alura.bean.CategoriaBean;
import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.CategoriaDTO;
import com.challenge.alura.dto.VideoDTO;
import com.challenge.alura.service.CategoriaService;
import com.challenge.alura.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/v1/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll() {
        List<CategoriaBean> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(categoriaService.getByIdDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid @NotNull CategoriaDTO categoriaDTO) {
        try {
            return ResponseEntity.ok(categoriaService.salvar(categoriaDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid @NotNull CategoriaDTO dto) {
        try {
            return ResponseEntity.ok(categoriaService.update(id, dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            categoriaService.delete(id);
            return ResponseEntity.ok("Categoria excluída com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível excluir " + e.getMessage());
        }
    }

    @GetMapping(path = "/{id}/videos")
    public ResponseEntity getVideosById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(categoriaService.getVideosIdCategoria(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
