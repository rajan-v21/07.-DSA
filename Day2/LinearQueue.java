public class LinearQueue {
    int front, rear, size;
    int capacity;
    int arr[];
    void createQueue(int capacity){
        this.capacity = capacity;
        front = rear = 0;
        arr = new int[capacity];
    }
    boolean isFull(){
        return rear == capacity;
    }
    boolean isEmpty(){
        return rear == front;
    }
    void enqueue(int item){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = item;
        rear++;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int item = arr[front];
        front++;
        return item;
    }
    void printQueue(){
        for(int i = front; i < rear; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue();

        q.createQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();
        System.out.println();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}