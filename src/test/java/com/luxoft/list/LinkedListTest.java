package com.luxoft.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void testAddHeadTail() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);

        assertEquals(1, linkedList.size());
        assertEquals(1, linkedList.get(0));
        assertEquals(1, linkedList.get(linkedList.size() - 1));
    }

    @Test
    public void testAddByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));

        linkedList.add(4, 2);
        assertEquals(4, linkedList.get(2));
        assertEquals(3, linkedList.get(3));
    }

    @Test
    public void testAddByIndexToHead() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(4, 0);
        assertEquals(4, linkedList.get(0));
        assertEquals(1, linkedList.get(1));
    }

    @Test
    public void testAddByIndexToTail() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(4, linkedList.size()-1);
        assertEquals(4, linkedList.get(linkedList.size()-2));
        assertEquals(3, linkedList.get(linkedList.size()-1));
    }

    @Test
    public void testRemoveByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(1);
        assertEquals(1, linkedList.get(0));
        assertEquals(3, linkedList.get(1));
    }

    @Test
    public void testRemoveHead() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(0);
        assertEquals(2, linkedList.get(0));
        assertEquals(3, linkedList.get(1));
    }

    @Test
    public void testRemovetail() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(linkedList.size()-1);
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
    }

    @Test
    public void testSetCustomNumber() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.set(100, 1);
        assertEquals(100, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    public void testSetNewHead() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.set(100, 0);
        assertEquals(100, linkedList.get(0));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    public void testSetNewTail() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.set(100, linkedList.size()-1);
        assertEquals(100, linkedList.get(linkedList.size()-1));
        assertEquals(1, linkedList.get(0));
    }

    @Test
    public void testClearLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(3, linkedList.size());

        linkedList.clear();

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testLinkedListIsEmptyVerification() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertFalse(linkedList.isEmpty());

        linkedList.clear();

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testLinkedListContainsValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(2));
        assertTrue(linkedList.contains(3));
    }

    @Test
    public void testLinkedListDoesNotContainValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertFalse(linkedList.contains(10));
        assertFalse(linkedList.contains(-1));
        assertFalse(linkedList.contains(5));
    }

    @Test
    public void testIndexOfValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(0, linkedList.indexOf(1));
        assertEquals(1, linkedList.indexOf(2));
        assertEquals(2, linkedList.indexOf(3));
    }

    @Test
    public void testLastIndexOfValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(3, linkedList.lastIndexOf(1));
        assertEquals(4, linkedList.lastIndexOf(2));
        assertEquals(5, linkedList.lastIndexOf(3));
    }

    @Test
    public void testThrowIllegalExceptionWhenIndexLargerThanSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.add(4, 4);
        });

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.set(4, 4);
        });

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.get(4);
        });

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.remove(4);
        });
    }
}
