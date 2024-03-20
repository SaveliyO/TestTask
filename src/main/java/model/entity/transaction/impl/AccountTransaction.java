package model.entity.transaction.impl;

import model.entity.transaction.Transaction;

import java.time.LocalDateTime;

public abstract class AccountTransaction implements Transaction {

    protected int amount;
    protected LocalDateTime transactionDate;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public void execute(int amount) {

    }

    @Override
    public void rollback() {

    }
}
