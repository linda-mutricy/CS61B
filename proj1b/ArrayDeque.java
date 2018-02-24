public class ArrayDeque<T> implements Deque<T> {
    /**
     * This class accepts any generic type, not just integers. See lecture 5 for generics.
     * /* Lec 4 and 5. See last slide for rule of thumb.
     * /* Add and remove operations must take constant time, except during resizing operations.
     * /* Get and size must take constant time.
     * /* The starting size of your array should be 8.
     * /* The amount of memory used must be proportional to number of items.
     * /* For arrays of length 16 or more, your usage factor should always be at least 25%.
     * /* For smaller arrays, your usage factor can be arbitrarily low.
     * /* Strongly recommend that you treat your array as circular.
     */

    T[] items;
    int size;
    private int first;
    private int last;
    private int capacity;

    // A resizing method.
    private void resize(int c) {
        T[] newitems = (T[]) new Object[c];
        for (int i = 0; i <= capacity; i += 1) {
            newitems[i] = items[(first + i) % capacity];
        }
        first = c;
        last = size - 1;
        items = newitems;
    }

    //Creates an empty array deque.
    public ArrayDeque() {
        items = (T[]) new Object[8];
        capacity = items.length;
        size = 0;
        last = 0;
        first = -1; //the first thing is -1.
    }

    @Override
    //Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        } else if (first == (size - 1)) {
            first = 0;
        } else {
            first += 1;
        }
        items[first] = item;
        size += 1;
    }

    @Override
    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
        } else if (last == size - 1) {
            last = 0;
        } else {
            last += 1;
        }
        items[last] = item;
        size += 1;
    }


    @Override
    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns true if the deque is full, false otherwise.
     */
    public boolean isFull() {
        return (size == capacity);
    }

    @Override
    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    @Override
    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[(first + i) % capacity] + " ");
        }
        System.out.println();
    }

    @Override
    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        T x = items[first];
        if (first == size - 1) {
            first = 0;
        } else {
            first += 1;
        }
        size -= 1;
        return x;
    }

    @Override
    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        T x = items[last];
        if (last == 0) {
            last = size - 1;
        } else {
            last -= 1;
        }
        size -= 1;
        return x;
    }

    @Override
    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     */
    public T get(int index) {
        return items[index];
    }
}