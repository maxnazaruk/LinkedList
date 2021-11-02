package com.luxoft.list;

public class TESTS {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(list.lastIndexOf(1));
        System.out.println(list.lastIndexOf(2));
        System.out.println(list.lastIndexOf(3));
    }
}
