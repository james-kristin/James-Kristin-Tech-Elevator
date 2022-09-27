package com.techelevator.challenge;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public SavingsAccount(String accountHolder,String accountNumber, BigDecimal balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal balance = getBalance();
        if (((balance.subtract(amountToWithdraw)).subtract(BigDecimal.valueOf(2))).compareTo(BigDecimal.valueOf(0)) < 0) {
            super.withdraw(BigDecimal.valueOf(0));
        } else if ((balance.subtract(amountToWithdraw)).compareTo(BigDecimal.valueOf(150)) < 0) {
            amountToWithdraw = amountToWithdraw.add(BigDecimal.valueOf(2));
            super.withdraw(amountToWithdraw);
        } else {
            super.withdraw(amountToWithdraw);
        }
        return balance;
    }
}
