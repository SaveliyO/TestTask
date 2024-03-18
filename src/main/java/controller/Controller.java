package controller;

import java.util.Scanner;

public class Controller {

    private Scanner in = new Scanner(System.in);
    private int operationID;
    private int receiveAmount;

    public int receiveOperationID(){
        String str = in.nextLine();
        if(isInteger(str) && Integer.parseInt(str) < 6){
            operationID = Integer.parseInt(str);
        }else{
            System.out.println("Такой функции не сущесвует");
            operationID = 0;
        }
        return operationID;
    }
    public boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public int receiveAmount(int currentAmount){
        String str = in.nextLine();
        if(isInteger(str)){
            receiveAmount = Integer.parseInt(str);
        }else{
            System.out.println("Введено не верное число");
        }
        return receiveAmount;
    }
}
