package it.unibo.pps.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    public static final int INITIAL_BALANCE = 0;
    public static final int MINIMUM_DEPOSIT = 0;

    public SimpleBankAccount(final AccountHolder holder) {
        this.holder = holder;
        this.balance = INITIAL_BALANCE;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (holder.checkUser(userID)) {
            this.balance += Math.max(MINIMUM_DEPOSIT, amount);
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (holder.checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

}
