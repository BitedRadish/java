package lab.bank.control;

import lab.bank.entity.*;
import lab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            System.out.println("=== 계좌 생성 ===");
            System.out.println(bank.createSavingsAccount("홍길동", 10000, 0.03));
            System.out.println(bank.createCheckingAccount("김철수", 20000, 5000));
            System.out.println(bank.createSavingsAccount("이영희", 30000, 0.02));

            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();

            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit("A100", 5000);
            bank.withdraw("A100", 3000);

            System.out.println("\n=== 이자 적용 테스트 ===");
            SavingsAccount savings = (SavingsAccount) bank.findAccount("A100");
            double interest = savings.getBalance() * savings.getInterestRate();
            savings.deposit(interest);
            System.out.println(interest + "원이 입금되었습니다.");
            System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + savings.getBalance() + "원");

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.withdraw("A100", 5000);
            bank.withdraw("A101", 5000);
            bank.transfer("A102", "A100", 5000);

            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();

            System.out.println("\n예외 발생: 출금 한도를 초과");
            bank.withdraw("A101", 6000);

        } catch (AccountNotFoundException | WithdrawLimitExceededException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            System.out.println("\n예외 발생: 출금 한도를 초과");
            bank.withdraw("A101", 6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            System.out.println("\n예외 발생: 계좌를 찾을 수 없음");
            bank.withdraw("A9999", 1000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
