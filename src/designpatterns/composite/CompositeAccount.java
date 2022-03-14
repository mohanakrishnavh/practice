package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount extends Account {
  private final List<Account> accounts = new ArrayList<>();
  private float totalBalance;

  @Override
  public float getBalance() {
    totalBalance = 0;
    for (Account account : accounts) {
      totalBalance += account.getBalance();
    }

    return totalBalance;
  }

  public void addAccount(Account account) {
    accounts.add(account);
  }

  public void removeAccount(Account account) {
    accounts.remove(account);
  }
}
