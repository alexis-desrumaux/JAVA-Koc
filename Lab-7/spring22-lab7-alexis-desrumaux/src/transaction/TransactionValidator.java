package transaction;

import exception.InvalidTransactionException;

public class TransactionValidator {
	public void validateAmount(double amount) throws InvalidTransactionException {
    if (amount < 0) {
      throw new InvalidTransactionException("Transaction is invalid because Amount should be greater than 0");
    }
  }
}
