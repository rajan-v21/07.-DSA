import java.util.Scanner;

public class reverse_string {
    int maxSize, tos;
    char stack[];
    //create stack: stack, init tos -1 and prepare stack for use
    void create_Stack(int size){
        maxSize = size;
        tos = -1;
        stack = new char[maxSize];
    }
    void push(char item){
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
        reverse_string rs = new reverse_string();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        rs.create_Stack(s.length());
        for(char c : s.toCharArray()){
            rs.push(c);
        }
        rs.printStack();
        sc.close();
    }
}
