CREATE TABLE portfolio.my_dividend_by_portfolio (
  symbol TEXT,
  company_name TEXT,
  ex_date DATE,
  pay_date DATE,
  shares INT,
  div_amount DECIMAL,
  div_per_share DECIMAL,
  div_event_id TEXT,
  portfolio_id TEXT,
  PRIMARY KEY(portfolio_id, ex_date, pay_date, symbol)
);

CREATE KEYSPACE marketdata
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };

CREATE TABLE  marketdata.timesales_by_ticker (
  ticker TEXT,
  timestamp TIMESTAMP,
  event_type TEXT,
  size DOUBLE,
  price DOUBLE,
  PRIMARY KEY (ticker, timestamp, event_type)
  ) WITH CLUSTERING ORDER BY (timestamp DESC);