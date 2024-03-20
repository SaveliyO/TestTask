package model.entity;

import model.entity.transaction.impl.AccountTransaction;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final UUID id;
    private int balance = 0;
    private List<AccountTransaction> transactionHistory = new LinkedList<AccountTransaction>();

    public Account() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void changeBalance(int amount) {
        this.balance = balance + amount;
    }

    public int getBalance() {
        return balance;
    }

    public List<AccountTransaction> getTransactionHistory() {
        return transactionHistory;
    }
    public void addTransactionHistory(AccountTransaction accountTransaction) {
        this.transactionHistory.add(accountTransaction);
    }
}
