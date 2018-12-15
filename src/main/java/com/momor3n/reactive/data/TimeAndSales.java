package com.momor3n.reactive.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("timesales_by_ticker")
@Data
@AllArgsConstructor
public class TimeAndSales {

	@PrimaryKey
	private TimeAndSalesKey key;
	@Column("size")
	private double size;
	@Column("price")
	private double price;

}
