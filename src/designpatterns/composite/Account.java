package designpatterns.composite;

/**
 * Abstract base class for different types of accounts in the composite pattern.
 * Provides a method to get the balance of the account.
 */
abstract class Account {
    /**
     * Returns the balance of the account.
     * @return the account balance as a float
     */
    public abstract float getBalance();
}
