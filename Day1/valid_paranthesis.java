import java.util.Scanner;

public class valid_paranthesis {
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
        valid_paranthesis vp = new valid_paranthesis();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        vp.create_Stack(s.length());
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '{'){
                vp.push(c);
                count++;
            }
            else if(c == '}'){
                if(!vp.isEmpty()){
                    vp.pop();
                }
                else{
                    System.out.println("Unexpected }");
                }
                count--;
            }
        }
        if(count > 0 ){
            System.out.println("expected }");
        }
        else if (count == 0){
            System.out.println("valid");
        }
        sc.close();
    }
}
