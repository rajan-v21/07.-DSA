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
    char pop(){
        return stack[tos--];
    }
    //peek(): returns top item without removing it from stack
    char peek(){
        return stack[tos];
    }
    //printStack(): prints all items in stack in LIFO order
    void printStack(){
        for(int i=tos; i>=0; i--)
            System.out.println(stack[i]);
    }
    public static void main(String[] args) {
        boolean flag=true;
        char temp;
        valid_paranthesis vp = new valid_paranthesis();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        vp.create_Stack(s.length());
        for(int i=0;i<s.length();i++)// and push in stack
            {
                char c = s.charAt(i);
                if (c == '{')
                    vp.push(c);
                else if (c == '}' && vp.isEmpty()!=true)
                    temp = vp.pop();
                else if(c == '}' && vp.isEmpty()==true)
                {
                    System.out.println("Error:} unexpected");
                    flag = false;
                    break;
                }

            }
            if(vp.isEmpty()==true && flag==true)
                System.out.println("Perfectly balanced:.....");
            else if(!vp.isEmpty())
                System.out.println("Error: } is expected");
        sc.close();
    }
}
