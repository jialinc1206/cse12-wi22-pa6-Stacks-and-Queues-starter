/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: none
 * 
 * 2-4 sentence file description here
 */
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains custom tests that are stubbed out in the custom testers
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initialize with capacity < 0
     */
    @Test
    public void testMyDequeConstructor() {
        try {
            MyDeque<Integer> deque = new MyDeque<>(-1);
            fail();
        }
        catch (Exception e){
            // exception caught
        }
    }

    /**
     * Test the expandCapacity method when front > rear
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(4);
        Integer[] ori = {3, null, 1, 2};
        Integer[] fin = {1, 2, 3, null, null, null, null, null};
        deque.data = ori;
        deque.size = 3;
        deque.front = 2;
        deque.rear = 0;
        deque.expandCapacity();
        for(int i = 0; i < 8; i++)
            assertEquals(deque.data[i], fin[i]);
    }

    /**
     * Test the addFirst method when deque is empty
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        deque.addFirst(Integer.valueOf(1));
        assertEquals(Integer.valueOf(1),deque.data[0]);
        assertEquals(1,deque.size);
        assertEquals(0,deque.front);
        assertEquals(0,deque.rear);
    }

    /**
     * Test the addLast method when deque is empty
     */
    @Test
    public void testAddLast() {

    }

    /**
     * Test the removeFirst method when deque is empty
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null,deque.removeFirst());
        assertEquals(null,deque.data[0]);
        assertEquals(0,deque.size);
        assertEquals(0,deque.front);
        assertEquals(0,deque.rear);
    }

    /**
     * Test the removeLast method when deque is empty
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null,deque.removeLast());
        assertEquals(null,deque.data[0]);
        assertEquals(0,deque.size);
        assertEquals(0,deque.front);
        assertEquals(0,deque.rear);
    }

    /**
     * Test the peekFirst method when deque is empty
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null,deque.peekFirst());
        assertEquals(null,deque.data[0]);
        assertEquals(0,deque.size);
        assertEquals(0,deque.front);
        assertEquals(0,deque.rear);
    }

    /**
     * Test the peekLast method when deque is empty
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null,deque.peekLast());
        assertEquals(null,deque.data[0]);
        assertEquals(0,deque.size);
        assertEquals(0,deque.front);
        assertEquals(0,deque.rear);
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when empty() with size>0
     */
    @Test
    public void testMyStack(){
        MyStack<Integer> stack = new MyStack<>(3);
        Integer[] orig = {0, 1, 2};
        stack.theStack.data = orig;
        stack.theStack.size = 3;
        stack.theStack.front = 0;
        stack.theStack.rear = 2;
        assertFalse(stack.empty());    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when empty() with size>0
     */
    @Test
    public void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<>(3);
        Integer[] orig = {0, 1, 2};
        queue.theQueue.data = orig;
        queue.theQueue.size = 3;
        queue.theQueue.front = 0;
        queue.theQueue.rear = 2;
        assertFalse(queue.empty());    }
}
