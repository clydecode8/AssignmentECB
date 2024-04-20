package adt;

/**
 * An interface for a sorted list data structure.
 * 
 * @param <T> The type of elements in the sorted list, which must implement Comparable.
 *            Elements should be comparable to allow sorting.
 * 
 * The sorted list maintains its elements in ascending order according to their natural ordering.
 * Duplicate elements are allowed.
 * 
 * Operations supported by this interface include adding, removing, and accessing elements,
 * as well as checking the size and emptiness of the list.
 * 
 * @author Liew Yee Jie
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

    /**
     * Adds a new item to the sorted list.
     * 
     * @param newEntry The item to be added to the sorted list.
     */
    public void add(T newEntry);
    
    /**
     * Removes the specified entry from the sorted list, if it exists.
     * 
     * @param entry The entry to be removed from the sorted list.
     * @return True if the entry was successfully removed, false otherwise.
     */
    public boolean remove(T entry);

    /**
     * Removes the entry at the specified index from the sorted list.
     * 
     * @param index The index of the entry to be removed.
     * @return The entry that was removed from the sorted list.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public T remove(int index);
            
    /**
     * Retrieves the entry at the specified position in the sorted list.
     * 
     * @param position The position of the entry to be retrieved.
     * @return The entry at the specified position in the sorted list.
     * @throws IndexOutOfBoundsException If the position is out of range.
     */
    public T getEntry(int position);

    /**
     * Retrieves the position of the specified entry in the sorted list.
     * 
     * @param entry The entry whose position is to be determined.
     * @return The position of the specified entry in the sorted list, or -1 if not found.
     */
    public int getPosition(T entry);

    /**
     * Removes all entries from the sorted list.
     */
    public void clear();

    /**
     * Retrieves the current size of the sorted list.
     * 
     * @return The number of entries currently in the sorted list.
     */
    public int size();

    /**
     * Checks whether the sorted list is empty or not.
     * 
     * @return True if the sorted list contains no entries, false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Returns a string representation of the sorted list.
     * 
     * @return A string containing the string representations of all entries in the sorted list.
     */
    public String toString2();
}
