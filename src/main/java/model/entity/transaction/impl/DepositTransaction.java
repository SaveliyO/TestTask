package model.entity.transaction.impl;

import model.entity.transaction.Transaction;

import java.time.LocalDateTime;

public class DepositTransaction extends AccountTransaction {

    public DepositTransaction(int amount) {
        this.transactionDate = LocalDateTime.now();
        this.amount = amount;
    }

    @Override
    public void execute(int amount) {

    }

    @Override
    public void rollback() {

    }
}
