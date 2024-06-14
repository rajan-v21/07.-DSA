//Qs: You are given a Doubly Linked List, write code to check if the list is Palindrome or not.

import java.util.Scanner;

class DNode {
    DNode left, right;
    int data;
    DNode(int data){
        this.data = data;
        left=right=null;
    }
}

class DoublyLinkedList {
    DNode root;
    void createList(){
        root=null;
    }
    void insertRight(int data){
        DNode n = new DNode(data);
        if(root==null){
            root=n;
        }
        else{
            DNode temp = root;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=n;
            n.left=temp;
        }
    }

    void display(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp!=null){
                System.out.print("|"+temp.data+"|<=>");
                temp=temp.right;
            }
        }
        System.out.println("null");
    }
}
public class PalindromeList {
    static void checkPalindrome(DNode root) {
        //code here
        DNode i = root;
        DNode j = root;
        while(j.right!=null){
            j=j.right;
        }
        while(i!=null && j!=null){
            if(i.data!=j.data){
                System.out.println("Not a palindrome");
                return;
            }
            i=i.right;
            j=j.left;
        }
        System.out.println("Palindrome");
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of List: ");
        int len = sc.nextInt();
        System.out.println("Enter elements: ");
        dll.createList();
        for(int i=0;i<len;i++){
            int n = sc.nextInt();
            dll.insertRight(n);
        }
        dll.display();
        checkPalindrome(dll.root);
        sc.close();
    }
}
