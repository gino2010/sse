package com.gino.ssedemo.util;

import java.util.Random;

/**
 * tool
 *
 * @author gino
 * Created on 16/02/2018
 */
public class Tool {
    public static float roundFloat(float number) {
        return Math.round(number * 100.0) / 100.0f;
    }

    public static String getRandomUser() {
        String users[] = "adam,tom,john,mike,bill,tony".split(",");
        return users[new Random().nextInt(users.length)];
    }

    public static float generateRandomStockPrice() {
        float min = 30;
        float max = 50;
        return min + roundFloat(new Random().nextFloat() * (max - min));
    }
}
