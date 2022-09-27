package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public SavingsAccount(String accountHolder,String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int balance = getBalance();
        if (balance - amountToWithdraw - 2 < 0) {
            super.withdraw(0);
        } else if (balance - amountToWithdraw < 150) {
            amountToWithdraw += 2;
            super.withdraw(amountToWithdraw);
        } else {
            super.withdraw(amountToWithdraw);
        }
        return balance;
    }
}
