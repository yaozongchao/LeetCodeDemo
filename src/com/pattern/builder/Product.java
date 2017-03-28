package com.pattern.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by yzc on 17/3/28.
 */
public class Product {
    private List<String> partsArray = new ArrayList<String>();

    public void addPart(String part) {
        partsArray.add(part);
    }

    public void showParts() {
        Logger.getGlobal().info("展示parts---");
        for (int i = 0; i < partsArray.size(); i++) {
            Logger.getGlobal().info(partsArray.get(i));
        }
    }
}
