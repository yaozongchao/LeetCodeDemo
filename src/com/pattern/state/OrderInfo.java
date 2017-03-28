package com.pattern.state;

/**
 * Created by yzc on 17/3/28.
 */
public class OrderInfo {
    public static int kStandby = 0;
    public static int kDispatching = 1;
    public static int kAccept = 2;
    public static int kDriving = 3;
    public IState currentState = new StandbyState();

    public int state = kStandby;
    public int preState = -1;

    public void updateUI() {
        currentState.updateUI(this);
    }

}
