package adt;

/**
 *
 * @author Liew Yee Jie
 */
public class SortedArrayList<T extends Comparable<? super T>> implements SortedListInterface<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    // Constructor
    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable[capacity];
        array = tempArray;
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        int index = 0;
        while (index < size && newEntry.compareTo(array[index]) > 0) {
            index++;
        }
        if (size == array.length) {
            // If array is full, resize it
            doubleArray();
        }
        makeRoom(index);
        array[index] = newEntry;
        size++;
    }

    @Override
    public boolean remove(T entry) {
        int index = getPosition(entry);
        if (index != -1) {
            removeGap(index);
            size--;
            return true;
        }
        return false;
    }
    
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

        // Optional: You may want to re-sort the array after removal
        // Arrays.sort(array, 0, size);

        return removedElement;
    }




    @Override
    public T getEntry(int position) {
        if (position >= 0 && position < size) {
            return array[position];
        }
        return null;
    }

    @Override
    public int getPosition(T entry) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(entry)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Helper methods

    private void makeRoom(int index) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    //Doubles the size of array
    private void doubleArray(){
        
        T[] oldArray = array;
        array = (T[]) new Comparable[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            
            array[i] = oldArray[i];
            
        }
    }
    
    private void removeGap(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
    }
    
    public String toString2() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            // Handle the case when the array list is empty
        } else {
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    sb.append(array[i].toString());
                    sb.append(", ");
                } else {
                    sb.append(array[i].toString());
                }
            }
        }
        return sb.toString();
    }
}

