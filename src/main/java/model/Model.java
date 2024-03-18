package model;

import controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Controller controller = new Controller();
    private int amountOfMoney;
    private int operationID;
    private ArrayList<String> history = new ArrayList<String>();

    public void operationDefinition(){
        Controller controller = new Controller();
        boolean a = true;
        int result;
        while (a){
            System.out.println( "Выберите действие (введите номер):");
            operationID = controller.receiveOperationID();
            switch (operationID) {
                case (0):
                    wrongNumber();
                    break;
                case (1):
                    topUpYourAccount();
                    break;
                case (2):
                    withdrawMoney();
                    break;
                case (3):
                    checkBalance();
                    break;
                case (4):
                    transactionHistory();
                    break;
                case (5):
                    a = exit();
                    break;
            }
        }
    }
    public void wrongNumber(){
        System.out.println("Не балуйся");
    }
    public void topUpYourAccount(){
        System.out.println("Введите сумму для пополнения:");
        int entrance = controller.receiveAmount(amountOfMoney);
        amountOfMoney += entrance;
        history.add("Пополнение +" + entrance + ".");
        System.out.println("Баланс успешно пополнен на " + entrance);
    }
    public void withdrawMoney(){
        System.out.println("Введите сумму для снятия: ");
        int withdraw = controller.receiveAmount(amountOfMoney);
        if (withdraw < amountOfMoney){
            amountOfMoney -= withdraw;
            System.out.println("Со счета снято " + withdraw + " руб.");
            System.out.println("Баланс: " + withdraw + ".");
            history.add("Списание -" + withdraw + ".");
        }else {
            System.out.println("Списание невозможно");
        }

    }
    public void checkBalance(){
        System.out.println("Баланс:" + amountOfMoney);
    }
    public void transactionHistory(){
        System.out.println("История транзакций");
        for(String str : history){
            System.out.println(str);
        }
    }
    public boolean exit(){
        System.out.println("До свидания");
        return false;
    }
}
