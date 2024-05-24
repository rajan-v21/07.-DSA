import java.util.Scanner;

public class LinearListToStack {
    Node tos;
    void createStack(){
        tos = null;
    }
    void pushTop(int data){
        if(tos == null){
            System.out.println("Stack is Empty");
        }
        else{
            Node n = new Node(data);
            n.next = tos;
            tos = n;
        }
    }
    void popTop(){
        if(tos == null){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println(tos.data);
            tos = tos.next;
        }
    }
    public static void main(String[] args) {
        LinearListToStack s = new LinearListToStack();
        s.createStack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter choice: 1. Push 2. Pop 3. Exit");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    s.pushTop(n);
                    break;
                case 2:
                    s.popTop();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=3);
        sc.close();
    }
}