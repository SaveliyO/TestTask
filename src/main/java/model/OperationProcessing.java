package model;

import controller.Transaction;

import java.util.ArrayList;


public class OperationProcessing {
    private int amountOfMoney;
    private int operationID;
    private final int amountOfOperations = 5;
    private ArrayList<String> history = new ArrayList<String>();

    public int topUpYourAccount(Transaction transaction){
        amountOfMoney += transaction.getAmount();
        history.add("Пополнение +" + transaction.getAmount() + ".");
        return transaction.getAmount();
    }

    public int withdrawMoney(Transaction transaction){
        amountOfMoney -= transaction.getAmount();
        history.add("Списание -" + transaction.getAmount() + ".");
        return transaction.getAmount();
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public int getAmountOfOperations() {
        return amountOfOperations;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
