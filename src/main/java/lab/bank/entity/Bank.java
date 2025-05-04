package lab.bank.entity;

import lab.bank.exception.AccountNotFoundException;
import lab.bank.exception.InsufficientBalanceException;
import lab.bank.exception.WithdrawLimitExceededException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 100;
    }


    //  업 캐스팅은 자동처리된다.
    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        SavingsAccount newAccount = new SavingsAccount("A" + nextAccountNumber, ownerName, initialBalance, interestRate);
        accounts.add(newAccount);  // 업캐스팅은 자동

        return "저축 계좌가 생성되었습니다. 계좌 번호 : " + newAccount.getAccountNumber() +
                ", 소유자 : " + newAccount.getOwnerName() +
                ", 잔액 : " + newAccount.getBalance() +
                ", 이자율 : " + newAccount.getInterestRate();
    }

    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawaLimit) {
        // 당좌 계좌 생성
        CheckingAccount newAccount = new CheckingAccount("A" + nextAccountNumber, ownerName, initialBalance, withdrawaLimit);
        accounts.add(newAccount);  // 업캐스팅은 자동

        return "체킹 계좌가 생성되었습니다. 계좌 번호 : " + newAccount.getAccountNumber() +
                ", 소유자 : " + newAccount.getOwnerName() +
                ", 잔액 : " + newAccount.getBalance() +
                ", 출금 한도 : " + newAccount.getWithdrawLimit();

    }

    public Account findAccount(String accountNumber) {
        // 계좌 찾기
        return accounts.stream().filter(Account -> Account.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        // 입금
        Account account = findAccount(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException(accountNumber + " 계좌를 찾을 수 없습니다.");
        }

        account.deposit(amount);
        System.out.println(amount+"원이 입금되었습니다. 현재 잔액 :"+account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, WithdrawLimitExceededException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException(accountNumber + " 계좌를 찾을 수 없습니다.");
        }


        if(account instanceof CheckingAccount){
            double withdrawLimit=((CheckingAccount) account).getWithdrawLimit();
            if (amount > withdrawLimit) {
                throw new WithdrawLimitExceededException("출금 한도를 초과했습니다.");
            }
            if (amount > account.getBalance()) {
                throw new InsufficientBalanceException("잔액 부족");
            }
        }
        account.withdraw(amount);
        // 출금
        System.out.println(amount+"원이 출금되었습니다. 현재 잔액 :"+account.getBalance());
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException, WithdrawLimitExceededException, AccountNotFoundException {
        withdraw(fromAccountNumber,amount);
        deposit(toAccountNumber,amount);

        System.out.println(amount+"원이 "+fromAccountNumber+"에서 "+toAccountNumber+"로 송금되었습니다.");

    }

    public void printAllAccounts() {
        // 모든 계좌 정보 출력
        accounts.forEach(account-> System.out.println(account.toString()));
    }
}
