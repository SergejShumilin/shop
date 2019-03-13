package com.shop.sport.store;

import com.shop.sport.domain.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private final List<Product> products = new CopyOnWriteArrayList<>();
    private final AtomicLong idGeneration;

    public Storage() {
        products.add(new Product(1, "Nike", "sneakers", 95));
        products.add(new Product(2, "Adidas", "sneakers", 100));
        products.add(new Product(3, "Puma", "sneakers", 85));
        products.add(new Product(3, "Adidas", "shirts", 40));
        products.add(new Product(4, "Adidas", "shorts", 65));
        products.add(new Product(5, "Nike", "shirts", 55));
        products.add(new Product(6, "Nike", "shorts", 45));
        products.add(new Product(7, "Puma", "shirt", 35));
        products.add(new Product(8, "Puma", "shorts", 65));
        products.add(new Product(9, "NewBalance", "sneakers", 80));
        products.add(new Product(10, "NewBalance", "shirt", 80));
        products.add(new Product(11, "Reebok", "shirt", 45));
        products.add(new Product(12, "Reebok", "sneakers", 25));
        idGeneration = new AtomicLong(products.size());
    }

    public long getNextId(){
        return idGeneration.incrementAndGet();
    }

    public static Storage getInstance(){
        return INSTANCE;
    }

    public List<Product> getProducts(){
        return products;
    }
}
