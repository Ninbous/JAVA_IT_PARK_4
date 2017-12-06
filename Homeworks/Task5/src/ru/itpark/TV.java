package ru.itpark;

import java.util.ArrayList;

public class TV {

    private static TV instance;

    ArrayList<Channel> channels = new ArrayList<>();
    private int countOfChannel = 0;
    private boolean turnOn = false;
    private int indOfCurrentChannel = 0;

    private TV() {

    }

    public static synchronized TV getInstance() {
        if (instance == null) {
            instance = new TV();
        }
        return instance;
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
        countOfChannel++;
    }

    public void turnOnOrOff() {
        if (turnOn) {
            System.out.println("ВЫКЛЮЧЕНИЕ!!!");
            turnOn = false;
        } else {
            turnOn = true;
            show();
        }
    }

    private void show() {
        if (turnOn) {
            System.out.println(channels.get(indOfCurrentChannel).getProgramm());
        }
    }

    public void swichTo(int indOfChannel) {
        if (indOfChannel < countOfChannel && channels.get(indOfChannel) == null) {
            System.out.println("Отсутствует канал!");
        } else if (turnOn) {
            indOfCurrentChannel = indOfChannel;
            show();
        }
    }
}
