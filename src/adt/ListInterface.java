/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author User
 * @param <T>
 */
public interface ListInterface<T> {

    
    
    /**
    * Task: Adds a new entry to the end of the list. Entries currently in the
    * list are unaffected. The list's size is increased by 1.
    *
    * @param newElement the object to be added as a new entry
    * @return true if the addition is successful, or false if the list is full
    */
    public boolean add(T newElement);

   /**
    * Task: Adds a new entry at a specified position within the list. Entries
    * originally at and above the specified position are at the next higher
    * position within the list. The list's size is increased by 1.
    *
    * @param newPosition an integer that specifies the desired position of the
    * new entry
    * @param newElement the object to be added as a new entry
    * @return true if the addition is successful, or false if either the list is
    * full, newPosition < 1, or newPosition > getNumberOfEntries()+1
    */
     public boolean add(int newPosition, T newElement);


   /**
    * Task: Removes the entry at a given position from the list. Entries
    * originally at positions higher than the given position are at the next
    * lower position within the list, and the list's size is decreased by 1.
    *
    * @param indexPosition an integer that indicates the position of the entry to
    * be removed
    * @return a reference to the removed entry or null, if either the list was
    * empty, indexPosition < 1, or
    *          indexPosition > getNumberOfEntries()
    */
    public T remove(int indexPosition);

   /**
    * Task: Retrieves the entry at a given position in the list.
    *
     * @param element
    * @param indexPosition an integer that indicates the position of the desired
    * entry
    * @return a reference to the indicated entry or null, if either the list is
    * empty, indexPosition < 1, or indexPosition > getNumberOfEntries()
    */
    
   
    
    public T getEntry(int indexPosition);

    /**
    * Task: Sees whether the list contains a given entry.
    *
    * @param givenElement the object that is the desired entry
    * @return true if the list contains anEntry, or false if not
    */
    public boolean contains(T givenElement);  


    /**
    * Task: Sees whether the list is empty.
    *s
    * @return true if the list is empty, or false if not
    */
    public boolean isEmpty();

    /**
    * Task: Sees whether the list is full.
    *
    * @return true if the list is full, or false if not
    */
    public boolean isFull();


    /**
    * Task: Removes all entries from the list.
    */
    public void clear();  

    /**
    * Task: Replaces the entry at a given position in the list.
    *
    * @param indexPosition an integer that indicates the position of the entry to
    * be replaced
    * @param newElement the object that will replace the entry at the position
    * indexPosition
    * @return true if the replacement occurs, or false if either the list is
    * empty, indexPosition < 1, or indexPosition > getNumberOfEntries()
    */
    public boolean replace(int indexPosition, T newElement);
    
    /**/
    
    public int getNumberOfEntries();
    
    /**
    * Task: Retrieves the index of the givenElement
    *
    * @param givenElement the object that will be searched through to find the index position
    * @return true if the search occurs, or false if either the list is
    * empty, indexPosition < 1, or indexPosition > getNumberOfEntries()
    */    
    public int getIndexOf(T givenElement);
  
    /**
   * Task: Gets the size of entries in the list.
   *
   * @return the integer number of entries currently in the list
   */ 
    public int size();
  
    /**
     * Task: Searches for a target word within the array.
     * 
     * @param targetWord the word to be searched for
     * @return true if the target word is found in the array, false otherwise
     */  
    public boolean condSearch(String targetWord);
    
    /**
     * Task: Performs a conditional search based on the given target words and condition.
     * 
     * @param targetWord the first word to search for
     * @param targetWord2 the second word to search for
     * @param cond the condition specifying the type of search:
     *             - 1 for searching two strings
     *             - 2 for searching a string and an integer
     *             - 3 for searching a string and a double
     * @return true if the search condition is met, false otherwise
     */
    public boolean twoCondSearch(String targetWord, String targetWord2, int cond);
   
    
    /**
     * Task: Performs a conditional search based on the given target words and condition.
     * 
     * @param targetWord the first word to search for
     * @param targetWord2 the second word to search for
     * @param targetWord3 the third word to search for
     * @param cond the condition specifying the type of search:
     *             - 1 for searching three strings
     *             - 2 for searching a string, a string, and a double
     *             - 3 for searching a string, a string, and an integer
     * @return true if the search condition is met, false otherwise
     */

    public boolean threeCondSearch(String targetWord, String targetWord2, String targetWord3, int cond);
   
    /**
     * Task: Checks whether the entries contain the specified integer value.
     * 
     * @param targetValue the integer value to search for
     * @return true if any entry contains the target integer value, false otherwise
     *         Returns all entries containing the target value, including duplicates (e.g., "12" and 12)
     */
    public boolean customIntegerContains(int targetValue);
   
    /**
     * Task: Checks whether the entries contain the specified double value.
     * 
     * @param targetValue the double value to search for
     * @return true if any entry contains the target double value, false otherwise
     *         Returns all entries containing the target value, including duplicates (e.g., "12.0" and 12.0)
     */
    public boolean customDoubleContains(double targetValue);
    
    /**
     * Task: Replaces all occurrences of oldValue with newValue in all entries.
     * 
     * @param oldValue the value to be replaced
     * @param newValue the new value to replace oldValue
     * @return true if any occurrence of oldValue is found and replaced, false otherwise
     *         Duplicate occurrences of oldValue in an entry will also be changed to newValue
     */

    public boolean replaceAll(String oldValue, String newValue);
    
    /**
     * Task: Removes the entry that contains the specified word.
     * 
     * @param word the word to be searched for and removed from the array
     * @return true if any entry containing the word is found and removed, false otherwise
     */
    public boolean customRemove(String word);
    
    /**
     * Task: Performs bubble sort on the array according to each entity's criteria.
     * 
     * @param cond specifies the sorting order:
     *             - 0 for ascending order
     *             - 1 for descending order
     */
    public void sort(int cond);
    
    /**
     * Task: Provides an iterator for traversing the elements of the array.
     * 
     * <p>It serves as a substitute for a for loop.
     * <p>The hasNext() method checks for the size of the array to determine if there are more elements to iterate over.
     * <p>It is required that elements in the array are comparable when calling the method.
     * <p>Example usage: Comparable tutorialGroup = iterator.next();
     * 
     * @return an iterator for the elements of the array
     */
    public Iterator<T> iterator();
   
    /**
    * Task: Removes the specified element from the array.
    * 
    * @param element the element to be removed
    * @return the removed element, or null if the element is not found in the array
    */
    public T remove(T element);
    
    
}
