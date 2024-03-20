package controller;

import model.entity.Account;
import model.entity.transaction.Transaction;
import model.entity.transaction.impl.DepositTransaction;
import model.entity.transaction.impl.WithdrawTransaction;
import model.service.AccountService;
import view.AccountView;

/**
 * Класс очка
 */
public class AccountController {
    private static final int AMOUNT_OF_OPERATIONS = 5;
    private static final int WITH_DRAW_OPERATION_ID = 2;
    private static final int ERROR_OPERATION_ID = 0;

    private final AccountView accountView;
    private final AccountService accountService;

    private int currentOperationID;

    public AccountController(AccountView view, AccountService accountService) {
        this.accountService = accountService;
        this.accountView = view;
    }

    public void startApp(AccountService accountService) {
        accountView.printMenu();
        run(accountService);
    }

    private void receiveOperationID() {
        String stringOperationID = accountView.receiveOperationID();
        if (isInteger(stringOperationID)) {
            int intOperationID = Integer.parseInt(stringOperationID);
            if ((ERROR_OPERATION_ID < intOperationID) && (intOperationID <= AMOUNT_OF_OPERATIONS)) {
                currentOperationID = intOperationID;
            } else {
                currentOperationID = ERROR_OPERATION_ID;
            }
        }
    }

    private void run(AccountService accountService) {
        boolean exitFlag = false;
        java.time.LocalDate currentDate = java.time.LocalDate.now();
        while (!exitFlag) {
            receiveOperationID();
            switch (currentOperationID) {
                case (0):
                    accountView.error(currentOperationID);
                    break;
                case (1):
                    String topUpTransactionString = accountView.topUpYourAccountRead();
                    if (isValidTransaction(topUpTransactionString, currentOperationID, accountService)) {
                        int topUpTransactionInt = Integer.parseInt(topUpTransactionString);
                        DepositTransaction depositTransaction = new DepositTransaction(topUpTransactionInt);
                        accountService.deposit(depositTransaction);
                        accountService.addTransactionHistory(depositTransaction);
                        accountView.topUpYourAccountWrite(depositTransaction.getAmount());
                    } else {
                        accountView.error(currentOperationID);
                    }
                    break;
                case (2):
                    String withdrawTransactionString = accountView.withdrawMoneyRead();
                    if (isValidTransaction(withdrawTransactionString, currentOperationID, accountService)) {
                        int withdrawTransactionInt = Integer.parseInt(withdrawTransactionString);
                        WithdrawTransaction withdrawTransaction = new WithdrawTransaction(withdrawTransactionInt);
                        accountService.deposit(withdrawTransaction);
                        accountService.addTransactionHistory(withdrawTransaction);
                        accountView.withdrawMoneyWrite(withdrawTransaction.getAmount(),accountService.getBalance());
                    } else {
                        accountView.error(currentOperationID);
                    }
                    break;
                case (3):
                    accountView.checkBalance(accountService.getBalance());
                    break;
                case (4):
                    accountView.transactionHistory(accountService.getTransactionHistory());
                    break;
                case (5):
                    accountView.exit();
                    exitFlag = true;
                    break;
                default:
                    accountView.error(currentOperationID);
            }
        }
    }

    public boolean isValidTransaction(String transactionAmount, int currentOperationID, AccountService accountService) {
        if (isInteger(transactionAmount)) {
            int transactionInt = Integer.parseInt(transactionAmount);
            if (currentOperationID == WITH_DRAW_OPERATION_ID) {
                if (transactionInt > accountService.getBalance()) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
