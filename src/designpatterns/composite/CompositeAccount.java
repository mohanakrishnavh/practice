package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accounts = new ArrayList<>();

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
