package com.shop.sport.dao;

import com.shop.sport.domain.Product;
import com.shop.sport.store.Storage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductDAOTest {
    private DAO<Product> productDAO = ProductDAO.getINSTANCE();
    private Storage storage = Storage.getInstance();

    @Test
    public void shouldReturnSize(){
        int expected = storage.getProducts().size();
        long actual = productDAO.size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveProduct(){
        long sizeBefore = productDAO.size();
        Product product = Product.builder()
                .name("nike")
                .type("sneakers")
                .price(60)
                .build();
        productDAO.save(product);

        long sizeAfter = productDAO.size();
        assertEquals(sizeBefore+1, sizeAfter);
    }

    @Test
    public void shouldDeleteProduct(){
        Product product = Product.builder()
                .name("nike")
                .type("sneakers")
                .price(10)
                .build();
        productDAO.save(product);
        long sizeBefore = productDAO.size();
        productDAO.delete(product.getId());
        long sizeAfter = productDAO.size();

        assertEquals(sizeBefore-1, sizeAfter);
    }

}