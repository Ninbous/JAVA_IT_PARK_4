package com.company;

public class Sphere extends Circle{

    Sphere(double radius)
    {
        super(radius);
        setRadius(radius);
        System.out.println("Конструктор Сферы!");
    }
}
