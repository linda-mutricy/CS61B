public class LinkedListDeque <T> implements Deque<T> {
    /**This class accepts any generic type, not just integers. See lecture 5 for generics.
     /* Lec 4 and 5. See last slide for rule of thumb.
     /* Add and remove operations must take constant time.
     /* Get must use iteration and size must take constant time.
     /* The amount of memory used must be proportional to number of items.
     /* Do not maintain references to items no longer in the deque. */

    private class DLList {
        public DLList prev;
        public T item;
        public DLList next;

        public DLList (T i, DLList p, DLList n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private DLList sentFront;
    private DLList sentBack;
    public DLList getPointer;
    private int size;

    //Creates an empty linked list deque. This is the constructor.
    public LinkedListDeque() {
        sentFront = new DLList(null, null, null);
        sentBack = new DLList(null, null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        sentFront.prev = sentBack;
        sentBack.next = sentFront;
        getPointer = sentFront;
        size = 0;
    }

    @Override
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        DLList first = new DLList(item, null, null);
        first.prev = sentFront;
        first.next = sentFront.next;
        sentFront.next = first;
        first.next.prev = first;

        size += 1;
    }

    @Override
    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        DLList last = new DLList(item, null, null);
        last.prev = sentBack.prev;
        last.next = sentBack;
        sentBack.prev = last;
        last.prev.next = last;
        size += 1;
    }

    @Override
    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    //Returns the number of items in the deque.
    public int size() {
        return size;
    }

    @Override
    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        DLList printedItem = sentFront.next;
        for (int i = 0; i < size; i += 1) {
            System.out.print((String)printedItem.item + ' ');
        }
        System.out.println();
    }

    @Override
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        DLList removedFirst = sentFront.next;
        sentFront.next = removedFirst.next;
        size -= 1;
        return removedFirst.item;
    }

    @Override
    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        DLList removedLast = sentBack.prev;
        sentBack.prev = removedLast.prev;
        size -= 1;
        return removedLast.item;
    }

    @Override
    //Gets the item at the given index, where 0 is the front, 1 the next, so forth. If no such item exists, returns null.
    //Must not alter the deque!
    public T get(int index) {
        int counter = 0;
        while (index >= counter){
            getPointer = getPointer.next;
            index -= 1;
        }
        return getPointer.item;
    }

    //Recursive form of get.
    public T getRecursive(int index) {
        getPointer = getPointer.next;
        if (index == 0){
            return getPointer.item;
        }
        return getRecursive(index - 1);
    }
}