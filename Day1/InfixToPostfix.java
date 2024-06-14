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

    // Method to return associativity of operators
    boolean isRightAssociative(char op) {
        if (op == '^') {
            return true; // '^' operator is right associative
        }
        return false; // Other operators are left associative
    }

    void infixToPostfix(char[] exp, char[] postfix) {
        create_Stack(exp.length);
        int k = 0; // Index for postfix array

        for (char ch : exp) {
            // If the character is an operand, add it to output
            if (Character.isLetterOrDigit(ch)) {
                postfix[k++] = ch;
            }
            // If the character is '(', push it to stack
            else if (ch == '(') {
                push(ch);
            }
            // If the character is ')', pop and output from the stack
            // until an '(' is encountered
            else if (ch == ')') {
                while (!isEmpty() && peek() != '(') {
                    postfix[k++] = pop();
                }
                if (!isEmpty() && peek() != '(') {
                    return; // Invalid expression
                } else {
                    pop();
                }
            } 
            else { // An operator is encountered
                while (!isEmpty() && precedence(ch) < precedence(peek()) ||
                       (!isEmpty() && precedence(ch) == precedence(peek()) && !isRightAssociative(ch))) {
                    postfix[k++] = pop();
                }
                push(ch);
            }
        }

        // Pop all the operators from the stack
        while (!isEmpty()) {
            postfix[k++] = pop();
        }

        // Print the postfix expression
        for (int i = 0; i < k; i++) {
            System.out.print(postfix[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String input = sc.nextLine();
        char exp[] = input.toCharArray();
        char postfix[] = new char[exp.length];
        InfixToPostfix obj = new InfixToPostfix();
        obj.infixToPostfix(exp, postfix);
        sc.close();
    }
}
