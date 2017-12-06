package ru.itpark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //создаем хардвер
        TV tv = TV.getInstance();
        Pult pult = new Pult(tv);
        pult.showAppearens();

        //создание сигнала на телек
        ArrayList<Programm> programms = new ArrayList<>();
        programms.add(0,new Programm("Клипы", LocalTime.parse("00:00"),LocalTime.parse("12:00")));
        programms.add(1,new Programm("Камеди", LocalTime.parse("12:00"),LocalTime.parse("20:00")));
        programms.add(2,new Programm("Дом 2", LocalTime.parse("20:00"),LocalTime.parse("23:59")));
        Channel tntChannel = new Channel("ТНТ", programms);
        tv.addChannel(tntChannel);

        programms = new ArrayList<>();
        programms.add(0,new Programm("Передача 1", LocalTime.parse("00:00"),LocalTime.parse("12:00")));
        programms.add(1,new Programm("Передача 2", LocalTime.parse("12:00"),LocalTime.parse("20:00")));
        programms.add(2,new Programm("Передача 3", LocalTime.parse("20:00"),LocalTime.parse("23:59")));
        Channel firstChannel = new Channel("Первый", programms);
        tv.addChannel(firstChannel);

        programms = new ArrayList<>();
        programms.add(0,new Programm("Передача 1", LocalTime.parse("00:00"),LocalTime.parse("12:00")));
        programms.add(1,new Programm("Передача 2", LocalTime.parse("12:00"),LocalTime.parse("20:00")));
        programms.add(2,new Programm("Передача 3", LocalTime.parse("20:00"),LocalTime.parse("23:59")));
        Channel secondChannel = new Channel("Второй", programms);
        tv.addChannel(secondChannel);

        //действия пользователя
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Нажать на кнопку: ");
            pult.pushButton(scanner.nextInt());
        }
    }
}
