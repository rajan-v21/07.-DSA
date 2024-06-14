//Qs: You are given two Singly Linked Lists, write code to find the node where they both intersect.

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node (int data){
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node root;
    void createList(){
        root=null;
    }
    void insertRight(int data){
        Node n = new Node(data);
        if(root==null){
            root=n;
        }
        else{
            Node temp = root;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
        }
    }
    void display(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            Node temp = root;
            while(temp!=null){
                System.out.print("|"+temp.data+"|->");
                temp=temp.next;
            }
        }
        System.out.println("null");
    }
}
public class IntersectingNode {

    static void intersectingNode(Node root1, Node root2){
        //code here
        boolean flag = true;
        if(root1==null || root2==null){
            System.out.println("List is empty");
            return;
        }
        else{
            Node temp = root1;
            while(temp!=null){
                Node temp2 = root2;
                while(temp2!=null){
                    if(temp.data==temp2.data){
                        System.out.println("Intersecting node is: "+temp.data);
                        flag = false;
                    }
                    temp2=temp2.next;
                }
                temp=temp.next;
            }
        }
        if(flag) System.out.println("No intersecting node found");
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of List1: ");
        int len = sc.nextInt();
        System.out.println("Enter elements of List1: ");
        l1.createList();
        for(int i=0;i<len;i++){
            int n = sc.nextInt();
            l1.insertRight(n);
        }
        LinkedList l2 = new LinkedList();
        System.out.println("Enter length of List2: ");
        len = sc.nextInt();
        System.out.println("Enter elements of List2: ");
        l2.createList();
        for(int i=0;i<len;i++){
            int n = sc.nextInt();
            l2.insertRight(n);
        }
        l1.display();
        l2.display();
        intersectingNode(l1.root, l2.root);
        sc.close();
    }
}
