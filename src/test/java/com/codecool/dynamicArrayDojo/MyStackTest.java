package com.codecool.dynamicArrayDojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new MyStack<>(Integer.class, 5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    void testPushWhenSpaceAvailable() {
        stack.push(4);
        int actual = stack.peek();
        int expected = 4;
        int expectedSecond = 5;
        assertEquals(expected, actual);
        assertEquals(expectedSecond, stack.getSize());
    }

    @Test
    void testGetSize() {
        int actual = stack.getSize();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void testIfPushThrowsException() {
        stack.push(4);
        assertThrows(StackOverflowError.class, () -> stack.push(5));
    }

    @Test
    void testIfPeekThrowsException() {
        MyStack<Integer> newStack = new MyStack<>(Integer.class, 5);
        assertThrows(EmptyStackException.class, newStack::peek);
    }

    @Test
    void testPeek() {
        int expected = 3;
        int actual = stack.peek();
        assertEquals(expected, actual);
    }

    @Test
    void testPop() {
        int expected = 3;
        int actual = stack.pop();
        assertEquals(expected, actual);
    }

    @Test
    void testIfPopChangeTopOfStack() {
        int expected = 2;
        stack.pop();
        int actual = stack.peek();
        assertEquals(expected, actual);
    }

    @Test
    void testIfPopThrowsException() {
        MyStack<Integer> newStack = new MyStack<>(Integer.class, 5);
        assertThrows(EmptyStackException.class, newStack::pop);
    }

    @Test
    void testCheckAvailableSpace() {
        int expected = 1;
        assertEquals(expected, stack.checkAvailableSpace());
    }
}