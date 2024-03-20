package model.service;

import model.entity.Account;
import model.entity.transaction.Transaction;
import model.entity.transaction.impl.AccountTransaction;
import model.entity.transaction.impl.DepositTransaction;
import model.entity.transaction.impl.WithdrawTransaction;
import model.repository.AccountRepository;

import java.util.List;
import java.util.UUID;

//TODO: убрать аккаунт репозитори (закоментировать) в методы передавать сам обьект аккаунт, а его сделать полем в контроллере и передать его из мейна в котроллер

public class AccountService {
    //private final AccountRepository accountRepository;
    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public Account deposit(AccountTransaction transaction) {
        if (transaction instanceof WithdrawTransaction) {
            account.changeBalance(transaction.getAmount());
        } else {
            account.changeBalance(transaction.getAmount());
        }
        return account;
    }

    public int getBalance() {
        return  account.getBalance();
    }

    public void addTransactionHistory(AccountTransaction accountTransaction) {
        account.addTransactionHistory(accountTransaction);
    }

    public List<AccountTransaction> getTransactionHistory() {
        return account.getTransactionHistory();
    }

    private UUID getByID(Account id) {
        return id.getId();
    }

}
