
package Queue;
public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println("Queue: " + q);
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Queue: " + q);
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Queue: " + q);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println("Queue: " + q);
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Queue: " + q);
    }
}
