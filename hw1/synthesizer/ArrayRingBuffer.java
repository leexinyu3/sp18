// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>   {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.fillCount = 0;
    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last % capacity] = x;
        last +=1 ;
        fillCount +=1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T removed_item = rb[first % capacity];
        first +=1;
        fillCount -=1;
        return removed_item;
    }


    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first%capacity];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    public Iterator<T> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{

        private int current;
        private int count;
        public MyIterator(){
            current = first;
            count = 0;
        }
        @Override
        public boolean hasNext(){
            return count < capacity;

        }

        @Override
        public  T next(){
            if (hasNext()){
                T ret = rb[current];
                current +=1;
                count+=1;
                return ret;
            }
            return null;
        }

    }
}
