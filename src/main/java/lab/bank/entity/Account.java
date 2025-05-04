package lab.bank.entity;

public class Account {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
    }

    public void withdraw(double amount){
        this.balance-=amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
