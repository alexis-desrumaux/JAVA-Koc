package main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import account.Account;
import account.AccountValidator;
import transaction.Transaction;
import transaction.TransactionValidator;

public class Bank {
  private String name;
  private AccountValidator accountValidator;
  private TransactionValidator transactionValidator;
  private HashMap<String, Account> accounts;
  private ArrayList<Transaction> transactions;

  private void printAllTransactionsInteractive() {
    for (Transaction t : transactions) {
      System.out.println("Transaction:");
      System.out.print(t.toStringInteractive());
    }
  }

  private void printAccounts() {
    System.out.print("[");
    int i = 0;
    for (String key : this.accounts.keySet()) {
      System.out.print(this.accounts.get(key));
      if (i + 1 != this.accounts.size()) {
        System.out.print(",\n");
      }
      i += 1;
    }
    System.out.println("]");
  }

  private void printHelp() {
    System.out.println("Interactive mode started.");
    System.out.println("Commands:");
    System.out.println("quit Quits interactive mode.");
    System.out.println("help Prints this command list.");
    System.out.println("list Print all account and transaction entries.");
    System.out
        .println("add <IBAN no> <int value> Creates a new account with the given IBAN number and balance amount.");
    System.out.println("transact <IBAN no 1> <IBAN no 2> <int value> Creates a new transaction between 2 accounts.");
  }

  public void interactiveMode() {
    this.printHelp();

    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    String str;

    System.out.println("Enter the command:");
    try {
      do {
        str = obj.readLine();
        str = str.trim();
        String[] args = str.split(" ");

        if (args.length > 0) {
          if (args[0].equals("list")) {
            printAccounts();
            printAllTransactionsInteractive();
          }
          else if (args[0].equals("add")) {
            if (args.length == 3) {
              this.addAccount(new Account(args[1], Double.parseDouble(args[2])));
            }
          } else if (args[0].equals("transact")) {
            if (args.length == 4) {
              this.transact(args[1], args[2], Double.parseDouble(args[3]));
            }
          }
        }

      } while (!str.equals("quit"));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void printMatchingAccounts(String ibanPattern) {
    String regex = ibanPattern;

    Pattern pattern = Pattern.compile(regex);

    for (String key : this.accounts.keySet()) {
      Matcher matcher = pattern.matcher(key);
      if (matcher.find()) {
        System.out.println(key);

      }
    }
  }

  public void printAllTransactions() {
    for (Transaction t : transactions) {
      System.out.print(t);
    }
  }

  public void transact(String fromIBAN, String toIBAN, double amount) {
    Account fromAccount = null;
    Account toAccount = null;
    Transaction t = null;

    try {
      accountValidator.validateExistence(this.accounts, fromIBAN, this.name);
      fromAccount = this.accounts.get(fromIBAN);
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
    try {
      accountValidator.validateExistence(this.accounts, toIBAN, this.name);
      toAccount = this.accounts.get(toIBAN);
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
    try {
      transactionValidator.validateAmount(amount);
      t = new Transaction(fromAccount, toAccount, amount);
      if (fromAccount.getBalance() - amount > 0) {
        t.setSuccess(true);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
      } else {
        t.setSuccess(false);
      }
      this.transactions.add(t);
    } catch (Exception e) {
      t = new Transaction(fromAccount, toAccount, amount);
      t.setSuccess(false);
      this.transactions.add(t);
      System.out.println(e);
      return;
    }
  }

  public void addAccount(Account account) {
    try {
      accountValidator.validateAccountIBAN(account);
      this.accounts.put(account.getIBAN(), account);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Bank(String name) {
    this.name = name;
    this.accountValidator = new AccountValidator();
    this.transactionValidator = new TransactionValidator();
    this.accounts = new HashMap<String, Account>();
    this.transactions = new ArrayList<Transaction>();
  }
}
