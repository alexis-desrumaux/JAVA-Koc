package transaction;

import account.Account;

public class Transaction {
	private Account from;
  private Account to;
  private double amount;
  private boolean success;

  public String toStringInteractive() {
    String p = "from=Account: " + this.from.getIBAN() + ", balance=" + this.from.getBalance() + "\n";
    p += "to=Account: " + this.to.getIBAN() + ", balance=" + this.to.getBalance() + "\n";
    p += "amount=" + this.amount + '\n';
    p += "success=" + (this.success ? "true" : "false") + '\n';
    return p;
  }

  @Override
  public String toString() {
    String p = "from=Account [" + this.from.getIBAN() + ", balance=" + this.from.getBalance() + "]\n";
    p += "to=Account [" + this.to.getIBAN() + ", balance=" + this.to.getBalance() + "]\n";
    p += "amount=" + this.amount + '\n';
    p += "success=" + (this.success ? "true" : "false") + '\n';
    return p;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Transaction(Account from, Account to, double amount) {
    this.from = from;
    this.to = to;
    this.amount = amount;
  }
}
