/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Alexis Desrumaux, 0078296
********************************************************************************/

package main;

import kuexchange.Trader;
import java.security.SecureRandom;

public class Main {

	public static void main(String[] args) {
		// Create traders
		Trader trader1 = new Trader("Hustler", 50000);
		Trader trader2 = new Trader("Trust Fund Baby", 250000);
		Trader trader3 = new Trader("Rocket Dude", 100000);

		///////////////////////////////////////////////////////////////////////////////
		// Positions of Trader 1
		// Trader 1 does not have enough money to open this position
		trader1.openPosition("LINK/USDT", 0, 10000, 10);
		
		// Trader 1 is trying to close a position that does not exist.
		trader1.closePosition(0, 12);
		
		trader1.openPosition("BTC/USDT", 1, 0.01, 30000);
		trader1.closePosition(1, 33000);

		trader1.openPosition("ETH/USDT", 2, 2, 2000);
		trader1.closePosition(2, 2400);

		trader1.openPosition("ETH/USDT", 3, 1, 2300);
		trader1.closePosition(3, 2700);

		trader1.openPosition("BTC/USDT", 4, 0.02, 2000);
		trader1.closePosition(4, 4400);
		////////////////////////////////////////////////////////////////////////////////
		// Positions of Trader 2
		trader2.openPosition("DOGE/USDT", 1, 100000, 0.65);
		trader2.closePosition(1, 0.15);

		trader2.openPosition("SHIB/USDT", 2, 100000, 0.00007);

		// Positions of Trader 3
		trader3.openPosition("NWC/USDT", 1, 1000000, 0.02);
		trader3.closePosition(1, 1);

		trader3.openPosition("FLM/USDT", 2, 100000, 0.21);
		trader3.closePosition(2, 0.73);

		// Print trading history of traders
		printTradingHistory(trader1);
		printTradingHistory(trader2);
		printTradingHistory(trader3);
		
		Trader[] traders = new Trader[3];
		traders[0] = trader1;
		traders[1] = trader2;
		traders[2] = trader3;
		
		// Calculate average profit
		System.out.printf("\n\nAverage Profit of All Traders: %f\n", averageProfit(traders, 3));

		// Putting more Traders into an array
		/*Trader[] cryptoBros = new Trader[5];
		cryptoBros[3] = new Trader("NFT Enthusiast", 150000);
		cryptoBros[4] = new Trader("A Sceptic Investor", 300000);
		int cryptoBrosSize=5;
		// Removing traders from array
		cryptoBrosSize = removeTrader(cryptoBros,cryptoBrosSize,0);
		cryptoBrosSize = removeRandomTrader(cryptoBros,cryptoBrosSize);

		System.out.println("-------------------------------------------------------------------------------------");
		// Printing traders' info inside of array (after removal)
		for (int i = 0; i < cryptoBrosSize; i++) {
			Trader trader = cryptoBros[i];
			if(trader != null) {
				printTradingHistory(trader);
			}
		}*/
	}

	private static void printTradingHistory(Trader trader) {
		System.out.println("-------------------------------------------------------------------------------------");
 		System.out.println(trader);

 		trader.printPositions();
 		System.out.printf("Number of positions: %d\n", trader.getNumberOfPositions());




		/*double initialBalance = trader.getBalance() - trader.getTotalProfit();
		double currentBalance = trader.getBalance();

		System.out.printf(
				"Name: %s\tInitial balance: %.2f USDT\tCurrent balance: %.2f USDT\tBalance growth: %.2f USDT\n\n",
				trader.getName(), initialBalance, currentBalance, trader.getTotalProfit());

		trader.printPositions();*/
	}
	
	private static double averageProfit(Trader[] traderArray, int numberOfTraders) {
		double totalTraderProfit = 0;

		for (int i = 0; i != traderArray.length; i += 1) {
			totalTraderProfit += traderArray[i].getTotalProfit();
		}
		return totalTraderProfit / numberOfTraders;
	}

	public int removeTrader(Trader[] traders, int numberOfTraders, int index) {
		if (index < 0 || index >= numberOfTraders) {
			return numberOfTraders;
		}

		for (int i = index; i != numberOfTraders; i += 1) {
			if (i + 1 != numberOfTraders) {
				traders[i] = traders[i + 1];
			} else {
				traders[i] = null;
			}
		}
		return numberOfTraders - 1;
	}

	public int removeRandomTrader(Trader[] traders, int numberOfTraders) {
		SecureRandom rand = new SecureRandom();

		int index = rand.nextInt(numberOfTraders - 1);
		return removeTrader(traders, numberOfTraders, index);
	}
}
