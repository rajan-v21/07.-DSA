package Day1;
import java.util.Scanner;

public class Stack_Basic{
    
    int maxSize, tos, stack[];
    //create stack: stack, init tos -1 and prepare stack for use
    void create_Stack(int size){
        maxSize = size;
        tos = -1;
        stack = new int[maxSize];
    }
    void push(int item){
        stack[++tos]=item; //first increment tos, then put item in stack
    }
    //isFull(): returns true if stack is full else false
    boolean isFull(){
        return (tos == maxSize-1);
    }
    //isEmpty(): returns true if stack is empty else false
    boolean isEmpty(){
        return (tos == -1);
    }
    //pop(): returns top item and removes it from stack
    int pop(){
        return stack[tos--];
    }
    //peek(): returns top item without removing it from stack
    int peek(){
        return stack[tos];
    }
    //printStack(): prints all items in stack in LIFO order
    void printStack(){
        for(int i=tos; i>=0; i--)
            System.out.println(stack[i]);
    }
    //main(): code for menu driven 1. push 2. pop 3. peek 4. print 0. exit
    public static void main(String[] args) {
        Stack_Basic stack = new Stack_Basic();
        int choice, item, size;
        System.out.print("Enter size of stack: ");
        Scanner sc = new Scanner (System.in);
        size = sc.nextInt();
        stack.create_Stack(size);
        do{
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Print\n0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(!stack.isFull()){
                        System.out.print("Enter item to push: ");
                        item = sc.nextInt();
                        stack.push(item);
                    }
                    else
                        System.out.println("Stack is full");
                    break;
                case 2:
                    if(!stack.isEmpty()){
                        item = stack.pop();
                        System.out.println("Item popped: " + item);
                    }
                    else
                        System.out.println("Stack is empty");
                    break;
                case 3:
                    if(!stack.isEmpty()){
                        item = stack.peek();
                        System.out.println("Top item: " + item);
                    }
                    else
                        System.out.println("Stack is empty");
                    break;
                case 4:
                    if(!stack.isEmpty()){
                        stack.printStack();
                    }
                    else
                        System.out.println("Stack is empty");
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