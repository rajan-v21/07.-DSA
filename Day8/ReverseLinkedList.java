

public class ReverseLinkedList{
    Node root;

    void insert(int data){
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
        Node temp = root;
        while(temp!=null){
            System.out.print("|"+temp.data+"|->");
            temp=temp.next;
        }
    }

    void reverse(){
        Node temp = root;
        Node prev = null;
        while(temp!=null){
            Node next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        root=prev;
    }


    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.insert(1);
        rl.insert(2);
        rl.insert(3);
        rl.insert(4);
        rl.insert(5);
        rl.display();
        rl.reverse();
        System.out.println();
        rl.display();
    }
}
