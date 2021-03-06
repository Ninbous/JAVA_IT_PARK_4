package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner;

    static int[] storage;
    static int count;

    static void showArray() {
        System.out.println("В массиве " + count + " элемент(а/ов)");
        System.out.println("Длина массива " + storage.length);
        for (int i : storage) System.out.print(i + " ");
        System.out.println("");
    }

    static void addToForward() {
        System.out.println("Добавить в начало - введите число:");
        int num = scanner.nextInt();
        if (num != 0) {
            int[] temp = storage.clone();
            storage[0] = num;
            System.arraycopy(temp, 0, storage, 1, temp.length - 1);
            count++;
        } else {
            System.out.println("Ошибка - Число не должно быть равно 0!");
        }
    }

    static void addToBack() {
        System.out.println("Добавить в конец - введите число:");
        int num2 = scanner.nextInt();
        if (num2 != 0) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == 0) {
                    storage[i] = num2;
                    count++;
                    break;
                } else if (i == 99) {
                    System.out.println("Хранилище заполнено");
                }
            }
        } else {
            System.out.println("Ошибка - Число не должно быть равно 0!");
        }
    }

    static void deleteOnIndex() {
        System.out.println("Удаление по позиции - введите индекс в массиве");
        int index = scanner.nextInt();
        for (int j = 0; j < storage.length - index - 1; j++) {
            storage[index + j] = storage[index + j + 1];
        }
        storage[99] = 0;
        count--;
        if (count < 0) count = 0;
    }

    static void sortArray() {
        for(int j = 0; j<storage.length; j++) {
            int lowestValue = Integer.MAX_VALUE;
            int i = 0;
            int index = 0;
            for (; j+i < storage.length; i++) {
                if (storage[j+i] < lowestValue) {
                    lowestValue = storage[j+i];
                    index = j + i;
                }
            }
            int temp = storage[j];
            storage[j] = lowestValue;
            storage[index] = temp;
        }
    }

    public static void main(String[] args) {

        System.out.println("МЕНЮ:");
        System.out.println("1. Показать массив");
        System.out.println("2. Добавить в начало");
        System.out.println("3. Добавить в конец");
        System.out.println("4. Удалить по позиции");
        System.out.println("5. Сортировать массив");
        System.out.println("6. Выход");

        scanner = new Scanner(System.in);

        storage = new int[100];
        count = 0;

        while (true) {
            System.out.println("Введите команду");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    showArray();
                    break;
                case 2:
                    addToForward();
                    break;
                case 3:
                    addToBack();
                    break;
                case 4:
                    deleteOnIndex();
                    break;
                case 5:
                    sortArray();
                    break;
                case 6:
                    System.out.println("Выход");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Команда не верна");
            }
        }
    }
}
