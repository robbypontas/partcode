package com.technocerry.linkedlist;

/**
 * Created by robby.pontas on 6/1/15.
 */
public class MyLinkedList <T>{
    private Node head;
    private int size;

    public MyLinkedList(){
        head = new Node(null);
        size = 1;
    }

    /**
     *@param data data of linked list, can be any of object
     */
    public void add(T data)
    {
        Node temp = new Node(data);
        Node current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(temp);
        size++;
    }

    /**
     *
     * @param index index of data, start from 1, first next
     * @return object as you created
     */
    public T get(int index)
    {
        if (index <= 0 || index > size)
            throw new IllegalArgumentException(index > size?"index out of range":"index must be greater than 0");

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current.getData();
    }

    /**
     *
     * @param index index of data, start from 1, first next
     * @return true if remove wa succeed
     */
    public boolean remove(int index)
    {
        if (index < 1 || index > size)
            return false;

        Node data = head;
        for (int i = 1; i < index; i++) {
            if (data.getNext() == null)
                return false;

            data = data.getNext();
        }
        data.setNext(data.getNext().getNext());
        size--;
        return true;
    }

    /**
     *
     * @return size of datas
     */
    public int size()
    {
        return size;
    }

    /**
     *
     * @return get all datas separated by comas
     */
    public String toString() {
        Node current = head.getNext();
        String string = "";
        while (current != null) {
            string += current.getData().toString() + ", ";
            current = current.getNext();
        }
        return string;
    }


    private class Node {
        Node next;

        T data;

        public Node(T data) {
            next = null;
            this.data = data;
        }

        public Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
