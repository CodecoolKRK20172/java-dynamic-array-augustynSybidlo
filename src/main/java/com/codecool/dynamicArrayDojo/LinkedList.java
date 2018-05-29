package com.codecool.dynamicArrayDojo;

public class LinkedList<T> {

    private Node head;
    private int length;

    public LinkedList() {
        this.length = 0;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
            incrementLength();
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {

        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Node pointer = head;
        T result = null;
        int counter = 0;

        while (pointer != null) {
            if (counter == index){
                result = pointer.data;
                break;
            } else {
                pointer = pointer.next;
                counter++;
            }
        }
        return result;
    }

    public void add(T newData) {

        Node pointer;

        if (head == null) {
            head = new Node(newData);
        } else {
            pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(newData);
        }
    }

    public void addFirst(T newData) {
        Node temp;

        if (head == null) {
            head = new Node(newData);
        } else {
            temp = head;
            head = new Node(newData);
            head.next = temp;
        }
    }

    public void delete(T data) {

        Node pointer = head;
        while (pointer != null) {
            Node temp = pointer;
            if (temp.data.equals(data)) {
                pointer = temp.next;
                decrementLength();
            } else {
                pointer = pointer.next;
            }
        }
    }

    public boolean contains(T data) {
        Node pointer = head;
        boolean contains = false;

        while (pointer != null) {
            if (pointer.data.equals(data)) {
                contains = true;
            }
            pointer = pointer.next;
        }
        return contains;
    }

    public int getLength() {
        return length;
    }

    private void incrementLength() {
        this.length++;
    }

    private void decrementLength() {
        this.length--;
    }
}
