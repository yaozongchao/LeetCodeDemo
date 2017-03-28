package com.pattern.state;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class AcceptState implements IState {

    @Override
    public void updateUI(OrderInfo orderInfo) {
        if (orderInfo.state == OrderInfo.kAccept) {
            Logger.getGlobal().info("已接单");
        }
        else if (orderInfo.preState == OrderInfo.kAccept){
            orderInfo.currentState = new DrivingState();
            orderInfo.updateUI();
        }
        orderInfo.preState = orderInfo.state;
    }
}
