package com.pattern.proxy;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class Pursuiter implements IGiveGift {

    private String name;

    public Pursuiter(final String name) {
        super();
        this.name = name;
    }

    @Override
    public void giveDolls() {
        Logger.getGlobal().info(name + " giveDolls");
    }

    @Override
    public void giveFlowers() {
        Logger.getGlobal().info(name + " giveFlowers");
    }
}
