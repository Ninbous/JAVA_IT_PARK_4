package com.company;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(3);
        Sphere sphere = new Sphere(3);


        System.out.println("Площаль круга - " + circle.Space());
        System.out.println("  ");
        System.out.println("Площаль сферы - " + sphere.Space());
    }
}
