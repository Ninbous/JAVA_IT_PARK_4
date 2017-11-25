package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(2);

        Runnable sayHello = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "Hello");
            }
        };

        Runnable sayBye = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "Bye");
            }
        };

        Runnable sayMarsel = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "Marsel");
            }
        };

    }
}