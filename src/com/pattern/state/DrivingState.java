package com.pattern.state;

import org.omg.CORBA.ORB;

import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class DrivingState implements IState {

    @Override
    public void updateUI(OrderInfo orderInfo) {
        if (orderInfo.state == OrderInfo.kDriving) {
            Logger.getGlobal().info("开始开车");
        }
        else if (orderInfo.preState == OrderInfo.kDriving){
            orderInfo.currentState = new StandbyState();
            orderInfo.updateUI();
        }
        orderInfo.preState = orderInfo.state;
    }
}
