package com.shop.sport.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String type;
    private String name;
    private double price;
}
