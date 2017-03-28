package com.pattern.builder;

/**
 * Created by yzc on 17/3/28.
 */
public class Director {

    public Product createProduct(IBuilder builder) {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getResult();
    }
}
