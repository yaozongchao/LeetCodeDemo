package com.pattern.factory;

/**
 * Created by yzc on 17/3/28.
 */
public class AddOperationFactory implements IOperationFactory {
    @Override
    public IOperation createOperation() {
        return new AddOperation();
    }
}
