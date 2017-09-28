package ru.itpark;
import static java.lang.Math.*;
public class Main {

    public static double f(double x) {
        return cos(x);
    }

    public static double integrate(double a, double b, int n) {
        double result = 0;
        // рассчитать ширину разбиения
        double h = abs(a - b) / n;
        for (double x = a; x <= b; x = x + h) {
            result = result + f(x) * h;
        }
        return result;
    }

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }

    public static void main(String[] args) {
        double integrateOfSin =
                integrate(0.1, PI, 1000000);
        System.out.println(integrateOfSin);
    }
}