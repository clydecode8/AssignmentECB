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
    /**
   * Task: Adds a new entry to the linked list. The behavior (beginning, end, or specific position)
   * depends on the implementation.
   *
   * @param element the object to be added as a new entry
   */
    // Adds an element to the list (could be at the beginning, end, or a specific index)
    void add(T element);

     /**
   * Task: Removes an entry from the linked list. The behavior (by value or index) depends on the implementation.
   *
   * @param element the object to be removed from the list
   * @return a reference to the removed entry or null if not found
   */
    // Removes an element from the list (could be by value or index)
    T remove(T element);  // Or remove(int index)
    
    /**
   * Task: Removes the entry at a specific position in the linked list.
   * 
   * @param position an integer that specifies the position of the entry to be removed
   * @return a reference to the removed entry or null if the position is invalid
   */
    // New remove method by position
    T remove(int position);

    /**
   * Task: Retrieves the entry at a specific index in the linked list.
   *
   * @param index an integer that indicates the position of the desired entry
   * @return a reference to the indicated entry or null if the index is invalid
   */
    // Retrieves the element at a specific index
    T get(int index);

    /**
   * Task: Sees whether the linked list contains a given entry.
   *
   * @param element the object that is the desired entry
   * @return true if the list contains anEntry, or false if not
   */
    // Checks if the list contains a specific element
    boolean contains(T element);

    /**
   * Task: Sees whether the linked list contains a given element and returns its index.
   * 
   * @param element the object that will be searched for
   * @return the index of the first occurrence of the element, or -1 if not found
   */
    // Finds the index of the first occurrence of an element (or -1 if not found)
    int indexOf(T element);

    /**
   * Task: Gets the number of entries currently in the linked list.
   *
   * @return the integer number of entries currently in the list
   */
    // Returns the number of elements in the list
    int size();

    /**
   * Task: Sees whether the linked list is empty.
   *
   * @return true if the list is empty, or false if not
   */
    // Checks if the list is empty
    boolean isEmpty();

    /**
   * Task: Checks whether the linked list is full (optional method, might not be applicable).
   *
   * @return true if the list is full, or false if not (might always return false)
   */
    boolean isFull();
    // Optional methods for iterating over the list elements
    //Iterator<T> iterator();  // Or some other traversal mechanism
}
