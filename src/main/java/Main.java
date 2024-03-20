import controller.AccountController;
import model.entity.Account;
import model.service.AccountService;
import view.AccountView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountView accountView = new AccountView(scanner);
        Account account = new Account();
        AccountService accountService = new AccountService(account);
        AccountController controller = new AccountController(accountView, accountService);
        controller.startApp(accountService);
    }
}
