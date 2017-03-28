package com.pattern.factory;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class SubtractOperation implements IOperation {
    @Override
    public void doSomething() {
        Logger.getGlobal().info("subtract operation");
    }
}
