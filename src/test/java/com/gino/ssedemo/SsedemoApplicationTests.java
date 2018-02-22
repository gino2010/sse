package com.gino.ssedemo;

import com.gino.ssedemo.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsedemoApplicationTests {

	@Test
	public void contextLoads() {
        Stock stock = new Stock();
        stock.setPrice(1f);
	}

}
