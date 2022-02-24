/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: method headers quoted from PA6 Instructions on Canvas
 * 
 */
 public class MyDeque<E> implements DequeInterface<E> {

    Object[] data;
    int size, rear, front;

    public MyDeque(int initialCapacity) {
        if(initialCapacity < 0)
            throw new IllegalArgumentException();

        data = (E[]) new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void expandCapacity() {
        if(data.length == 0)
            data = new Object[10];
        else {
            Object[] copy = (E[])new Object[size];
            for(int i = 0; i < size; i++) {
                copy[i] = data[(front + i) % data.length];
            }

            data = (E[]) new Object[data.length * 2];
            for(int i = 0; i < size; i++) {
                data[i] = copy[i];
            }
            front = 0;
            rear = size - 1;
        }
    }

    @Override
    public void addFirst(E element) {
        if(element == null)
            throw new NullPointerException();
            
        if(size == data.length)
            expandCapacity();

        if(size == 0) {
            data[0] = element;
            front = 0;
            rear = 0;
        }
        else {
            front = (front - 1 + data.length) % data.length;
            data[front] = element;
        }

        size++;
    }

    @Override
    public void addLast(E element) {
        if(element == null)
            throw new NullPointerException();
            
        if(size == data.length)
            expandCapacity();

        if(size == 0) {
            data[0] = element;
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % data.length;
            data[rear] = element;
        }

        size++;
    }

    @Override
    public E removeFirst() {
        if(data[front] == null)
            return null;

        E first = (E)data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return first;
    }

    @Override
    public E removeLast() {
        if(data[rear] == null)
            return null;

        E last = (E)data[rear];
        data[rear] = null;
        rear = (rear - 1 + data.length) % data.length;    
        size--;  
        return last;  
    }

    @Override
    public E peekFirst() {
        if(data[front] == null)
            return null;
        else
            return (E)data[front];
    }

    @Override
    public E peekLast() {
        if(data[rear] == null)
            return null;
        else
            return (E)data[rear];
    }

 }