package com.pattern.adaptor;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class Center implements IPlayer {
    @Override
    public void attack() {
        Logger.getGlobal().info("Center attack");
    }

    @Override
    public void defend() {
        Logger.getGlobal().info("Center defend");
    }

}
