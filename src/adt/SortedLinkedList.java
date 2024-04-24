/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;
import java.util.Iterator;
/**
 *
 * @author deede
 */

public class SortedLinkedList<T extends Comparable<T>> implements SortedLinkedListInterface<T> {

    private Node firstNode; // reference to the first node
    private int numberOfEntries; // number of entries in the list

    public SortedLinkedList() {
        clear();
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty() || newEntry.compareTo(firstNode.data) <= 0) {
            // Insert at the beginning if the list is empty or newEntry is smaller/equal to the firstNode
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            Node previousNode = null;

            // Traverse to find the correct position to insert
            while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            // Insert newNode between previousNode and currentNode
            newNode.next = currentNode;
            previousNode.next = newNode;
        }

        numberOfEntries++;
        return true;
    }

    public T remove(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                // Remove the first node
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                // Remove from a position other than the first
                Node previousNode = getNodeAt(givenPosition - 1);
                Node currentNode = previousNode.next;
                result = currentNode.data;
                previousNode.next = currentNode.next;
            }

            numberOfEntries--;
        }

        return result;
    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = false;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = getNodeAt(givenPosition);
            currentNode.data = newEntry;
            isSuccessful = true;
        }

        return isSuccessful;
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            result = getNodeAt(givenPosition).data;
        }

        return result;
    }

    public boolean contains(T anEntry) {
        Node currentNode = firstNode;
        boolean found = false;

        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return firstNode.data;
        }
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        // Create a new array of type T with the size of numberOfEntries
        T[] result = (T[]) new Comparable[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] toSortedArray() {
        // Create a sorted array of type T with the size of numberOfEntries
        T[] sortedResult = (T[]) new Comparable[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            sortedResult[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }

        // Sort the array using Arrays.sort() method
        java.util.Arrays.sort(sortedResult);

        return sortedResult;
    }

    private Node getNodeAt(int position) {
        Node currentNode = firstNode;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public int compareTo(T otherEntry) {
        return 0;
    }
    
    public boolean removeItem(T itemToRemove) {
        Node currentNode = firstNode;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.data.equals(itemToRemove)) {
                // Found the item to remove
                if (previousNode == null) {
                    // Removing the first node
                    firstNode = currentNode.next;
                } else {
                    // Removing a node other than the first one
                    previousNode.next = currentNode.next;
                }

                numberOfEntries--;
                return true; // Item removed successfully
            }

            // Move to the next node
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // Item not found in the list
        return false;
    }

}


