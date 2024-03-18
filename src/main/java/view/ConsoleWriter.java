package view;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleWriter {

    public void greetings(){
        System.out.println("Добро пожаловать в приложение \"Банковский счет\"!\n" +
                            "1. Пополнить счет\n" +
                            "2. Снять деньги\n" +
                            "3. Проверить баланс\n" +
                            "4. История транзакций\n" +
                            "5. Выход\n");
    }

    public void error(int operationID) {
        switch (operationID) {
            case (0):
                System.out.println("Такой операции не сущесвует");
                break;
            case (1):
                System.out.println("Возникла ошибка пополнения");
                break;
            case (2):
                System.out.println("Возникла ошибка снятия");
                break;
            default:
                System.out.println("Неизвестная ошибка");
        }
    }

    public String receiveOperationID(Scanner scanner){
        System.out.println( "Выберите действие (введите номер):");
        return scanner.nextLine();
    }

    public String topUpYourAccountRead(Scanner scanner){
        System.out.println("Введите сумму для пополнения: ");
        return scanner.nextLine();
    }

    public void topUpYourAccountWrite(int amount) {
        System.out.println("Баланс успешно пополнен на " + amount);
    }

    public String withdrawMoneyRead(Scanner scanner) {
        System.out.println("Введите сумму для снятия: ");
        return scanner.nextLine();
    }

    public void withdrawMoneyWrite(int amount, int balance) {
        System.out.println("Со счета снято " + amount + " руб.");
        System.out.println("Баланс: " + balance + ".");
    }

    public void checkBalance(int amount) {
        System.out.println("Баланс на счете: " + amount);
    }

    public void transactionHistory(ArrayList<String> history) {
        System.out.println("История транзакций: ");
        for (String str : history) {
            System.out.println(str);
        }
    }

    public void exit() {
        System.out.println("До свидания!");
    }
}
