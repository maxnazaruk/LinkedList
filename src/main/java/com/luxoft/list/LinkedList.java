package com.luxoft.list;

import java.util.StringJoiner;

public class LinkedList implements List {
    private int size;
    private Node head;
    private Node tail;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            head.next = newNode;
            head.prev = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            tail = newNode;
        }

        size++;
    }

    public void add(Object value, int index) {
        Node newNode = new Node(value);
        Node current = head;

        if (index >= size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }if(index == 0){
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = tail;
            head = newNode;

        }else if(index == size -1){
                newNode.prev = tail.prev;
                newNode.next = tail;
                tail.prev.next = newNode;
                tail.prev = newNode;
        }else {

            int count = 0;
            while (count != index) {
                current = current.next;
                count++;
            }

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;

        }
        size++;
    }

    public Object remove(int index) {
        if (index >= size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }
        Node remove = null;
        Node current = head;

        if (index == size - 1) {
            remove = tail;
            tail.prev.next = head;
            head.prev = tail.prev;
            tail = tail.prev;
        } else if (index == 0) {
            remove = head;
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
        } else {

            int count = 0;
            while (count != index) {
                current = current.next;
                count++;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            remove = current;
        }
        size--;
        return remove.value;
    }

    public Object get(int index) {
        if (index >= size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }
        Node get = null;
        Node current = head;

        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }

        get = current;

        return get.value;
    }

    public Object set(Object value, int index) {
        Node setNode = new Node(value);
        Node current = head;
        Node object = null;

        if (index >= size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }
        if (index == size - 1) {
            object = tail;
            setNode.next = head;
            setNode.prev = tail.prev;
            tail.prev.next = setNode;
            head.prev = setNode;
            tail = setNode;
        } else if (index == 0) {
            object = head;
            setNode.next = head.next;
            setNode.prev = tail;
            tail.next = setNode;
            head.prev = setNode;
            head = setNode;

        } else {

            int count = 0;
            while (count != index) {
                current = current.next;
                count++;
            }
            object = current;
            setNode.next = current.next;
            setNode.prev = current.prev;
            current.prev.next = setNode;
            current.next.prev = setNode;
        }
        return object.value;
    }

    public void clear() {
        size = 0;

        head.prev = null;
        head.next = null;
        head = null;

        tail.prev = null;
        tail.next = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        Node current = head;
        int count = 0;
        while (count != size) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
            count++;
        }
        return false;
    }

    public int indexOf(Object value) {
        Node current = head;
        int count = 0;
        while (count != size) {
            if (current.value.equals(value)) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        Node current = tail;
        int count = size - 1;
        while (count != 0) {
            if (current.value.equals(value)) {
                return count;
            }
            current = current.prev;
            count--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        int count = 0;
        while (count != size) {
            stringJoiner.add(current.value.toString());
            current = current.next;
            count++;
        }
        return stringJoiner.toString();
    }

    public class Node {
        private Object value;
        private Node next;
        private Node prev;

        public Node(Object value) {
            this.value = value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }
}
