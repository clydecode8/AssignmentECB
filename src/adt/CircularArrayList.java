package adt;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArrayList<T> implements ListInterface<T> {
    private static final int DEFAULT_CAPACITY = 20;
    private T[] elements;
    private int size;
    private int front;

    @SuppressWarnings("unchecked")
    public CircularArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
    }

    @SuppressWarnings("unchecked")
    public CircularArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.front = 0;
    }

    private int getIndex(int index) {
        if (index < 0) {
            index += elements.length;
        }
        return (front + index) % elements.length;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
            if (front != 0) {
                // If front is not at the start, adjust indices of elements
                System.arraycopy(elements, 0, elements, elements.length / 2, front);
                for (int i = 0; i < front; i++) {
                    elements[i] = null; // Clear copied elements
                }
                front += elements.length / 2;
            }
        }
    }

    @Override
    public boolean add(T newElement) {
        ensureCapacity();
        elements[getIndex(size)] = newElement;
        size++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newElement) {
        if (newPosition < 0 || newPosition > size) {
            return false;
        }
        ensureCapacity();
        int index = getIndex(newPosition);
        if (newPosition < size) {
            System.arraycopy(elements, index, elements, index + 1, size - newPosition);
        }
        elements[index] = newElement;
        size++;
        return true;
    }

    @Override
    public T remove(int indexPosition) {
        if (indexPosition < 0 || indexPosition >= size) {
            return null;
        }
        int index = getIndex(indexPosition);
        T removedElement = elements[index];
        if (indexPosition < size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        elements[getIndex(size - 1)] = null;
        size--;
        return removedElement;
    }
    
   
    @Override
    public T remove(T element) {
    int index = -1;
    // Find the index of the element
    for (int i = 0; i < size; i++) {
        if (elements[i].equals(element)) {
            index = i;
            break;
        }
    }
    // If element not found, return null
    if (index == -1) {
        return null;
    }
    // Remove the element at the found index
    T removedElement = elements[index];
    if (index < size - 1) {
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    }
    elements[getIndex(size - 1)] = null;
    size--;
    return removedElement;
}


    @Override
    public T getEntry(int indexPosition) {
        if (indexPosition < 0 || indexPosition >= size) {
            return null;
        }
        return elements[getIndex(indexPosition)];
    }

    @Override
    public boolean contains(T givenElement) {
        for (int i = 0; i < size; i++) {
            if (elements[getIndex(i)].equals(givenElement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false; // Circular array list cannot be full
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        front = 0;
    }

    @Override
    public boolean replace(int indexPosition, T newElement) {
        if (indexPosition < 0 || indexPosition >= size) {
            return false;
        }
        elements[getIndex(indexPosition)] = newElement;
        return true;
    }

    @Override
    public int getNumberOfEntries() {
        return size;
    }

    @Override
    public int getIndexOf(T givenElement) {
        for (int i = 0; i < size; i++) {
            if (elements[getIndex(i)].equals(givenElement)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
       
        return size;
       
    }
 
    @Override
    public boolean twoCondSearch(String targetWord, String target2, int cond) {
        // Implementation not provided
        return false;
    }

    @Override
    public boolean threeCondSearch(String targetWord, String target2, String target3, int cond) {
        // Implementation not provided
        return false;
    }

    @Override
    public boolean customIntegerContains(int targetValue) {
        // Implementation not provided
        return false;
    }

    @Override
    public boolean customDoubleContains(double targetValue) {
        // Implementation not provided
        return false;
    }

    @Override
    public boolean replaceAll(String word, String word2) {
        // Implementation not provided
        return false;
    }

    @Override
    public boolean customRemove(String word) {
        // Implementation not provided
        return false;
    }

    @Override
    public void sort(int cond) {
        // Implementation not provided
    }

    @Override
    public Iterator<T> iterator() {
        // Implementation not provided
        return null;
    }

    @Override
    public String toString2() {
        // Implementation not provided
        return null;
    }

    @Override
    public boolean condSearch(String targetWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

