package com.pattern.adaptor;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class Guard implements IPlayer {

    @Override
    public void attack() {
        Logger.getGlobal().info("Guard attack");
    }

    @Override
    public void defend() {
        Logger.getGlobal().info("Guard defend");
    }
}
