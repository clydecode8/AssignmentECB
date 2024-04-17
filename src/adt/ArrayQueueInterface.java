
package adt;
import java.util.ArrayList;

/**
 *
 * @author jie
 */
public interface ArrayQueueInterface<T> {
    // add object at back
    public void enqueue(T newEntry);
    // add object at front
    public void enqueueFront(T element);
    // add object at middle
    public void enqueueMiddle(int index, T element);
    // add object at back
    public void enqueueRear(T element);
    // remove object at front
    public T dequeue();
    // remove object at front
    public T dequeueFront();
    // remove object at middle
    public T dequeueMiddle(int index);
    // remove object at end
    public T dequeueRear();
    // see object
    public T peek();
    // see object at middle
    public T peekMiddle(int position);
    // check size
    public int size();
    // check is empty or not
    public boolean isEmpty();
    // will copy the items in arraylist and return a arrayqueue
    public CustomArrayQueue<T> copy(ArrayList<T> arrayList);
    // custom to string
    public String toString2();
    
}
