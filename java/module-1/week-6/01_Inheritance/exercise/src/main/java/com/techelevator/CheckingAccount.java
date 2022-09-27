package com.techelevator;

public class CheckingAccount extends BankAccount{
    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public CheckingAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int balance = super.getBalance();
        if (balance - amountToWithdraw < 0 && balance - amountToWithdraw >= -99) {
            amountToWithdraw += 10;
            super.withdraw(amountToWithdraw);
        } else if (balance - amountToWithdraw <= -100) {
            super.withdraw(0);
        } else if (balance < 0) {
            amountToWithdraw += 10;
            super.withdraw(amountToWithdraw);
        } else {
            super.withdraw(amountToWithdraw);
        }
        return balance;
    }
}
