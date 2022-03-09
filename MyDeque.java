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
            
        if(this.size == this.data.length)
            expandCapacity();

        if(this.size == 0) {
            this.data[0] = element;
            this.front = 0;
            this.rear = 0;
        }
        else {
            this.front = (this.front - 1 + this.data.length) % this.data.length;
            this.data[front] = element;
        }

        this.size++;
    }

    @Override
    public void addLast(E element) {
        if(element == null)
            throw new NullPointerException();
            
        if(this.size == data.length)
            expandCapacity();

        if(this.size == 0) {
            this.data[0] = element;
            this.front = 0;
            this.rear = 0;
        }
        else {
            this.rear = (this.rear + 1) % data.length;
            this.data[rear] = element;
        }

        this.size++;
    }

    @Override
    public E removeFirst() {
        if(this.size == 0)
            return null;
        if(this.data[front] == null)
            return null;

        E first = (E)data[front];
        this.data[front] = null;
        this.size--;
        if(this.size != 0)
            this.front = (this.front + 1) % data.length;
        return first;
    }

    @Override
    public E removeLast() {
        if(this.size == 0)
            return null;
        if(this.data[rear] == null)
            return null;

        E last = (E)data[rear];
        this.size--;  
        this.data[rear] = null;
        if(this.size != 0)
        this.rear = (this.rear - 1 + this.data.length) % this.data.length;    
        return last;  
    }

    @Override
    public E peekFirst() {
        if(this.size == 0)
            return null;
        if(this.data[front] == null)
            return null;
        else
            return (E)data[front];
    }

    @Override
    public E peekLast() {
        if(this.size == 0)
            return null;
        if(this.data[rear] == null)
            return null;
        else
            return (E)data[rear];
    }


    static void initDeque(MyDeque<Integer> deque, Object[] data, int size, 
    int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }
    public static void main (String[] args) {

        MyDeque<Integer> deque = new MyDeque<>(10);
        // 1, null, null, null, null, null, null, null, null, null
        Integer[] orig = {  };
        initDeque(deque, orig, 0, 0, 0);
        deque.expandCapacity();
        System.out.println(deque.data+ " / ");
    }
 }