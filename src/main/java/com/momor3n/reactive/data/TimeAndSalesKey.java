package com.momor3n.reactive.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
@Data
@AllArgsConstructor
public class TimeAndSalesKey implements Serializable {

	@PrimaryKeyColumn(name = "ticker", type = PrimaryKeyType.PARTITIONED)
	private String ticker;
	@PrimaryKeyColumn(name = "timestamp", type = PrimaryKeyType.CLUSTERED)
	private LocalDateTime timestamp;
	@PrimaryKeyColumn(name = "event_type", type = PrimaryKeyType.PARTITIONED)
	private String eventType;

}
