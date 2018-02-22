package com.gino.ssedemo.model;

import lombok.*;

import java.util.Date;

/**
 * stock transaction
 *
 * @author gino
 * Created on 16/02/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StockTransaction {
    Long id;
    String user;
    Stock stock;
    Date when;
}
