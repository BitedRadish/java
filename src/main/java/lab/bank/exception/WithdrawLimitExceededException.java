package lab.bank.exception;

public class WithdrawLimitExceededException extends Exception{
    public WithdrawLimitExceededException(String message) {
        super(message);
    }
}
