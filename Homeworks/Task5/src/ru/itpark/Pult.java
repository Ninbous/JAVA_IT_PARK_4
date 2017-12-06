package ru.itpark;

public class Pult {

    TV tv;

    public Pult(TV tv) {
        this.tv = tv;
    }

    public void showAppearens() {
        System.out.println("Какую кнопку на пульте нажать?\n" +
                " 0 - кнопка включения/выключения\n" +
                " 1 - канал №1\n" +
                " 2 - канал №2\n" +
                " 3 - канал №3");
    }

    public boolean pushButton(int button) {
        switch (button) {
            case 0:
                tv.turnOnOrOff();
                break;
            case 1:
                tv.swichTo(0);
                break;
            case 2:
                tv.swichTo(1);
                break;
            case 3:
                tv.swichTo(2);
                break;
            default:
                System.out.println("Пальцами по кнопкам попадай!");
        }
        return false;
    }
}
