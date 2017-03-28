package com.pattern.decorator;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class Decorator extends OriginalObject {
    private OriginalObject p_object;
    public Decorator(OriginalObject object) {
        super();
        this.p_object = object;
    }

    private void doSomethingElse() {
        Logger.getGlobal().info("Decorator doSomethingElse");
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doSomethingElse();
    }
}
