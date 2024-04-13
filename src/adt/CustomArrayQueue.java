package adt;

import java.util.ArrayList;

public class CustomArrayQueue<T> implements ArrayQueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;
    private int front;
    private int rear;

    // Constructor
    public CustomArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    // Methods
    @Override
    public void enqueue(T element) {
        enqueueRear(element);
    }

    public void enqueueFront(T element) {
        if (isFull()) {
            resize();
        }
        front = (front - 1 + array.length) % array.length;
        array[front] = element;
        size++;
    }

    public void enqueueMiddle(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (isFull()) {
            resize();
        }
        int insertIndex = (front + index) % array.length;
        if (index <= size / 2) {
            // Shift elements towards front
            for (int i = 0; i < index; i++) {
                array[(front + i - 1 + array.length) % array.length] = array[(front + i) % array.length];
            }
            front = (front - 1 + array.length) % array.length;
        } else {
            // Shift elements towards rear
            for (int i = size; i > index; i--) {
                array[(front + i) % array.length] = array[(front + i - 1) % array.length];
            }
            rear = (rear + 1) % array.length;
        }
        array[insertIndex] = element;
        size++;
    }

    public void enqueueRear(T element) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    @Override
    public T dequeue() {
        return dequeueFront();
    }

    public T dequeueFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

  public T dequeueMiddle(int index) {
    if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
    }
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }
    int removeIndex = (front + index) % array.length;
    T element = array[removeIndex];
    if (index < size / 2) {
        // Shift elements towards front
        for (int i = index; i > 0; i--) {
            array[(front + i) % array.length] = array[(front + i - 1) % array.length];
        }
        front = (front + 1) % array.length;
    } else {
        // Shift elements towards rear
        for (int i = index; i < size - 1; i++) {
            array[(front + i) % array.length] = array[(front + i + 1) % array.length];
        }
        rear = (rear - 1 + array.length) % array.length;
    }
    size--;
    return element;
}


    public T dequeueRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = array[rear];
        rear = (rear - 1 + array.length) % array.length;
        size--;
        return element;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }
    
    @Override
    public T peekMiddle(int position) {
        if (isEmpty() || position < 0 || position >= size) {
            return null;
        }
        int middleIndex = (front + position) % array.length;
        return array[middleIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }

    public CustomArrayQueue<T> copy(ArrayList<T> arrayList) {
        CustomArrayQueue<T> queue = new CustomArrayQueue<>(arrayList.size());
        for (T element : arrayList) {
            queue.enqueue(element);
        }
        return queue;
    }
    
     public String toString2(){
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if(i!= 5-1){
                sb.append(array[i].toString());
                sb.append(", ");
            }
            else{
                sb.append(array[i].toString());

            }
            
        }
        return sb.toString();
    }
}
