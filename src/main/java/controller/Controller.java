package controller;

import model.OperationProcessing;
import view.ConsoleWriter;

import java.util.Scanner;

public class Controller {

    private ConsoleWriter consoleWriter;
    private OperationProcessing operationProcessing;
    private int currentOperationID;
    private final int amountOfOperations = 5;
    private final int withDrawOperationID = 2;
    private final int errorOperationID = 0;

    public Controller(ConsoleWriter view, OperationProcessing model) {
        this.consoleWriter = view;
        this.operationProcessing = model;
    }

    public void greetings() {
        consoleWriter.greetings();
    }

    public void receiveOperationID(Scanner scanner) {
        String stringOperationID = consoleWriter.receiveOperationID(scanner);
        if (isInteger(stringOperationID)) {
            int intOperationID = Integer.parseInt(stringOperationID);
            if ((errorOperationID < intOperationID) && (intOperationID <= amountOfOperations)) {
                currentOperationID = intOperationID;
            } else {
                currentOperationID = errorOperationID;
            }
        }
    }

    public void treatmentOperationID(Scanner scanner) {
        boolean notExit = true;
        java.time.LocalDate currentDate = java.time.LocalDate.now();
        while (notExit) {
            receiveOperationID(scanner);
            switch (currentOperationID) {
                case (0):
                    consoleWriter.error(currentOperationID);
                    break;
                case (1):
                    Transaction topUpTransaction = new Transaction();
                    String topUpTransactionString = consoleWriter.topUpYourAccountRead(scanner);
                    if (isValidTransaction(topUpTransactionString, currentOperationID)) {
                        topUpTransaction.setAmount(Integer.parseInt(topUpTransactionString));
                        topUpTransaction.setDate(currentDate);
                        consoleWriter.topUpYourAccountWrite(operationProcessing.topUpYourAccount(topUpTransaction));
                    } else {
                        consoleWriter.error(currentOperationID);
                    }
                    break;
                case (2):
                    Transaction withdrawTransaction = new Transaction();
                    String withdrawTransactionString = consoleWriter.withdrawMoneyRead(scanner);
                    if (isValidTransaction(withdrawTransactionString, currentOperationID)) {
                        withdrawTransaction.setAmount(Integer.parseInt(withdrawTransactionString));
                        withdrawTransaction.setDate(currentDate);
                        consoleWriter.withdrawMoneyWrite(operationProcessing.withdrawMoney(withdrawTransaction),
                                                        operationProcessing.getAmountOfMoney());
                    } else {
                        consoleWriter.error(currentOperationID);
                    }
                    break;
                case (3):
                    consoleWriter.checkBalance(operationProcessing.getAmountOfMoney());
                    break;
                case (4):
                    consoleWriter.transactionHistory(operationProcessing.getHistory());
                    break;
                case (5):
                    consoleWriter.exit();
                    notExit = false;
                    break;
                default:
                    consoleWriter.error(currentOperationID);
            }
        }
    }

    public boolean isValidTransaction(String transactionAmount, int currentOperationID) {
        if (isInteger(transactionAmount)) {
            int transactionInt = Integer.parseInt(transactionAmount);
            if (currentOperationID == withDrawOperationID) {
                if (transactionInt > operationProcessing.getAmountOfMoney()) {
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
