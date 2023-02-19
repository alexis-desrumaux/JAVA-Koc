package kuexchange;

public class Trader {
  private String name;
  private double balance;
  private double totalProfit;
  private Position[] positions = new Position[10];
  private int numberOfPositions;
  private double initialBalance;

  public String getName() {
    return this.name;
  }

  public double getBalance() {
    return this.balance;
  }

  public void printPositions()
  {
    for (int i = 0; i != this.getNumberOfPositions(); i += 1) {
      System.out.print(this.positions[i].toString());
    }
  }

  public double getTotalProfit()
  {
    return this.totalProfit;
  }

  public int getNumberOfPositions()
  {
    return this.numberOfPositions;
  }

  public void closePosition(int id, double closingPrice)
  {
    boolean isFound = false;

    for (int i = 0; i != this.getNumberOfPositions(); i += 1) {
      if (id == positions[i].getId()) {
        System.out.printf("Trader %s closed a position with ticker: %s	id: %d	entry price: %.2f USDT\n", this.name, this.positions[i].getTicker(), id, this.positions[i].getEntryPrice());
        this.positions[i].close(closingPrice);
        this.balance += this.positions[i].getNetProfit();
        this.totalProfit += this.positions[i].getNetProfit();
        isFound = true;
        break;
      }
    }
    if (isFound == false) {
      System.out.printf("Trader %s has no position with this id\n", this.name);
    }
  }

  public void openPosition(String ticker, int id, double size, double entryPrice) {
    boolean isFound = false;

    for (int i = 0; i != this.getNumberOfPositions(); i += 1) {
      if (id == positions[i].getId()) {
        if (size * entryPrice < this.balance) {
          positions[i].open(entryPrice, size);
          System.out.printf("Trader %s opened a position with ticker: %s	id: %d	entry price: %.2f USDT\n", this.name, ticker, id, entryPrice);
        } else {
          System.out.printf("Trader %s does not have enough balance to open this position\n", this.name);
        }
        isFound = true;
        break;
      }
    }
    if (isFound == false) {
      if (size * entryPrice < this.balance) {
        this.positions[this.getNumberOfPositions()] = new Position(ticker, id);
        this.positions[this.getNumberOfPositions()].open(entryPrice, size);
        this.numberOfPositions += 1;
        System.out.printf("Trader %s opened a position with ticker: %s	id: %d	entry price: %.2f USDT\n", this.name, ticker, id, entryPrice);
      } else {
        System.out.printf("Trader %s does not have enough balance to open this position\n", this.name);
      }
    }

    // TODO: Open a new position and add it to the positions array.
  }

  public String toString() {
    return String.format("Name: %s	Initial balance: %.1f USDT	Current balance: %.1f USDT	Balance growth: %.1f\n",
        name, this.initialBalance, this.balance, this.balance - this.initialBalance);
  }

  public Trader(String name, double balance) {
    this.name = name;
    this.initialBalance = balance;
    this.balance = balance;
    this.totalProfit = 0;
    this.numberOfPositions = 0;
  }
}
