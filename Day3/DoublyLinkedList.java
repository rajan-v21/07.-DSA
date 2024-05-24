import java.util.Scanner;

public class DoublyLinkedList {
    DNode root;
    void createList(){
        root=null;
    }

    void insertLeft(int data){
        DNode n = new DNode(data);
        if(root==null){
            root=n;
        }
        else{
            n.next=root;
            root.prev=n;
            root=n;
        }
    }
    void insertRight(int data){
        DNode n = new DNode(data);
        if(root==null){
            root=n;
        }
        else{
            DNode temp = root;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
            n.prev=temp;
        }
    }

    void display(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp!=null){
                System.out.print("|"+temp.data+"|->");
                temp=temp.next;
            }
        }
    }
    void displayReverse(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp.next!=null){
                temp=temp.next;
            }
            while(temp!=null){
                System.out.print("|"+temp.data+"|->");
                temp=temp.prev;
            }
        }
    }

    void deleteLeft(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            System.out.println("Deleted: "+root.data);
            root=root.next;
            root.prev=null;
        }
    }
    void deleteRight(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp.next!=null){
                temp=temp.next;
            }
            System.out.println("Deleted: "+temp.data);
            temp.prev.next=null;
        }
    }
    void deleteAt(int pos){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(pos>1 && temp!=null){
                temp=temp.next;
                pos--;
            }
            if(temp==null){
                System.out.println("Position out of range");
            }
            else{
                System.out.println("Deleted: "+temp.data);
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }
        }
    }
    void insertAt(int pos, int data){
        DNode n = new DNode(data);
        if(root==null){
            root=n;
        }
        else{
            DNode temp = root;
            while(pos>1 && temp!=null){
                temp=temp.next;
                pos--;
            }
            if(temp==null){
                System.out.println("Position out of range");
            }
            else{
                n.next=temp.next;
                n.prev=temp;
                temp.next=n;
                n.next.prev=n;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter choice: 1. Insert-Left 2. Insert-Right 3. Delete-Left 4. Delete-Right 5. Display 6. Display-Reverse 7. Delete-At 8. Insert-At 0. Exit");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    n = sc.nextInt();
                    dll.insertLeft(n);
                    break;
                case 2:
                    n = sc.nextInt();
                    dll.insertRight(n);
                    break;
                case 3:
                    dll.deleteLeft();
                    break;
                case 4:
                    dll.deleteRight();
                    break;
                case 5:
                    dll.display();
                    break;
                case 6:
                    dll.displayReverse();
                    break;
                case 7:
                    int pos = sc.nextInt();
                    dll.deleteAt(pos);
                    break;
                case 8:
                    pos = sc.nextInt();
                    n = sc.nextInt();
                    dll.insertAt(pos, n);
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
