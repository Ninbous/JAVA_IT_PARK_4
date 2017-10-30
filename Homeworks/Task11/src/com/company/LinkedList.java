package com.company;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Node head;
    private Node tail;
    private int count;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public void addToBegin(T object) {
        Node newNode = new Node(object);

        if (head == null) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        count++;
    }

    @Override
    public T get(int index) {
        if (index < 0 && index >= count) {
            throw new IllegalArgumentException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return (T) currentNode.value;
    }

    @Override
    public void remove(T object) {
        if (head.value.equals(object)) {
            head = head.next;
            count--;
        } else {
            Node currentNode = head;
            while (currentNode.next != null && !currentNode.next.value.equals(object)) {
                currentNode = currentNode.next;
            }
            if (currentNode.next.value.equals(object)) {
                currentNode.next = currentNode.next.next;
                count--;
            }
        }
    }

    @Override
    public int indexOf(T object) {
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            if (currentNode.value.equals(object)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        private Node currentNode = head;

        @Override
        public T next() {
            T element = (T) currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node<T> {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }


}