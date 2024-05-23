import java.util.Scanner;

public class NestedStack {
    int maxSize, tos1, tos2, stack[];
    void create_Stack(int size){
        maxSize = size;
        tos1 = -1;
        tos2 = maxSize;
        stack = new int[size];
    }

    boolean isFull1(){
        return (tos1 == maxSize-1);
    }
    boolean isFull2(){
        return (tos2 == 0);
    }
    boolean isEmpty1(){
        return (tos1 == -1);
    }
    boolean isEmpty2(){
        return (tos2 == maxSize);
    }
    void push1(int item) {
        stack[++tos1] = item;
    }
    void push2(int item) {
        stack[--tos2] = item;
    }

    int pop1() {
        return stack[tos1--];
    }
    int pop2() {
        return stack[tos2++];
    }
    int peek1(){
        return stack[tos1];
    }
    int peek2(){
        return stack[tos2];
    }
    void printStack1() {
        for (int i = tos1; i >= 0; i--)
            System.out.println(stack[i]);
    }
    void printStack2() {
        for(int i = tos2; i <maxSize; i++)
            System.out.println(stack[i]);
    }
    

    public static void main(String[] args) {
        int choice, item , size;
        NestedStack ns =new NestedStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of stack: ");
        size = sc.nextInt();
        ns.create_Stack(size);

        do {
            System.out.println("1. Push1\n2. Pop1\n3. Peek1\n4. Print1\n"+
                                "5. Push2\n6. Pop2\n7. Peek2\n8. Print2 \n"+
                                "9. Print full-stack \n0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (!ns.isFull1()) {
                        System.out.print("Enter item to push: ");
                        item = sc.nextInt();
                        ns.push1(item);
                    } else
                        System.out.println("Stack is full");
                    break;
                case 2:
                    if (!ns.isEmpty1()) {
                        item = ns.pop1();
                        System.out.println("Item popped: " + item);
                    } else 
                        System.out.println("Stack is empty");
                    break;
                case 3:
                    if (!ns.isEmpty1()) {
                        item = ns.peek1();
                        System.out.println("Top item: " + item);
                    } else
                        System.out.println("Stack is empty");
                    break;
                case 4:
                    ns.printStack1();
                    break;
                case 5:
                    if (!ns.isFull2()) {
                        System.out.print("Enter item to push: ");
                        item = sc.nextInt();
                        ns.push2(item);
                    } else
                        System.out.println("Stack is full");
                    break;
                case 6:
                    if (!ns.isEmpty2()) {
                        item = ns.pop2();
                        System.out.println("Item popped: " + item);
                    } else 
                        System.out.println("Stack is empty");
                    break;
                case 7:
                    if (!ns.isEmpty2()) {
                        item = ns.peek2();
                        System.out.println("Top item: " + item);
                    } else
                        System.out.println("Stack is empty");
                    break;
                case 8:
                    ns.printStack2();
                    break;

                case 9:
                    ns.printStack1();
                    ns.printStack2();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}
