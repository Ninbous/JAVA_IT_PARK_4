package com.company;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {

    private final int INITIAL_SIZE = 10;
    private Object elements[];
    private int count;

    public ArrayList() {
        elements = new Object[INITIAL_SIZE];
        count = 0;
    }

    @Override
    public void add(T element) {
        if (count == elements.length) {
            Object[] tempArray = new Object[(int) (elements.length * 1.5)];
            for(int i = 0; i < count; i++)
            {
                tempArray[i] = elements[i];
            }
            elements = tempArray; //Ссылка с темпАррэя присваивается в наш старый элементс
        }
        elements[count] = element;
        count++;
    }

    @Override
    public void addToBegin(T element) {
        if (count == elements.length) {
            Object[] tempArray = new Object[(int) (elements.length * 1.5)];
            for(int i = 0; i < count; i++)
            {
                tempArray[i] = elements[i];
            }
            elements = tempArray; //Ссылка с темпАррэя присваивается в наш старый элементс
        }
        for(int i = count; i > 0; i--)
        {
            elements[i] = elements[i-1];
        }
        elements[0] = element;
        count++;
    }

    @Override
    public T get(int index) {
        return (T)elements[index];
    }

    @Override
    public void remove(Object object) {
        for (int i = 0; i < count; i++) {
            if (object.equals(elements[i])) {
                for (; i < count - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                count--;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        int currentIndex;

        public ArrayListIterator() {
            this.currentIndex = 0;
        }

        @Override
        public T next() {
            if (currentIndex < count)
                return (T) elements[currentIndex++];
            else
                return null;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }
    }
}
