package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       // Scanner in = new Scanner(System.in);

        char number[] = {'1', '4', '5', '6'};
        int x = Programm.parse(number);
        System.out.println(x);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Введите символ: ");
            char c = scanner.next().charAt(0);
            System.out.println(Programm.isLetter(c));
            System.out.println(Programm.isDigit(c));
            System.out.println(Programm.isUpper(c));
            System.out.println(Programm.isLower(c));
        }
    }
}
