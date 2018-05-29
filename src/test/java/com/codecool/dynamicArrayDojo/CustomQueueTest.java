package com.codecool.dynamicArrayDojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    private CustomQueue customQueue;

    @BeforeEach
    void setup() {
        customQueue = new CustomQueue();
        customQueue.enqueue("0");
        customQueue.enqueue("1");
        customQueue.enqueue("2");
    }

    @Test
    void testEnqueue() {
        int expected = 3;
        int actual = customQueue.queueSize();
        assertEquals(expected, actual);
    }

    @Test
    void testPeek() {
        String expected = "0";
        String actual = customQueue.peek();
        assertEquals(expected, actual);
    }

    @Test
    void testIfPeekThrowsException() {
        CustomQueue newCustomQueue = new CustomQueue();
        assertThrows(EmptyQueueException.class, newCustomQueue::peek);
    }

    @Test
    void testDequeue() {
        int expected = 2;
        String expectedValue = "0";
        String actual = customQueue.dequeue();
        assertEquals(expected, customQueue.queueSize());
        assertEquals(expectedValue, actual);
    }

    @Test
    void testIfDequeueThrowsException() {
        CustomQueue newCustomQueue = new CustomQueue();
        assertThrows(EmptyQueueException.class, newCustomQueue::dequeue);
    }

    @Test
    void testIsEmptyWhenNotEmpty() {
        assertFalse(customQueue.isEmpty());
    }

    @Test
    void testIsEmptyWhenEmpty() {
        CustomQueue newCustomQueue = new CustomQueue();
        assertTrue(newCustomQueue.isEmpty());
    }
}