public class IntQueue implements Queueable {

    private final int[] elements;
    private int front;
    private int rear;
    private boolean empty;

    public IntQueue(int capacity) {
        elements = new int[capacity];
        rear = -1;
        front = -1;
        empty = true;
    }

    public void enqueue(int element) {
        if(isFull()) {
            throw new QueueOverflowException();
        }

        rear = mod(rear + 1, elements.length);
        elements[rear] = element;
        empty = false;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new QueueUnderflowException();
        }

        front = mod(front + 1, elements.length);

        if(front == rear) {
            empty = true;
        }

        return elements[front];
    }

    public boolean isFull() {
        return mod(front, elements.length) == mod(rear, elements.length) && !empty;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int peek() {
        if(isEmpty()) {
            throw new QueueUnderflowException();
        }

        return elements[mod(front + 1, elements.length)];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "FRONT --> [] <-- REAR";
        }

        StringBuilder result = new StringBuilder("FRONT --> [");

        for (int i = mod(front + 1, elements.length); i != rear; i = mod(i + 1, elements.length)) {
            result.append(elements[i]);
            result.append(", ");
        }

        result.append(elements[rear]).append("] <-- REAR");

        return result.toString();
    }

    /**
     * Compute x modulo m.
     * @param x The value.
     * @param m The modulus.
     * @return The value of x modulo m, which will always be positive.
     */
    private static int mod(int x, int m) {
        if (x >= 0) {
            return x % m;
        }
        else {
            return m + (x % m);
        }
    }
}
