package com.company;

public class Circle extends Figure{

    protected double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if ( radius > 0 ) {
            this.radius = radius;
        }
    }

    Circle(double radius)
    {
        setRadius(radius);
        System.out.println("Конструктор Цикрла!");
    }

    public double Space()
    {
        return Math.PI*Math.pow(radius,2);
    }
}
