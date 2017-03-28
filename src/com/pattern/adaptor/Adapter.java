package com.pattern.adaptor;

/**
 * Created by yzc on 17/3/28.
 */
public class Adapter implements IPlayer {

    private ForeignPlayer mPlayer;

    public Adapter(ForeignPlayer player) {
        super();
        this.mPlayer = player;
    }

    @Override
    public void attack() {
        if (mPlayer != null) {
            mPlayer.gongji();
        }
    }

    @Override
    public void defend() {
        if (mPlayer != null) {
            mPlayer.fangshou();
        }
    }
}
