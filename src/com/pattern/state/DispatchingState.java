package com.pattern.state;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class DispatchingState implements IState {

    @Override
    public void updateUI(OrderInfo orderInfo) {
        if (orderInfo.state == OrderInfo.kDispatching) {
            Logger.getGlobal().info("正在派单");
        }
        else if (orderInfo.preState == OrderInfo.kDispatching){
            orderInfo.currentState = new AcceptState();
            orderInfo.updateUI();
        }
        orderInfo.preState = orderInfo.state;
    }
}
