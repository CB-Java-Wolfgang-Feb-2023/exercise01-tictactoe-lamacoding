package Queue;
import java.util.Arrays;

public class Queue {
    private int rear, front;
    private int[] queue;
    private final int SIZE;

    public Queue(int SIZE) {
        this.SIZE = SIZE;
        queue = new int[SIZE];
        rear = 0;
        front = 0;
    }

    public Queue() {
        this(10);
    }

    public void enqueue(int val) {
        if (!isFull()) {
            queue[rear++] = val;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            return queue[front++];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private boolean isFull() {
        return rear > SIZE;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = front; i < rear; i++) {
            str += queue[i];
            if (i != rear - 1) {
                str += ",";
            }
        }
        return str;
    }
}
