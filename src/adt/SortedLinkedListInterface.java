/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author deede
 */
import java.util.Iterator;

public interface SortedLinkedListInterface<T extends Comparable<T>> {

    /**
     * Adds a new entry to the sorted linked list in its appropriate position.
     * Entries are added based on their natural ordering defined by compareTo method.
     *
     * @param newEntry The entry to add to the sorted linked list.
     * @return True if the entry is successfully added, false otherwise.
     */
    public boolean add(T newEntry);

    /**
     * Removes the entry at the given position from the sorted linked list.
     *
     * @param givenPosition The position of the entry to remove.
     * @return The removed entry if successful, null otherwise.
     */
    public T remove(int givenPosition);

    /**
     * Replaces the entry at the given position in the sorted linked list with a new entry.
     *
     * @param givenPosition The position of the entry to replace.
     * @param newEntry      The new entry to replace the existing entry.
     * @return True if the replacement is successful, false otherwise.
     */
    public boolean replace(int givenPosition, T newEntry);

    /**
     * Retrieves the entry at the given position in the sorted linked list.
     *
     * @param givenPosition The position of the entry to retrieve.
     * @return The entry at the specified position if it exists, null otherwise.
     */
    public T getEntry(int givenPosition);

    /**
     * Checks if a specific entry exists in the sorted linked list.
     *
     * @param anEntry The entry to check for existence.
     * @return True if the entry exists in the sorted linked list, false otherwise.
     */
    public boolean contains(T anEntry);

    /**
     * Gets the number of entries in the sorted linked list.
     *
     * @return The number of entries in the sorted linked list.
     */
    public int getNumberOfEntries();

    /**
     * Checks if the sorted linked list is empty.
     *
     * @return True if the sorted linked list is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Clears all entries from the sorted linked list.
     */
    public void clear();

    /**
     * Retrieves the first entry in the sorted linked list.
     *
     * @return The first entry in the sorted linked list, or null if empty.
     */
    public T getFirst();

    /**
     * Retrieves the last entry in the sorted linked list.
     *
     * @return The last entry in the sorted linked list, or null if empty.
     */
    public T getLast();

    /**
     * Retrieves an iterator over the elements in the sorted linked list.
     *
     * @return An iterator over the elements in the sorted linked list.
     */
    public Iterator<T> iterator();

    /**
     * Retrieves an array containing all entries in the sorted linked list.
     *
     * @return An array containing all entries in the sorted linked list.
     */
    public T[] toArray();

    /**
     * Retrieves a sorted array containing all entries in the sorted linked list.
     *
     * @return A sorted array containing all entries in the sorted linked list.
     */
    public T[] toSortedArray();
}
