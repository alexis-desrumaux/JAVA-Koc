package account;

import java.util.Map;

import account.*;
import exception.*;

public class AccountValidator {

  public void validateExistence(Map<String, Account> accounts, String IBAN, String bankName) throws NoSuchAccountException {
    if (accounts.containsKey(IBAN) == false) {
      throw new NoSuchAccountException("Transaction aborted because account with IBAN " + IBAN + " does not exist on " + bankName + " bank");
    }
  }

  public void validateAccountIBAN(Account account) throws InvalidAccountException {
    if (!account.getIBAN().startsWith("TR")) {
      throw new InvalidAccountException("Account is invalid because account address must start with TR");
    }
    if (account.getIBAN().length() != 26) {
      throw new InvalidAccountException("Account is invalid because length of the IBAN address should be 26");
    }
  }

	public AccountValidator() {

  }
}
