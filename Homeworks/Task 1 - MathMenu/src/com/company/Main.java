package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("МЕНЮ:");
        System.out.println("1. Считать два числа");
        System.out.println("2. Сумма чисел вывод");
        System.out.println("3. Разность чисел вывод");
        System.out.println("4. Произведение вывод");
        System.out.println("5.  Выход");

        Scanner scanner = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;

        while (true) {
            System.out.println("Введите команду");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введите первое число");
                    num1 = scanner.nextInt();
                    System.out.println("Введите второе число");
                    num2 = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Сумма =" + (num1 + num2));
                    break;
                case 3:
                    System.out.println("Разность =" + (num1 - num2));
                    break;
                case 4:
                    System.out.println("Произведение =" + (num1 * num2));
                    break;
                case 5:
                    System.out.println("Выход");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Команда не верна");
            }
        }
    }
}