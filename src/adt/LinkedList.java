/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author yuanf
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    private Node<T> head; // Reference to the first node in the list
    private Node<T> tail; // Reference to the last node in the list
    private int size;       // Number of elements in the list


    // Nested Node class to encapsulate data and next reference
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // ListInterface methods

    @Override
    public void add(T element) {
        // Add the element to the end of the list (assuming append functionality)
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T remove(T element) {
        // Check for empty list and element existence
        if (isEmpty()) {
            return null; // Or throw an exception if preferred
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (previous == null) { // Removing the head node
                    head = current.next;
                    if (head == null) { // Handle removing the only element
                        tail = null;
                    }
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.data;
            }
            previous = current;
            current = current.next;
        }

        return null; // Element not found
    }
    
    public T remove(int position) {
      // Validate position (check for empty list and invalid index)
      if (isEmpty() || position < 0 || position >= size) {
        throw new IndexOutOfBoundsException("Invalid position: " + position);
      }

      // Handle removing the head node
      if (position == 0) {
        T removedData = head.data;
        head = head.next;
        if (head == null) {
          tail = null; // Handle removing the only element
        }
        size--;
        return removedData;
      }

      // Traverse to the node before the target position
      Node<T> current = head;
      Node<T> previous = null;
      for (int i = 0; i < position; i++) {
        previous = current;
        current = current.next;
      }

      // Remove the target node
      previous.next = current.next;
      if (current == tail) {
        tail = previous; // Update tail if removing the last node
      }
      size--;
      return current.data;
    }

    @Override
    public T get(int index) {
        // Check for index validity and empty list
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean contains(T element) {
        // Iterate through the list and check for element existence
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        // Iterate through the list and keep track of index
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; // Element not found
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean isFull(){
        return false;
    }

    // Optional methods (not part of the original interface)

    /*public void addFirst(T element) {
        // Add the element to the beginning of the list
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtIndex(T element, int index) {
    // Check for index validity and empty list
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    if (index == 0) {
        addFirst(element);
        return;
    }

    Node<T> current = head;
    Node<T> previous = null;
    for (int i = 0; i < index; i++) {
        previous = current;
        current = current.next;
    }

    Node<T> newNode = new Node<>(element);
    newNode.next = current; // Insert the new node after the previous node

    if (previous == null) { // Adding at the beginning (handled by addFirst)
        head = newNode;
    } else {
        previous.next = newNode;
    }

    size++;
    }*/
}