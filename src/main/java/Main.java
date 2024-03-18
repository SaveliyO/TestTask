import controller.Controller;
import model.OperationProcessing;
import view.ConsoleWriter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleWriter(), new OperationProcessing());
        controller.greetings();
        Scanner scanner = new Scanner(System.in);
        controller.treatmentOperationID(scanner);
    }
}
