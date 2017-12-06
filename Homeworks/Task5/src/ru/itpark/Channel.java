package ru.itpark;

import java.util.ArrayList;

public class Channel {

    String name;
    ArrayList<Programm> programms;

    public Channel(String name, ArrayList<Programm> programms){
        this.programms = programms;
        this.name = name;
    }

    public String getProgramm(){
        for (Programm item: programms) {
            if(item.isNow()) {
                return "Канал - " + name + "\nПередача - " + item.getVideo();
            }
        }
        return "Нет передач";
    }
}
