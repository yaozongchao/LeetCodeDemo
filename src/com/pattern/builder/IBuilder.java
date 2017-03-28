package com.pattern.builder;

/**
 * Created by yzc on 17/3/28.
 */
public interface IBuilder {
    public void buildPartA();

    public void buildPartB();

    public Product getResult();
}
