package com.shop.sport.dao;

import com.shop.sport.domain.Product;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(long id);

    void save(T entity);

    List<T> findAll();

    void update(T entity);

    void delete(long id);

    List<Product> findPage(int number, int pageSize);

    long size();
}
