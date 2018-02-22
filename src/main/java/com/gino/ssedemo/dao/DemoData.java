package com.gino.ssedemo.dao;

import com.gino.ssedemo.model.Stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * demo data
 *
 * @author gino
 * Created on 16/02/2018
 */
public class DemoData {
    public static List<Stock> stockList = new ArrayList<>();
    public static List<String> stockNames = Arrays.asList("mango,banana,guava,infinity".split(","));
}
