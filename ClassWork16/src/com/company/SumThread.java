package com.company;

public class SumThread extends Thread {
    private int start;
    private int end;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            synchronized (Main.array) {
                Main.result = Main.result + Main.array[i];
            }
        }
    }
}
