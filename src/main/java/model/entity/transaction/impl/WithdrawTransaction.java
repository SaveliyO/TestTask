package model.entity.transaction.impl;

import model.entity.transaction.Transaction;

import java.time.LocalDateTime;

public class WithdrawTransaction extends AccountTransaction {

    public WithdrawTransaction(int amount) {
        this.transactionDate = LocalDateTime.now();
        this.amount = -amount;
    }

    @Override
    public void execute(int amount) {

    }

    @Override
    public void rollback() {

    }
}
