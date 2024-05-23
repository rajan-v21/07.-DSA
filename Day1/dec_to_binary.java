import java.util.Scanner;

public class dec_to_binary {
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

    public static void main(String[] args) {
        int size=64;//64 bit of processing
        dec_to_binary db = new dec_to_binary();
        Scanner sc = new Scanner(System.in);
        db.create_Stack(size);
        int val;
        val = sc.nextInt();
        
        while(val/2 != 0){
            int remainder;
            int quotient;
            remainder = val%2;
            db.push(remainder);
            quotient = val/2;
            val = quotient;
        }
        db.push(val%2);
        db.printStack();
    }
}
