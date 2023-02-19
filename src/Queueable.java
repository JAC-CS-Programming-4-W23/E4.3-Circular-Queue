public interface Queueable {

    /**
     * Add an element to the rear of the queue.
     * @param element element to be added to queue.
     * @precondition The queue is not full.
     * @postcondition The element has been added to the rear of the queue.
     */
     void enqueue(int element);

    /**
     * Remove and return the element from the front of a queue.
     * @return the element that was at the front of the queue.
     * @precondition The queue is not empty.
     * @postcondition The front element has been removed from the queue.
     */
    int dequeue();

    /**
     * Return the element from the front of a queue.
     * @return the element that was at the front of the queue.
     * @precondition The queue is not empty.
     */
    int peek();

    /**
     * Test whether the queue is empty.
     * @return true if the queue is empty, false otherwise.
     * @precondition None.
     */
    boolean isEmpty();

    /**
     * Test whether the queue is full.
     * @return true if the queue is full, false otherwise.
     * @precondition None.
     */
    boolean isFull();
}
