package designpatterns.composite;

public class SavingAccount extends Account {
  private final String accountNo;
  private final float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  @Override
  public float getBalance() {
    return accountBalance;
  }
}
