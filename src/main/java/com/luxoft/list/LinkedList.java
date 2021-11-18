package com.luxoft.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T>, Iterable {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    public void add(T value) {
        this.add(value, size);
    }

    public void add(T value, int index) {
        Node<T> newNode = new Node<T>(value);

        if (index > size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> prev = getNode(index - 1);
            newNode.prev = prev;
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public T remove(int index) {
        if (index > size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }
        Node<T> remove = null;
        Node<T> current = head;

        if (index == size) {
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

    public T get(int index) {
        if (index > size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }
        Node<T> get = null;
        Node<T> current = head;

        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }

        get = current;

        return get.value;
    }

    public T set(T value, int index) {
        if (index > size) {
            throw new IllegalStateException("Index is larger than size of the list");
        }

        Node<T> newNode = getNode(index);
        T valueReturn = newNode.value;
        newNode.value = value;
        return valueReturn;
    }

    public Node<T> getNode(int index){
        Node<T> node = head;

        int count = 0;

        while(count != index){
            node = node.next;
            count++;
        }
        return node;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(T value) {
        Node<T> current = head;
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

    public int lastIndexOf(T value) {
        Node<T> current = tail;
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
        Node<T> current = head;
        int count = 0;
        while (count != size) {
            stringJoiner.add(current.value.toString());
            current = current.next;
            count++;
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IClass();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public class IClass implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
}
