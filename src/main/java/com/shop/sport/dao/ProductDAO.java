package com.shop.sport.dao;

import com.shop.sport.domain.Product;
import com.shop.sport.store.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDAO implements DAO<Product> {
    private static final ProductDAO INSTANCE = new ProductDAO();
    private final Storage storage = Storage.getInstance();

    public ProductDAO() {
    }

    public static ProductDAO getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Optional<Product> get(long id) {
        return storage.getProducts()
                .stream()
                .filter(product -> product.getId() == id)
                .findAny();
    }


    @Override
    public void save(Product entity) {
        long nextId = storage.getNextId();
        entity.setId(nextId);
        storage.getProducts().add(entity);
    }

    @Override
    public List findAll() {
        return new ArrayList<>(storage.getProducts());
    }

    @Override
    public void update(Product entity) {
        get(entity.getId())
                .ifPresent(product -> {
                    product.setName(entity.getName());
                    product.setType(entity.getType());
                    product.setPrice(entity.getPrice());
                });
    }

    @Override
    public void delete(long id) {
        storage.getProducts().removeIf(product -> product.getId()==id);
    }

    @Override
    public List<Product> findPage(int number, int pageSize) {
        return storage.getProducts().stream()
                .skip((number-1)*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public long size() {
        return storage.getProducts().size();
    }
}
