package com.pattern.proxy;

/**
 * Created by yzc on 17/3/28.
 */
public class Proxy implements IGiveGift {

    private Pursuiter mPursuiter;

    public Proxy(Pursuiter pursuiter) {
        super();
        this.mPursuiter = pursuiter;
    }

    @Override
    public void giveFlowers() {
        if (mPursuiter != null) {
            mPursuiter.giveFlowers();
        }
    }

    @Override
    public void giveDolls() {
        if (mPursuiter != null) {
            mPursuiter.giveDolls();
        }
    }
}
