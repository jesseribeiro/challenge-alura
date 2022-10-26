package com.challenge.alura.repository;

public interface GenericRepository {
    String WHERE_EXCLUIDO = " WHERE (x.isExcluido is null or x.isExcluido is false) ";
}
