## IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and intern id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Intern id>
********************************************************************************/
```
<hr>

## IMPORTANT NOTE 2: After you complete the PRELAB tasks, do not forget to commit your changes and push them to your repository on Github.

<hr>

## IMPORTANT NOTE 3: This README.md file only contains the instructions for the PRELAB. You will also have INLAB questions.

<hr>

# Lab-7 Prelab: Simulation of a Banking System

In this programming lab, you will be mainly practicing **Exception Handling** concepts by implementing an application that simulates a banking system. The banking system only involves sending and receiving money from one **Account** to another. Each sending/receiving operation is called a **"Transaction"**.

You are provided with a Java project template and you should do your development on this template. In the given Java project, a main program code Main.java is provided to test your code. Note that we may test your codes with other test cases as well. You are free to add **extra** helper methods (such as getters, setters and toString) or variables if you think they are needed. You should also decide on the visibility of the variables (public, protected, private) yourself.

Here is the folder structure that you will have when you finish implementing the assignment:

```
src/
    account/
        Account.java
        AccountValidator.java
    transaction/
        Transaction.java
        TransactionValidator.java
    exception/
        InvalidAccountException.java
        NoSuchAccountException.java
        InvalidTransactionException.java
    main/
        Main.java
        Bank.java
```

## Account Class

Has the following:

* A field **IBAN** of type **String**.
* A field **balance** of type **double**.
* A constructor with the signature **Account(String IBAN, double balance)** where you set your fields with the parameters of the constructor.

## AccountValidator Class

Has the following:

* Has a method called **validateAccountIBAN** which takes an **Account** as a parameter and validates two things:
  - If first two characters of the IBAN of the account is different than TR, it throws **InvalidAccountException** (you can use String.startsWith method to achieve this).
  - If the length of the IBAN is different than 26, it throws **InvalidAccountException**.

* Has a method called **validateExistence(Map<String, Account> accounts, String IBAN, String bankName)**.
  - If **accounts** map does not contain an account with given IBAN, it throws **NoSuchAccountException**. 

## Transaction Class

Has the following:

* A field **from** of type **Account**.
* A field **to** of type **Account**.
* A field **amount** of type **double**.
* A field **success** of type **boolean**.
* A constructor with the signature **Transaction(Account from, Account to, double amount)** where you set your fields with the parameters of the constructor.

## TransactionValidator Class

Has the following:

* Has a method called **validateAmount** which takes an **amount** as a parameter.
  - If the amount is smaller than 0, it throws **InvalidTransactionException**.

## Bank Class

* A field **name** of type **String**.
* A field **accountValidator** of type **AccountValidator**.
* A field **transactionValidator** of type **TransactionValidator**.
* A field **accounts**  of type **HashMap<String, Account>**. The keys of the map are the IBANs of the accounts. The values of the map are the Account objects. 
* A field **transactions** of type **ArrayList<Transaction>**. 
* A constructor with the signature **public Bank(String name)** where you set your fields with the parameters of the constructor and initialize the fields that you need to initialize.

* Has a method called **addAccount** which takes an **Account** as a parameter.
  - **accountValidator** validates the IBAN of the account.
  - If the IBAN is valid, it should add account to the **accounts** hash map.
  - If the IBAN is invalid, it should catch the **Exception**, print the error message and return.

* Has a method called **transact(String fromIBAN, String toIBAN, double amount)**. 
  - **accountValidator** validates the existence of the account with **fromIBAN**.
  - If **fromIBAN** is valid, it should get the account with **fromIBAN** from the accounts hash map.
  - If **fromIBAN** is not valid, it should catch the **Exception**, print the error message and return.
  - **accountValidator** validates the existence of the account with **toIBAN**.
  - If **toIBAN** is valid, it should get the account with **toIBAN** from the accounts hash map.
  - If **toIBAN** is not valid, it should catch the **Exception**, print the error message and return.
  - At this point, we are sure that both accounts are valid. Now, we can create a **Transaction**. 
  - After the **Transaction** is created, **transactionValidator** validates the amount. If the amount is valid, it sets the **success** of the **Transaction** to true, and updates the balances of both accounts.
  - If the amount is invalid, it should catch the **Exception**, set the **success** of the **Transaction** to false, print the error message and return.
  - And finally, it adds the transaction to the **transactions** list (doesn't matter if the transaction is successful or not). You have to use **finally** keyword to achieve this.

* Has a method called **printAllTransactions** which prints the information of all transactions.

* Has a method called **printMatchingAccounts** which takes a **String ibanPattern** and prints IBAN of all accounts that matches the pattern. In this method you have to use a regular expression (i.e. regex) to find the matches. For example, if the pattern is "800", it should print IBAN of all accounts that contains 800 in it. You should use **Pattern** and **Matcher** class methods to find the matches. You can get the indexes of the matches with **matcher.start()** and **matcher.end()**.

## InvalidAccountException Class

* This is a custom exception class. It basically takes an error message and prints "Account is invalid because " + error message which states why this exception was thrown. For example, if the length of the IBAN address of an account is different than 26, it should print "Account is invalid because length of the IBAN address should be 26". Another example is that if the IBAN doesn't start with "TR", it should print "Account is invalid because account address must start with TR".

## InvalidTransactionException Class

* This is another custom exception class. It basically takes an error message and prints "Transaction is invalid because " + error message which states why this exception was thrown. For example, if the amount of the transaction is smaller than 0, it should print "Transaction is invalid because amount should be greater than 0".

## NoSuchAccountException Class

* This is another custom exception class. It basically takes an error message and prints "Transaction aborted because " + error message which states why this exception was thrown. For example, an account with IBAN {IBAN address of the account} is given as one of the accounts and this account does not exist in the specified bank, it should print "Transaction aborted because account with IBAN {IBAN of the given account} does not exist on {Bank Name} bank".

Example output:

```
exception.InvalidAccountException: Account is invalid because length of the contract address should be 26
exception.InvalidAccountException: Account is invalid because account address must start with TR
exception.NoSuchAccountException: Transaction aborted because account with IBAN TR29000150015800730387123 does not exist on Yapi Kredi bank
exception.InvalidTransactionException: Transaction is invalid because Amount should be greater than 0

---------------------All Transactions---------------------
Transaction:
 from=Account [IBAN=TR290001100151007303871234, balance=45.0]
 to=Account [IBAN=TR290001800158007303875678, balance=55.0]
 amount=5.0
 success=true
Transaction:
 from=Account [IBAN=TR290001100151007303871234, balance=45.0]
 to=Account [IBAN=TR290001800158007303875678, balance=55.0]
 amount=-20.0
 success=false

---------------------Pattern Matches---------------------
Found pattern 800 in account with IBAN: TR298001200151007380022222 between index 4 and index 7
Found pattern 800 in account with IBAN: TR298001200151007380022222 between index 18 and index 21
Found pattern 800 in account with IBAN: TR290001800158007303875678 between index 8 and index 11
Found pattern 800 in account with IBAN: TR290001800158007303875678 between index 13 and index 16
Found pattern 800 in account with IBAN: TR290001300153007303880011 between index 21 and index 24
```
