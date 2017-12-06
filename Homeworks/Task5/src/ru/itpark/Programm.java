package ru.itpark;

import java.time.LocalTime;

public class Programm {

    private String name;
	private LocalTime begin;
    private LocalTime end;

    public Programm(String name, LocalTime begin, LocalTime end){
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public boolean isNow() {
        LocalTime now = LocalTime.now();
        if (now.isAfter(begin) && now.isBefore(end)) {
            return true;
        }
        return false;
    }

    public String getVideo() {
        return name;
    }
}
