package com.gino.ssedemo.component;

import com.gino.ssedemo.dao.DemoData;
import com.gino.ssedemo.model.Stock;
import com.gino.ssedemo.util.Tool;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * custom bean
 *
 * @author gino
 * Created on 16/02/2018
 */
@Component
public class CustomBean {
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            createRandomStock();
            DemoData.stockList.forEach(System.out::println);
        };
    }

    void createRandomStock() {
        DemoData.stockNames.forEach(stockName -> {
            DemoData.stockList.add(new Stock(stockName, Tool.generateRandomStockPrice()));
        });
    }
}
