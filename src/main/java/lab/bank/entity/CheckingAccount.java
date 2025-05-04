package lab.bank.entity;

public class CheckingAccount extends Account{
    private double withdrawLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawLimit = withdrawLimit;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

//    public void withdraw(double amount){
//
//    }
}
