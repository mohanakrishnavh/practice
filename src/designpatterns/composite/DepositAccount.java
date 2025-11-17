package designpatterns.composite;

/**
 * Represents a deposit account with a specific account number and balance.
 */
public class DepositAccount extends Account {
    private final String accountNo;
    private final float accountBalance;

    /**
     * Constructs a DepositAccount with the given account number and balance.
     * @param accountNo the account number
     * @param accountBalance the account balance
     */
    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    /**
     * Returns the balance of the deposit account.
     * @return the account balance as a float
     */
    @Override
    public float getBalance() {
        return accountBalance;
    }
}
