package com.gino.ssedemo.service;

import com.gino.ssedemo.model.Stock;
import com.gino.ssedemo.model.StockTransaction;
import com.gino.ssedemo.util.Tool;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * stock transaction service
 *
 * @author gino
 * Created on 16/02/2018
 */
@Service
public class StockTransactionService {

    public Flux<StockTransaction> getStockTransactions(List<Stock> stockList) {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                for (Stock stock : stockList) {
                    stock.setPrice(changePrice(stock.getPrice()));
                }
            }
        });
        Flux<StockTransaction> stockTransactionFlux = Flux.fromStream(Stream.generate(new Supplier<StockTransaction>() {
            @Override
            public StockTransaction get() {
                return new StockTransaction(null, Tool.getRandomUser(), getRandomStock(stockList), new Date());
            }
        }));
        // lambda dig
        return Flux.zip(interval, stockTransactionFlux).map(new Function<Tuple2<Long, StockTransaction>, StockTransaction>() {
            @Override
            public StockTransaction apply(Tuple2<Long, StockTransaction> objects) {
                StockTransaction stockTransaction = objects.getT2();
                stockTransaction.setId(objects.getT1());
                return stockTransaction;
            }
        });
        // return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }

    private float changePrice(float price) {
        return Tool.roundFloat(Math.random() >= 0.5 ? price * 1.05f : price * 0.95f);
    }

    private Stock getRandomStock(List<Stock> stockList) {
        return stockList.get(new Random().nextInt(stockList.size()));
    }
}
