package com.pattern.state;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class StandbyState implements IState {
    @Override
    public void updateUI(OrderInfo orderInfo) {
        if (orderInfo.state == OrderInfo.kStandby) {
            Logger.getGlobal().info("等待");
        }
        else if (orderInfo.preState == OrderInfo.kStandby){
            orderInfo.currentState = new DispatchingState();
            orderInfo.updateUI();
        }
        orderInfo.preState = orderInfo.state;
    }
}
