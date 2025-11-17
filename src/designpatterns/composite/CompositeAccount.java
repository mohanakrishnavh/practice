package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class that can contain multiple Account objects.
 * This class demonstrates the Composite pattern by allowing a collection
 * of accounts to be treated as a single account.
 * The composite can calculate the total balance of all contained accounts.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class CompositeAccount extends Account {
    private final List<Account> accounts = new ArrayList<>();
    private float totalBalance;

    /**
     * Calculates and returns the total balance of all contained accounts.
     * This method iterates through all child accounts and sums their balances.
     *
     * @return the total balance of all accounts in this composite
     */
    @Override
    public float getBalance() {
        totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    /**
     * Adds an account to this composite account.
     * The added account can be either a leaf account (DepositAccount, SavingAccount)
     * or another CompositeAccount, allowing for hierarchical structures.
     *
     * @param account the account to be added to this composite
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Removes an account from this composite account.
     * If the account doesn't exist in the collection, this operation has no effect.
     *
     * @param account the account to be removed from this composite
     */
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
