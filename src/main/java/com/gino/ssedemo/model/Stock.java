package com.gino.ssedemo.model;

import lombok.*;

/**
 * Stock Quotation
 *
 * @author gino
 * Created on 16/02/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Stock {
    String name;
    float price;
}
