package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();

        try{
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input){
        String parts[] = input.split(" ");
        if (parts.length != 3){
            throw new IllegalArgumentException("Неверный формат операции");
        }

        int a, b;
        try{
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неправильный формат чисел");
        }
        chechNumberInRange(a);
        chechNumberInRange(b);

        String operator = parts[1];
        int result;

        switch(operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                // обработки деления на 0 нет, так как числа от 1 до 10
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция");
        }
        return Integer.toString(result);
    }

    public static void chechNumberInRange(int number){
        if (number < 1 || number > 10){
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
    }
}