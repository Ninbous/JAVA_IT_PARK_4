package ru.itpark;

public class Main {

    public static void main(String[] args) throws Exception {
//      System.out.println(Thread.currentThread());
//      System.out.println("Привет, я немного торможу");
//      Thread.sleep(10000);
//      System.out.println("Все, отпустило.");


        MyThread thread = new MyThread();
        SecondThread Secondthread = new SecondThread();
        thread.start();
        Secondthread.start();
        thread.join();
        Secondthread.join();

        for (int i = 0; i < 100; i++) {
            System.out.println("Челвоек");
        }

    }
}
