package com.challenge.alura.service;

import com.challenge.alura.dto.CategoriaDTO;
import com.challenge.alura.dto.VideoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    public void testInsereVideo() {
        VideoDTO video = new VideoDTO();
        video.setTitulo("Video Teste");
        video.setUrl("https://www.youtube.com/watch?v=5Sw02kmK0OI");
        video.setDescricao("Bola nas costas");
        video.setCategoria(2L);
        videoService.salvar(video);
    }
}
