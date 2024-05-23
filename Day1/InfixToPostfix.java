package Day1;
import java.util.Scanner;

public class InfixToPostfix {
    int maxSize, tos;
    char stack[];

    // Create stack: stack, init tos -1 and prepare stack for use
    void create_Stack(int size) {
        maxSize = size;
        tos = -1;
        stack = new char[maxSize];
    }

    void push(char item) {
        stack[++tos] = item; // First increment tos, then put item in stack
    }

    // isFull(): returns true if stack is full else false
    boolean isFull() {
        return (tos == maxSize - 1);
    }

    // isEmpty(): returns true if stack is empty else false
    boolean isEmpty() {
        return (tos == -1);
    }

    // pop(): returns top item and removes it from stack
    char pop() {
        return stack[tos--];
    }

    // peek(): returns top item without removing it from stack
    char peek() {
        return stack[tos];
    }

    // Method to return precedence of operators
    int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char exp[] = sc.nextLine().toCharArray();
        char postfix[] = new char[exp.length];
        InfixToPostfix obj = new InfixToPostfix();
        obj.create_Stack(exp.length);
        int k = 0; // Index for postfix array

        for (int i = 0; i < exp.length; i++) {
            // If the character is an operand, add it to output
            if (Character.isLetterOrDigit(exp[i])) {
                postfix[k++] = exp[i];
            }
            // If the character is '(', push it to stack
            else if (exp[i] == '(') {
                obj.push(exp[i]);
            }
            // If the character is ')', pop and output from the stack
            // until an '(' is encountered
            else if (exp[i] == ')') {
                while (!obj.isEmpty() && obj.peek() != '(') {
                    postfix[k++] = obj.pop();
                }
                if (!obj.isEmpty() && obj.peek() != '(') {
                    return; // Invalid expression
                } else {
                    obj.pop();
                }
            } else { // An operator is encountered
                while (!obj.isEmpty() && obj.precedence(exp[i]) <= obj.precedence(obj.peek())) {
                    postfix[k++] = obj.pop();
                }
                obj.push(exp[i]);
            }
        }

        // Pop all the operators from the stack
        while (!obj.isEmpty()) {
            postfix[k++] = obj.pop();
        }

        for (int i = 0; i < k; i++) {
            System.out.print(postfix[i]);
        }
    }
}
