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
    
    /**
    * Returns the actual index in the internal array corresponding to the given logical index.
    * If the logical index is negative, it wraps around to the end of the array.
    *
    * @param index The logical index of the element in the circular array list.
    * @return The actual index in the internal array.
    */
    private int getIndex(int index) {
        if (index < 0) {
            index += elements.length;
        }
        return (front + index) % elements.length;
    }
    
    /**
    * Ensures that the internal array has enough capacity to accommodate additional elements.
    * If the current size of the array equals its length, the array is doubled in size and elements are copied.
    * Additionally, if the front index is not at the start, elements are shifted to maintain circularity.
    */
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
    
    //Adds a new element to the end of the circular array list.
    @Override
    public boolean add(T newElement) {
        ensureCapacity();
        elements[getIndex(size)] = newElement;
        size++;
        return true;
    }
    
    //Adds a new element at the specified position in the circular array list.
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
    
    //Removes the element at the specified index position from the circular array list.
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
    
    //Removes the specified element from the circular array list.
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

    //Retrieves the element at the specified index position in the circular array list.
    @Override
    public T getEntry(int indexPosition) {
        if (indexPosition < 0 || indexPosition >= size) {
            return null;
        }
        return elements[getIndex(indexPosition)];
    }
    
    //Checks if the circular array list contains the specified element.
    @Override
    public boolean contains(T givenElement) {
        for (int i = 0; i < size; i++) {
            if (elements[getIndex(i)].equals(givenElement)) {
                return true;
            }
        }
        return false;
    }
    
    //Checks if the circular array list is empty.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    //Always returns false since a circular array list cannot be full.
    @Override
    public boolean isFull() {
        return false; // Circular array list cannot be full
    }
    
    //Clears all elements from the circular array list.
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        front = 0;
    }
    
    //Replaces the element at the specified index position with the new element.
    @Override
    public boolean replace(int indexPosition, T newElement) {
        if (indexPosition < 0 || indexPosition >= size) {
            return false;
        }
        elements[getIndex(indexPosition)] = newElement;
        return true;
    }
    
    //Returns the number of elements in the circular array list.
    @Override
    public int getNumberOfEntries() {
        return size;
    }
    
    //Returns the index of the first occurrence of the specified element in the circular array list.
    @Override
    public int getIndexOf(T givenElement) {
        for (int i = 0; i < size; i++) {
            if (elements[getIndex(i)].equals(givenElement)) {
                return i;
            }
        }
        return -1;
    }

    // Returns the number of elements in the circular array list.
    @Override
    public int size() {
       
        return size;
       
    }
    
    
    //Below are functions for shared interface but this adt didnt used it
    @Override
    public boolean twoCondSearch(String targetWord, String target2, int cond) {
  
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean threeCondSearch(String targetWord, String target2, String target3, int cond) {
      
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean customIntegerContains(int targetValue) {
   
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean customDoubleContains(double targetValue) {
       
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean replaceAll(String word, String word2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean customRemove(String word) {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sort(int cond) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public boolean condSearch(String targetWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

