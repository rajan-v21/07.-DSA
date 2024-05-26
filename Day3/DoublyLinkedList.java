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
            n.right=root;
            root.left=n;
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
                System.out.print("|"+temp.data+"|->");
                temp=temp.right;
            }
        }
    }
    void displayReverse(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp.right!=null){
                temp=temp.right;
            }
            while(temp!=null){
                System.out.print("|"+temp.data+"|->");
                temp=temp.left;
            }
        }
    }

    void deleteLeft(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            System.out.println("Deleted: "+root.data);
            root=root.right;
            root.left=null;
        }
    }
    void deleteRight(){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(temp.right!=null){
                temp=temp.right;
            }
            System.out.println("Deleted: "+temp.data);
            temp.left.right=null;
        }
    }
    void deleteAt(int pos){
        if(root==null){
            System.out.println("List is empty");
        }
        else{
            DNode temp = root;
            while(pos>1 && temp!=null){
                temp=temp.right;
                pos--;
            }
            if(temp==null){
                System.out.println("Position out of range");
            }
            else{
                System.out.println("Deleted: "+temp.data);
                temp.left.right=temp.right;
                temp.right.left=temp.left;
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
                temp=temp.right;
                pos--;
            }
            if(temp==null){
                System.out.println("Position out of range");
            }
            else{
                n.right=temp.right;
                n.left=temp;
                temp.right=n;
                n.right.left=n;
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
