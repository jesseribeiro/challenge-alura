package com.challenge.alura.repository;

import com.challenge.alura.bean.VideoBean;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<VideoBean, Long>, GenericRepository  {

}
