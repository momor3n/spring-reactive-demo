package com.momor3n.reactive.repository;

import com.momor3n.reactive.data.TimeAndSales;
import com.momor3n.reactive.data.TimeAndSalesKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;

public interface TimeAndSalesRepository extends ReactiveCassandraRepository<TimeAndSales, TimeAndSalesKey> {

	Flux<TimeAndSales> findByKeyTicker(String ticker);

}
