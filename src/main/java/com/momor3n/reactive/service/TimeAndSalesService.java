package com.momor3n.reactive.service;

import com.momor3n.reactive.data.TimeAndSales;
import reactor.core.publisher.Flux;

public interface TimeAndSalesService {

	Flux<TimeAndSales> streamAllTrades();
	Flux<TimeAndSales> getAllTradesByTicker(String ticker);

}
