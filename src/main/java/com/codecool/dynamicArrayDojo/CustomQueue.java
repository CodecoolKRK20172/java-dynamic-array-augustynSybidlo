package com.codecool.dynamicArrayDojo;

public class CustomQueue {

    private Node head;
    private Node tail;
    private int size;

    public CustomQueue() {
        this.size = 0;
    }

    public void enqueue (String value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.nextNode = new Node(value);
            tail = tail.nextNode;
        }
        incrementSize();
    }

    public String peek() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is Empty");
        return head.value;
    }

    public String dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is Empty");

        String result = head.value;
        head = head.nextNode;
        decrementSize();
        return result;
    }

    public int queueSize() {
        return size;
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private String value;
        private Node nextNode;

        private Node(String value){
            this.value = value;
            this.nextNode = null;
        }
    }
}
