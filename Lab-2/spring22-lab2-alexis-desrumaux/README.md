# IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
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
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```

## IMPORTANT NOTE 2: After you comple the task, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

INLAB QUESTIONS WILL BE ANNOUNCED AT COURSE WEBSITE AT THE START OF EACH LAB: [https://sites.google.com/a/ku.edu.tr/comp132/programming-labs](https://sites.google.com/a/ku.edu.tr/comp132/programming-labs).

# Lab-2 Prelab Assignment

A crypto exchange platform, kuexchange, allows its traders to exchange various cryptocurrency pairs such as BTC/USDT, ETH/USDT. Each trader starts with an initial balance. The traders are only allowed to open long positions (this means that the trader buys the asset and expects its price to appreciate) on USDT pairs. A position can be closed with a profit or loss (if the closing price is higher than the entry price, there is a profit. Otherwise, there is a loss). You are asked to implement a Java program to keep track of the positions of each trader. The Java program (classes and their fields/methods) that you should design is described below. You should implement these classes according to the description given below:

## Note: 
We provide a template project for you, in which you can find the packages and classes. Also, in the main method, there is some hard-coded information that you should use for testing your solution. The sample output is given at the end of this description.


# Create the classes as follows:

## Class Position
1. 	It has 7 instance variables: 
  - **String ticker**: Ticker represents the short version of trading pair. For example, if the ticker is BTC/USDT, the trader buys BTC in exchange of USDT. ticker is not visible to any other class, should be initialized in the constructor when the object is created and should not be changeable after that.
  - **int id**: Each position needs to have an id. id is not visible to any other class, should be initialized in the constructor when the object is created and should not be changeable after that.
  - **boolean status**: Status represents the status of the position (open or closed). If the position is still open, it should be false. If the position is closed, it should be true.
  - **double entryPrice**: This represents the price of the asset at the time of opening the position. For example, if you trade 1 BTC for 40000 USDT, the entry price is 40000.
  - **double size**: This represents the size of the position in terms of the received asset. For example, if you trade 1 BTC for 40000 USDT, then the size is 1. 
  - **double closingPrice**: This is the price of the asset at the time of closing the position. 
  - **double netProfit**: This represents how much the trader won/lost from this particular trade. 
2. Write the constructor that has two parameters (ticker name and id).
3. Write a method called **open** that takes two parameters: entry price and size. This method sets instance variable entryPrice to method parameter entry price. It also sets instance variable size to method parameter size. Finally, it sets instance variable status to false.

```Java
public void open(double entryPrice, double size) {

}
```

4. Write a method called **close** that takes one parameter: closing price. This method sets instance variable closingPrice to method parameter closing price. It calculates the profit and sets instance variable netProfit to the result. You can calculate the profit as follows: 

```
netProfit: (Closing Price - Entry Price) * size
```

```Java
public void close(double closingPrice) {
    
}
```
5. Write a method called **isClosed**: This method returns false if the position is still open. Otherwise, it returns true.
```Java
public boolean isClosed() {
    
}
```
6. You can also write getters for the instance variables if needed. For example: 
```Java
public String getTicker() {
    
}
```

## Class Trader
1. This class includes the following instance variables:
```java
String name
double balance
double totalProfit
Position[] positions = new Position[10]; // This is a fixed size array. You can assume that number of positions will never exceed 10.
int numberOfPositions;
```
2.	Write a constructor with name and balance. Set the instance variables with the constructor parameters. Set numberOfPositions to 0. The name should not be changeable after it is set.
3.	Write a toString() method that returns a string that contains name of the trader, initial balance of the trader, current balance of the trader and balance growth in the following format: 

```Java
Name: {Name}	Initial balance: {Initial Balance in USDT}	Current balance: {Current Balance in USDT}	Balance growth: {Balance Growth in USDT}
```

4. Write the following methods:

A trader can open a position only if size * entryPrice < balance. If the trader does not have enough money, they shouldn't be able to open the position.
```java
public void openPosition(String ticker, int id, double size, double entryPrice)
{
    // TODO: Open a new position and add it to the positions array. 
}
```

If the position does not exist, you should print a statement saying that this position does not exist. If exists, you should close the position (calling the close method of Position) and calculate the net profit and update the balance of the trader
```java
public void closePosition(int id, double closingPrice)
{
    // TODO: close the position with id. 
}
```

```java
public int getNumberOfPositions()
{
    // TODO: return the size of the positions
}
```

```java
public double getTotalProfit()
{
    // TODO: return the total profit of the Trader
}
```

```java
public void printPositions()
{
    // TODO: print all positions
}
```

An example output for print positions (showing only 2 trades for simplicity):

```Java
(Position Closed)	Ticker: DOGE/USDT	id: 1	entry price: 0.65	closing price: 0.15	net profit: -50000.00 USDT
(Position Open)	Ticker: SHIB/USDT	id: 2	entry price: 0.00 USDT
```

Pay attention that entry and closing price prints only 2 decimals.

## Class Main
1. Write the following method:

```Java
private static double averageProfit(Trader[] traderArray, int numberOfTraders) {
    // TODO: return the average profit of all traders
}
```

## Sample output

The following is the expected output for the Main class that we provided to you:

```Java
Trader Hustler does not have enough balance to open this position
Trader Hustler has no position with this id
Trader Hustler opened a position with ticker: BTC/USDT	id: 1	entry price: 30000.00 USDT
Trader Hustler closed the position with ticker: BTC/USDT	id: 1	entry price: 30000.00 USDT
Trader Hustler opened a position with ticker: ETH/USDT	id: 2	entry price: 2000.00 USDT
Trader Hustler closed the position with ticker: ETH/USDT	id: 2	entry price: 2000.00 USDT
Trader Hustler opened a position with ticker: ETH/USDT	id: 3	entry price: 2300.00 USDT
Trader Hustler closed the position with ticker: ETH/USDT	id: 3	entry price: 2300.00 USDT
Trader Hustler opened a position with ticker: BTC/USDT	id: 4	entry price: 2000.00 USDT
Trader Hustler closed the position with ticker: BTC/USDT	id: 4	entry price: 2000.00 USDT
Trader Trust Fund Baby opened a position with ticker: DOGE/USDT	id: 1	entry price: 0.65 USDT
Trader Trust Fund Baby closed the position with ticker: DOGE/USDT	id: 1	entry price: 0.65 USDT
Trader Trust Fund Baby opened a position with ticker: SHIB/USDT	id: 2	entry price: 0.00 USDT
Trader Rocket Dude opened a position with ticker: NWC/USDT	id: 1	entry price: 0.02 USDT
Trader Rocket Dude closed the position with ticker: NWC/USDT	id: 1	entry price: 0.02 USDT
Trader Rocket Dude opened a position with ticker: FLM/USDT	id: 2	entry price: 0.21 USDT
Trader Rocket Dude closed the position with ticker: FLM/USDT	id: 2	entry price: 0.21 USDT
-------------------------------------------------------------------------------------
Name: Hustler	Initial balance: 50000.0 USDT	Current balance: 51278.0 USDT	Balance growth: 1278.0 USDT

(Position Closed)	Ticker: BTC/USDT	id: 1	entry price: 30000.00	closing price: 33000.00	net profit: 30.00 USDT
(Position Closed)	Ticker: ETH/USDT	id: 2	entry price: 2000.00	closing price: 2400.00	net profit: 800.00 USDT
(Position Closed)	Ticker: ETH/USDT	id: 3	entry price: 2300.00	closing price: 2700.00	net profit: 400.00 USDT
(Position Closed)	Ticker: BTC/USDT	id: 4	entry price: 2000.00	closing price: 4400.00	net profit: 48.00 USDT
Number of positions: 4
-------------------------------------------------------------------------------------
Name: Trust Fund Baby	Initial balance: 250000.0 USDT	Current balance: 200000.0 USDT	Balance growth: -50000.0 USDT

(Position Closed)	Ticker: DOGE/USDT	id: 1	entry price: 0.65	closing price: 0.15	net profit: -50000.00 USDT
(Position Open)	Ticker: SHIB/USDT	id: 2	entry price: 0.00 USDT
Number of positions: 2
-------------------------------------------------------------------------------------
Name: Rocket Dude	Initial balance: 100000.0 USDT	Current balance: 1132000.0 USDT	Balance growth: 1032000.0 USDT

(Position Closed)	Ticker: NWC/USDT	id: 1	entry price: 0.02	closing price: 1.00	net profit: 980000.00 USDT
(Position Closed)	Ticker: FLM/USDT	id: 2	entry price: 0.21	closing price: 0.73	net profit: 52000.00 USDT
Number of positions: 2

Average Profit of All Traders: 327759.333333
```
