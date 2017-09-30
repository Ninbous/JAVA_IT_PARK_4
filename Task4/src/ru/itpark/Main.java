package ru.itpark;

public class Main {

    static void sortArray(int horsePowers[]) {
        for(int j = 0; j<horsePowers.length; j++) {
            int lowestValue = Integer.MAX_VALUE;
            int i = 0;
            int index = 0;
            for (; j+i < horsePowers.length; i++) {
                if (horsePowers[j+i] < lowestValue) {
                    lowestValue = horsePowers[j+i];
                    index = j + i;
                }
            }
            int temp = horsePowers[j];
            horsePowers[j] = lowestValue;
            horsePowers[index] = temp;
        }
    }

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setHorsePower(300);
        car2.setHorsePower(100);
        car3.setHorsePower(200);

        Car cars[] = {car1,car2,car3};
        int horsePowers[] = {car1.getHorsePower(),car2.getHorsePower(),car3.getHorsePower(),};

        for (int i : horsePowers) System.out.print(i + " ");
        System.out.println("");

        sortArray(horsePowers);

        for (int i : horsePowers) System.out.print(i + " ");
        System.out.println("");

    }
}
