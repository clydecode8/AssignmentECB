/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author yuanf
 */

public interface LinkedListInterface<T> {
    // Adds an element to the list (could be at the beginning, end, or a specific index)
    void add(T element);

    // Removes an element from the list (could be by value or index)
    T remove(T element);  // Or remove(int index)
    
    // New remove method by position
    T remove(int position);

    // Retrieves the element at a specific index
    T get(int index);

    // Checks if the list contains a specific element
    boolean contains(T element);

    // Finds the index of the first occurrence of an element (or -1 if not found)
    int indexOf(T element);

    // Returns the number of elements in the list
    int size();

    // Checks if the list is empty
    boolean isEmpty();

    boolean isFull();
    // Optional methods for iterating over the list elements
    //Iterator<T> iterator();  // Or some other traversal mechanism
}
