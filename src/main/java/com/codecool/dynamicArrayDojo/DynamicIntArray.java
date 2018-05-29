package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int[] array;
    private int lastIndex = 0;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicIntArray(int i) {
        this.array = new int[i];
    }

    public DynamicIntArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public void add(int element) {
        changeCapacity();
        array[lastIndex++] = element;

    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);
        if (index == lastIndex) {
            lastIndex--;
        } else if (index < lastIndex) {
            removeFrom(index);
            lastIndex--;
        }
    }

    public void insert(int index, int element) {
        if (index > lastIndex) add(element);
        else insertAt(index, element);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < lastIndex; x++) {
            String newElement = " " + String.valueOf(array[x]);
            sb.append(newElement);
        }
        return sb.toString();
    }

    private void changeCapacity() {
        if (lastIndex == (array.length-1)) {
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }
    }

    private void validateIndex(int i) throws ArrayIndexOutOfBoundsException {
        if (i > (lastIndex - 1) || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void insertAt(int index, int element) {
        for (int i = lastIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        lastIndex++;
    }

    private void removeFrom(int index) {
        for (int i = index; i < lastIndex; i++) {
            array[i] = array[i+1];
        }
    }
}
