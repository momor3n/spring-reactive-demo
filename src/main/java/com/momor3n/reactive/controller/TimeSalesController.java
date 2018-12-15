package com.momor3n.reactive.controller;

import com.momor3n.reactive.data.TimeAndSales;
import com.momor3n.reactive.service.TimeAndSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/ts", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeSalesController {

	private final TimeAndSalesService timeAndSalesService;

	@Autowired
	public TimeSalesController(TimeAndSalesService timeAndSalesService) {
		this.timeAndSalesService = timeAndSalesService;
	}

	@GetMapping("/{ticker}")
	public Flux<TimeAndSales> getTradesByTicker(@PathVariable String ticker) {
		return timeAndSalesService.getAllTradesByTicker(ticker);
	}

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<TimeAndSales> streamProfile() {
		return timeAndSalesService.streamAllTrades();
	}

}
