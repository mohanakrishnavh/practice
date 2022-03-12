package designpatterns.composite;

public class Client {
    public static void main(String[] args) {
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositAccount("DA001", 100.00f));
        component.addAccount(new DepositAccount("DA002", 150.00f));
        component.addAccount(new SavingAccount("SA001", 2000.00f));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }
}
