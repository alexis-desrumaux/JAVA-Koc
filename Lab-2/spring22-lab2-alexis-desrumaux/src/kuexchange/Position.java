package kuexchange;

public class Position {
  private String ticker;
  private int id;
  private boolean status;
  private double entryPrice;
  private double size;
  private double closingPrice;
  private double netProfit;

  public String toString() {
    if (status) {
      return String.format("(Position Closed)	Ticker: %s	id: %d	entry price: %.2f	closing price: %.2f	net profit: %.2f USDT\n", this.ticker, this.id, this.entryPrice, this.closingPrice, this.netProfit);
    }
    else {
      return String.format("(Position Open)	Ticker: %s	id: %d	entry price: %.2f\n", this.ticker, this.id, this.entryPrice);
    }
  }

  public double getNetProfit() {
    return this.netProfit;
  }

  public double getClosingPrice() {
    return this.closingPrice;
  }

  public double getEntryPrice() {
    return this.entryPrice;
  }

  public int getId() {
    return this.id;
  }

  public String getTicker() {
    return this.ticker;
  }

  public boolean isClosed() {
    return this.status;
  }

  public void close(double closingPrice) {
    this.closingPrice = closingPrice;
    this.netProfit = (this.closingPrice - this.entryPrice) * this.size;
    this.status = true;
  }

  public void open(double entryPrice, double size) {
    this.entryPrice = entryPrice;
    this.size = size;
    this.status = false;
  }

  public Position(String tickerName, int id) {
    this.ticker = tickerName;
    this.id = id;
    this.status = false;
    this.entryPrice = 0;
    this.size = 0;
    this.closingPrice = 0;
    this.netProfit = 0;
  }
}
