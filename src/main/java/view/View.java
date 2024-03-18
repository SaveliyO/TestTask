package view;
import controller.Controller;
import model.Model;

public class View {

    public void greetings(){
        System.out.println("Добро пожаловать в приложение \"Банковский счет\"!\n" +
                "1. Пополнить счет\n" +
                "2. Снять деньги\n" +
                "3. Проверить баланс\n" +
                "4. История транзакций\n" +
                "5. Выход\n");
        Model model = new Model();
        model.operationDefinition();
    }

}
