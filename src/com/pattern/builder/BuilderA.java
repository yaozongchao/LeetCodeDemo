package com.pattern.builder;

/**
 * Created by yzc on 17/3/28.
 */
public class BuilderA implements IBuilder {
    private Product mProduct = new Product();

    @Override
    public void buildPartA() {
        mProduct.addPart("BuilderA buildPartA");
    }

    @Override
    public void buildPartB() {
        mProduct.addPart("BuilderA buildPartB");
    }

    @Override
    public Product getResult() {
        return mProduct;
    }
}
