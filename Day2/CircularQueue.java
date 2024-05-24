import java.util.Scanner;

public class CircularQueue {
    int queue[], maxSize, front, rear, count;
    
    void createQueue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isFull() {
        return (rear == maxSize);
    }

    boolean isEmpty() {
        return (count == 0);
    }

    void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        count++;
        rear= (rear+1)%maxSize;
        queue[rear] = item;
    }

    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front+1)%maxSize;
        count--;
        return item;
    }

    void printQueue() {
        int i, c;
        i = front;
        c = 0;
        while(c < count) {
            System.out.print(queue[i] + "-->");
            i = (i+1)%maxSize;
            c++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue();
        cq.createQueue(5);
        System.out.println("Enter your option: 1. Enqueue 2. Dequeue 3. Print");
        int choice = sc.nextInt();
        do {
            switch(choice) {
                case 1:
                    int item = sc.nextInt();
                    cq.enqueue(item);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.printQueue();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice != 0);
        sc.close();
    }
}
