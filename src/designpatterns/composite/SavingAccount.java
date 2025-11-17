package designpatterns.composite;

/**
 * Represents a saving account with a specific account number and balance.
 * This is a leaf component in the Composite pattern, representing
 * an individual account that cannot contain other accounts.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SavingAccount extends Account {
    private final String accountNo;
    private final float accountBalance;

    /**
     * Constructs a SavingAccount with the given account number and balance.
     *
     * @param accountNo      the unique account number identifier
     * @param accountBalance the initial balance of the saving account
     */
    public SavingAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    /**
     * Returns the balance of the saving account.
     *
     * @return the account balance as a float
     */
    @Override
    public float getBalance() {
        return accountBalance;
    }
}
