package main;

import account.Account;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank("Yapi Kredi");
		
		Account account1 = new Account("TR290001100151007303871234", 50);
		Account account2 = new Account("TR290001800158007303875678", 50);
		Account account3 = new Account("TR29000100", 50);
		Account account4 = new Account("290001500", 50);
		Account account5 = new Account("TR290001300153007303880011", 50);
		Account account6 = new Account("TR298001200151007380022222", 50);
		Account account7 = new Account("TR290001100153007303833333", 50);
		Account account8 = new Account("TR290001200153007303844444", 50);
		
		bank.addAccount(account1);
		bank.addAccount(account2);
		bank.addAccount(account3);
		bank.addAccount(account4);
		bank.addAccount(account5);
		bank.addAccount(account6);
		bank.addAccount(account7);
		bank.addAccount(account8);
		
		bank.transact("TR29000150015800730387123", "TR290001500158007303875672", 5);
		bank.transact("TR290001100151007303871234", "TR290001800158007303875678", 5);
		bank.transact("TR290001100151007303871234", "TR290001800158007303875678", -20);
		bank.transact("TR290001100151007303871234", "TR290001800158007303875678", 55);


		System.out.println("\n---------------------All Transactions---------------------");
		bank.printAllTransactions();
		
		System.out.println("\n---------------------Pattern Matches---------------------");
		bank.printMatchingAccounts("800");
	}
	
}
