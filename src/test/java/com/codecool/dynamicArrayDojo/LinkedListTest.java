package com.codecool.dynamicArrayDojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeEach
    void setup() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }


    @Test
    void addTest() {
        int expected = 3;
        int actual = linkedList.getLength();
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        linkedList.delete(3);
        int expected = 2;
        int actual = linkedList.getLength();
        assertEquals(expected, actual);
    }

    @Test
    void getLengthTest() {
        int expected = 3;
        int actual = linkedList.getLength();
        assertEquals(expected, actual);
    }

    @Test
    void getLengthAfterAddFirst() {
        linkedList.addFirst(5);
        assertEquals(4, linkedList.getLength());
    }

    @Test
    void containsTrueTest() {
        assertTrue(linkedList.contains(2));
    }

    @Test
    void containsFalseTest() {
        assertFalse(linkedList.contains(8));
    }

    @Test
    void addFirstWhenEmptyTest() {
        LinkedList <Integer> newLinkedList = new LinkedList<>();
        newLinkedList.addFirst(5);
        int actual = newLinkedList.get(0);
        assertEquals(5, actual);
    }

    @Test
    void addFirstTest() {
        int startIndex = 0;
        linkedList.addFirst(5);
        int actual = linkedList.get(startIndex);
        assertEquals(5, actual);
    }

    @Test
    void getThrowsExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    }

    @Test
    void getTest() {
        int index = 2;
        int actual = linkedList.get(index);
        assertEquals(3, actual);
    }
}