package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean hasError = false;
        do {
            Scanner scanner = new Scanner(System.in);
            hasError = false;
            try {
                String input = scanner.nextLine();
                String result = Calculator.evaluate(input);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Ошибка");
                hasError = true;
            }
        } while (!hasError);
    }
}
