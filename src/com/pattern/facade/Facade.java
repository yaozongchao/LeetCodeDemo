package com.pattern.facade;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 * 外观模式
 */
public class Facade {
    private SubObjectOne one = new SubObjectOne();
    private SubObjectTwo two = new SubObjectTwo();
    private SubObjectThree three = new SubObjectThree();

    public void methodA() {
        Logger.getGlobal().info("Facade methodA");
        one.subMethod();
        two.subMethod();
    }

    public void methodB() {
        Logger.getGlobal().info("Facade methodB");
        two.subMethod();
        three.subMethod();
    }
}
