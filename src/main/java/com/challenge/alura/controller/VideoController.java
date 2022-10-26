package com.challenge.alura.controller;

import com.challenge.alura.bean.VideoBean;
import com.challenge.alura.dto.VideoDTO;
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
@RequestMapping(path = "/v1/videos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll() {
        List<VideoBean> videos = videoService.findAll();
        return ResponseEntity.ok(videos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(videoService.getByIdDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid @NotNull VideoDTO videoDTO) {
        try {
            return ResponseEntity.ok(videoService.salvar(videoDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid @NotNull VideoDTO dto) {
        try {
            return ResponseEntity.ok(videoService.update(id, dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            videoService.delete(id);
            return ResponseEntity.ok("Loja excluída com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível excluir " + e.getMessage());
        }
    }
}
