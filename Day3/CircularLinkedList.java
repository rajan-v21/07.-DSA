import java.util.Scanner;

public class CircularLinkedList {
    Node root, last;
    void createList(){
        root=last=null;
    }
    void insertLeft(int data){
        Node n = new Node(data);
        if(root==null){
            root=last=n;
            last.next=root;
        }
        else{
            n.next=root;
            root=n;
            last.next=root;
        }
    }
    void insertRight(int data){
        Node n = new Node(data);
        if(root==null){
            root=last=n;
            last.next=root;
        }
        else{
            last.next=n;
            last=n;
            last.next=root;
        }
    }
    void deleteLeft(){
        if(root==null){
            System.out.println("List is empty");
        }
        else if(root==last){
            root=last=null;
        }
        else{
            System.out.println("Deleted element: "+root.data);
            root=root.next;
            last.next = root;
        }
    }
    void deleteRight(){
        if(root==null){
            System.out.println("List is empty");
        }
        else if(root==last){
            root=last=null;
        }
        else{
            Node temp = root;
            while(temp.next!=last){
                temp=temp.next;
            }
            temp.next=root;
            last=temp;
        }
    }
    void display(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            Node temp = root;
            do{
                System.out.print("|"+temp.data+"|->");
                temp=temp.next;
            }while(temp!=root);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.createList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter choice: 1. Insert-Left 2. Insert-Right 3. Delete-Left 4. Delete-Right 5. Display 0. Exit");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    n = sc.nextInt();
                    c.insertLeft(n);
                    break;
                case 2:
                    n = sc.nextInt();
                    c.insertRight(n);
                    break;
                case 3:
                    c.deleteLeft();
                    break;
                case 4:
                    c.deleteRight();
                    break;
                case 5:
                    c.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=0);
        sc.close();
    }
}
