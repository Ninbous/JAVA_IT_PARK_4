package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        DataReader dataReader = new DataReader("file.txt");
        ArrayList<LinkedList<Human>> humans = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            humans.add(new LinkedList<Human>());
        }


        String currentName = dataReader.readString();
        int currentAge = dataReader.readInteger();
        while (!currentName.equals("")) {
            humans.get(currentAge).add(new Human(currentAge, currentName));
            currentName = dataReader.readString();
            currentAge = dataReader.readInteger();
        }


        for (int i = 0; i < 100; i++) {
            if (humans.get(i).size() != 0) {
                Iterator iterator = humans.get(i).iterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next());
                }
                System.out.println();
            }
        }
    }
}
