package com.techelevator.challenge;


import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public CheckingAccount(String accountHolder, String accountNumber, BigDecimal balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal balance = super.getBalance();
        if ((balance.subtract(amountToWithdraw)).compareTo(BigDecimal.valueOf(0)) < 0 && (balance.subtract(amountToWithdraw)).compareTo(BigDecimal.valueOf(-99)) >= 0) {
            amountToWithdraw = amountToWithdraw.add(BigDecimal.valueOf(10));
            super.withdraw(amountToWithdraw);
        } else if ((balance.subtract(amountToWithdraw)).compareTo(BigDecimal.valueOf(-100)) <= 0) {
            super.withdraw(BigDecimal.valueOf(0));
        } else if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            amountToWithdraw = amountToWithdraw.add(BigDecimal.valueOf(10));
            super.withdraw(amountToWithdraw);
        } else {
            super.withdraw(amountToWithdraw);
        }
        return balance;
    }
}
