package com.challenge.alura.service;

import com.challenge.alura.dto.CategoriaDTO;
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
public class CategoriaServiceTest {

    @Autowired
    CategoriaService categoriaService;

    @Test
    public void testInsereCategoria() {
        CategoriaDTO categoria = new CategoriaDTO();
        categoria.setTitulo("Futebol");
        categoria.setCor("Verde");
        categoriaService.salvar(categoria);
    }
}
