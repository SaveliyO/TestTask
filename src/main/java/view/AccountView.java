package view;

import model.entity.transaction.impl.AccountTransaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AccountView {
    public static final String MENU = """
            1. Пополнить счет
            2. Снять деньги
            3. Проверить баланс
            4. История транзакций
            5. Выход
            """;
    private final Scanner scanner;

    public AccountView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu(){
        System.out.println(MENU);
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

    public String receiveOperationID(){
        System.out.println( "Выберите действие (введите номер):");
        return scanner.nextLine();
    }

    public String topUpYourAccountRead(){
        System.out.println("Введите сумму для пополнения: ");
        return scanner.nextLine();
    }

    public void topUpYourAccountWrite(int amount) {
        System.out.println("Баланс успешно пополнен на " + amount);
    }

    public String withdrawMoneyRead() {
        System.out.println("Введите сумму для снятия: ");
        return scanner.nextLine();
    }

    public void withdrawMoneyWrite(int amount, int balance) {
        System.out.println("Со счета снято " + -amount + " руб.");
        System.out.println("Баланс: " + balance + ".");
    }

    public void checkBalance(int amount) {
        System.out.println("Баланс на счете: " + amount);
    }

    public void transactionHistory(List<AccountTransaction> history) {
        System.out.println("История транзакций: ");
        for (AccountTransaction accountTransaction : history) {
            System.out.println(accountTransaction.getAmount());
            System.out.println(accountTransaction.getTransactionDate());
        }
    }

    public void exit() {
        System.out.println("До свидания!");
    }
}
