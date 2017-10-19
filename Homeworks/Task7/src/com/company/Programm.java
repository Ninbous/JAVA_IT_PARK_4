package com.company;

public class Programm {


    public static boolean isLetter(char c) // буква
    {
        int cCode = c;
        return ((cCode >= 65 && cCode <= 90)||(cCode >= 97 && cCode <= 122));
    }

    public static boolean isDigit(char c) // цифр
    {
        int cCode = c;
        return (cCode >= 48 && cCode <= 57);
    }


    public static boolean isUpper(char c) // заглавная буква
    {
        int cCode = c;
        return (cCode >= 65 && cCode <= 90);
    }

    public static boolean isLower(char c) // униженная буква
    {
        int cCode = c;
        return (cCode >= 97 && cCode <= 122);
    }


    public static int parse(char number[]) //превращает цифру чар в цифру инт или дабл
    {
        int i = 0;
        for (char c : number)
        {
            i *= 10;
            i = i + (int)c - 48;
        }
        return i;
    }
}
