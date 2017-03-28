package com.pattern.builder;

/**
 * Created by yzc on 17/3/28.
 */
public class BuilderB implements IBuilder {
    private Product mProduct = new Product();

    @Override
    public void buildPartB() {
        mProduct.addPart("BuilderB buildPartB");
    }

    @Override
    public void buildPartA() {
        mProduct.addPart("BuilderB buildPartA");
    }

    @Override
    public Product getResult() {
        return mProduct;
    }
}
