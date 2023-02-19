package account;

public class Account {
	private String IBAN;
  private double balance;

  public String toString() {
    String s = "Account: IBAN="+ this.IBAN + ", balance=" + this.balance;
    return s;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public String getIBAN() {
    return this.IBAN;
  }

  public Account(String IBAN, double balance) {
    this.IBAN = IBAN;
    this.balance = balance;
  }
}
