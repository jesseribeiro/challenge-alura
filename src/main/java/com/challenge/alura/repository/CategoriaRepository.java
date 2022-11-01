package com.challenge.alura.repository;

import com.challenge.alura.bean.CategoriaBean;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<CategoriaBean, Long>, GenericRepository  {

}
