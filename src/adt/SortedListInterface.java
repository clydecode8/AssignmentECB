package adt;

/**
 *
 * @author jie
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

    // add item
    public void add(T newEntry);
    
    // remove item
    public boolean remove(T entry);

    // remove index item
    public T remove(int index);
            
    // get item
    public T getEntry(int position);

    // get position of item
    public int getPosition(T entry);

    // remove all items
    public void clear();

    // get list size
    public int size();

    // check is empty or not
    public boolean isEmpty();
    
    // return string
    public String toString2();
}

