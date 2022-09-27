package com.techelevator.challenge;

import java.math.BigDecimal;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        balance = balance.subtract(amountToWithdraw);
        return balance;
    }

    //   public static void main(String[] args) {
    //     BankAccount james = new SavingsAccount("James", "123abc", BigDecimal.valueOf(300));
    //     james.deposit(BigDecimal.valueOf(400));
    //     System.out.println(james.getBalance());
    //     james.withdraw(BigDecimal.valueOf(699));
    //     System.out.println(james.getBalance());
    // }
}


