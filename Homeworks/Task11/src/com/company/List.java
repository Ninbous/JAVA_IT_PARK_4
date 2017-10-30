package com.company;

public interface List<T> extends Iterable {
    /**
     * Добавление в конец
     * @param element
     */
    void add(T element);

    void addToBegin(T object);

    T get(int index);

    void remove(T object);

    int indexOf(T object);

    int size();

}