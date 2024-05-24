import java.util.Scanner;

public class LinearListToQueue {
    Node front;
    Node rear;
    void createQueue(){
        front=rear=null;
    }
    void enqueue(int data){
        Node n = new Node(data);
        if(rear==null){
            front=n;
            rear=n;
        }
        else{
            rear.next=n;
            rear=n;
        }
    }
    void dequeue(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println(front.data);
            if(front == rear){
                front=rear=null;
            }
            else{
                front=front.next;
            }
        }
    }
    void display(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            Node temp = front;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        LinearListToQueue obj = new LinearListToQueue();
        obj.createQueue();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter choice: 1. Enqueue 2. Dequeue 3. Display");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    obj.enqueue(n);
                    break;
                case 2:
                    obj.dequeue();
                    break;
                case 3:
                    obj.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=0);
        sc.close();
    }
}   
