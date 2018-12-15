package com.momor3n.reactive.service;

import com.momor3n.reactive.data.TimeAndSales;
import com.momor3n.reactive.data.TimeAndSalesKey;
import com.momor3n.reactive.repository.TimeAndSalesRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TimeAndSalesServiceImpl implements TimeAndSalesService {

	private final TimeAndSalesRepository timeAndSalesRepository;

	@Autowired
	public TimeAndSalesServiceImpl(TimeAndSalesRepository timeAndSalesRepository) {
		this.timeAndSalesRepository = timeAndSalesRepository;
	}

	@PostConstruct
	public void init() {
		timeAndSalesRepository.deleteAll().subscribe();
		Random random = new Random(99);

		// Sample data
		TimeAndSales trade1 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "BID"), 100, 3.07);
		TimeAndSales trade2 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "ASK"), 5000, 3.08);
		TimeAndSales trade3 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "BID"), 300, 3.07);
		TimeAndSales trade4 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "ASK"), 400, 3.08);
		TimeAndSales trade5 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "ASK"), 100, 3.08);
		TimeAndSales trade6 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "ASK"), 1000, 3.08);
		TimeAndSales trade7 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "BID"), 100, 3.07);
		TimeAndSales trade8 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "BID"), 4000, 3.07);
		TimeAndSales trade9 = new TimeAndSales(new TimeAndSalesKey("Z74.SG", LocalDateTime.now().plusNanos(random.nextInt()), "ASK"), 700, 3.08);
		List<TimeAndSales> timeAndSalesList = Arrays.asList(trade1, trade2, trade3, trade4, trade5, trade6, trade7, trade8, trade9);
		timeAndSalesRepository.insert(timeAndSalesList).subscribe();
	}

	@Override
	public Flux<TimeAndSales> streamAllTrades() {
		return timeAndSalesRepository.findAll().delayElements(Duration.ofMillis(500)).repeat();
	}

	@Override
	public Flux<TimeAndSales> getAllTradesByTicker(String ticker) {
		return timeAndSalesRepository.findByKeyTicker(ticker);
	}

}
