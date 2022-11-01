package com.challenge.alura.service;

import com.challenge.alura.bean.GenericBean;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Getter
@Setter
public class GenericService<T extends GenericBean, DAO extends CrudRepository<T, Long>> {

    @Autowired
    private DAO repository;

    public T save(T bean) {
        if(bean.getId() != null) {
            return update(bean);
        }
        bean.setDataCadastro(Calendar.getInstance());
        return repository.save(bean);
    }

    public T saveNoDate(T bean) {
        return repository.save(bean);
    }

    public T update(T bean) {
        return repository.save(bean);
    }

    public void delete(T bean) {
        bean.setDataExclusao(Calendar.getInstance());
        repository.delete(bean);
    }

    public T getById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Entidade não encontrada")
        );
    }

    public List<T> convertIterableToList(Iterable<T> iterable){
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
