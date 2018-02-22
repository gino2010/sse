package com.gino.ssedemo.controller;

import com.gino.ssedemo.dao.DemoData;
import com.gino.ssedemo.model.StockTransaction;
import com.gino.ssedemo.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * stock transaction contoller
 *
 * @author gino
 * Created on 16/02/2018
 */
@RestController
@RequestMapping("/stock/transaction")
public class StockTransactionController {

    @Autowired
    private StockTransactionService stockTransactionService;

    @GetMapping(produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<StockTransaction> stockTransactionEvents() {
        return stockTransactionService.getStockTransactions(DemoData.stockList);
    }
}
