import java.util.Scanner;

class LinearLinkedList{
    Node root;
    void createList(){
        root=null;
    }
    void insertLeft(int data){
        Node n = new Node(data);
        if(root==null){
            root=n;
        }
        else{
            n.next=root;
            root=n;
        }
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
            System.out.println("list is empty");
        }
        else{
            Node temp = root;
            while(temp!=null){
                System.out.println("|"+temp.data+"|->");
                temp=temp.next;
            }
        }
    } 
    void search(int key){
        if(root==null){
            System.out.println("list is empty");
        }
        else{
            Node temp = root;
            int count=0;
            while(temp!=null && temp.data != key){
                count++;
                temp=temp.next;
            }
            if(temp==null){
                System.out.println(key + " Not found");
            }
            else{
                System.out.println(key + " Found at: "+count);
            }
        }
    }
    void deleteLeft(){
        if(root==null){
            System.out.println("list is empty");
        }
        else{
            System.out.println("Deleted: "+root.data);
            root=root.next;
        }
    }
    void deleteRight(){
        if(root==null){
            System.out.println("list is empty");
        }
        else if(root.next==null){
            System.out.println("Deleted: "+root.data);
            root=null;
        }
        else{
            Node temp = root;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            System.out.println("Deleted: "+temp.next.data);
            temp.next=null; //deleting last node
            }
    }

    void insert(int data, int pos){
        Node n = new Node(data);
        //case1: insert at start
        if(pos == 0){
            n.next=root;
            root=n;
        }
        //case2: insert at middle
        else if(pos > 0){
            Node temp = root;
            while(pos>0 && temp!=null){
                pos--;
                temp=temp.next;
            }
            if (temp == null)
                System.out.println("Position out of range");
            else{
                n.next=temp.next;
                temp.next=n;
            }
        }
    }

    void delete(int key){
        if(root==null){
            System.out.println("list is empty");
        }
        else{
            System.out.println(key+ " found in list");
            //case 1: delete at start
            if(root==null){
                System.out.println("Deleted: "+root.data);
                root=root.next;
            }
            //case 2:
            if(root.next == null){
                System.out.println("Deleted: "+root.data);
                root=null;
            }
            //case 3:
            if(root.next.next!=null){
                root=root.next;
                System.out.println("Deleted: "+root.data);
                root.next=null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearLinkedList l = new LinearLinkedList();
        l.createList();
        System.out.println(" 1. Insert-Left \n 2. Insert-Right\n" +
                        " 3. Delete-Left\n" +
                        " 4. Delete-Right\\n" + 
                        " 5. Display \n 6. Delete-At \n 7. Insert-At \n" + 
                        " 8. Search \n 0. Exit"+
        "Enter your choice: ");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    int data = sc.nextInt();
                    l.insertLeft(data);
                    break;
                case 2:
                    data = sc.nextInt();
                    l.insertRight(data);
                    break;
                case 3:
                    l.deleteLeft();
                    break;
                case 4:
                    l.deleteRight();
                    break;
                case 5:
                    l.display();
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