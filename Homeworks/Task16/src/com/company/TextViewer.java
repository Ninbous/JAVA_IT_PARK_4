package com.company;

public class TextViewer {

    private Runnable runnables[];
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void textProcess() {
		//...
        // как-то их запустить над text
    }

    public void addTask(Runnable task) {
		//...
        Runnable soutThread = new SoutThread();
        Thread threadStart = new Thread(soutThread);
        threadStart.start();
    }
}

