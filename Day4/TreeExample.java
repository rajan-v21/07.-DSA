import java.util.Scanner;

public class TreeExample {
    DNode root;
    void createTree() {
        root = null;
    }
    void insert(DNode r, DNode n){ //r:root as ref and n: new node to be inserted
        if(root==null){
            root=n;
        }
        else{
            if(n.data < r.data){ //left: if new node is less than root
                if(r.left==null){
                    r.left=n;
                }
                else{
                    insert(r.left,n);
                }   
            }
            else{//right: if new node is greater than root
                if(r.right==null){
                    r.right=n;
                }
                else{
                    insert(r.right,n);
                }
            }
        }
    }
    void inorder(DNode r){
        if(r!=null){
            inorder(r.left);
            System.out.print(r.data+", ");
            inorder(r.right);
        }
    }
    void preorder(DNode r){
        if(r!=null){
            System.out.print(r.data+", ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    void postorder(DNode r){
        if(r!=null){
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data+", ");
        }
    }
    boolean search(DNode r, int key){
        boolean left, right;
        if(root==null){
            System.out.println("Empty Tree");
            return false;
        }
        else{
            if(r.data == key){
                return true;
            }
            else{
                left = search(root.left, key);
                right = search(root.right, key);
                return left || right;
            }
        }
    }
    int count(DNode r){
        if(r==null){
            return 0;
        }
        else{
            return 1+count(r.left)+count(r.right);
        }
    }
    int height(DNode r){
        if(r==null){
            return 0;
        }
        else{
            int left = height(r.left);
            int right = height(r.right);
            if(left>right){
                return left+1;
            }
            else{
                return right+1;
            }
        }
    }
    int maxDepth(DNode r){
        if(r==null){
            return 0;
        }
        else{
            int left = maxDepth(r.left);
            int right = maxDepth(r.right);
            return Math.max(left, right)+1;
        }
    }
    int depth(DNode r, int key){
        if(r.data == key){
            return 0;
        }
        else{
            if(key < r.data){
                return depth(r.left, key)+1;
            }
            else{
                return depth(r.right, key)+1;
            }
        }
    }
    public static void main(String[] args) {
        TreeExample t = new TreeExample();
        t.createTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Insert 2. Inorder 3. Preorder 4. Postorder"+
                            "5. Search 6. Count 7. Height 8. Depth 0. Exit\n"+
                            "Enter choice: ");
        int choice = sc.nextInt();
        do{
            switch(choice){
                case 1: int n = sc.nextInt();
                        t.insert(t.root, new DNode(n));
                        break;
                case 2: t.inorder(t.root);
                        break;
                case 3: t.preorder(t.root);
                        break;
                case 4: t.postorder(t.root);
                        break;
                case 5: int key = sc.nextInt();
                        if(t.search(t.root, key)){
                            System.out.println("Found");
                        }
                        else{
                            System.out.println("Not Found");
                        }
                        break;
                case 6: System.out.println("Count: "+t.count(t.root));
                        break;
                case 7: System.out.println("Height: "+t.height(t.root));
                        break;
                case 8: System.out.println("Depth: "+t.depth(t.root, 5));
                        break;
                default: System.out.println("Invalid Choice");
                        break;
            }
        }while(choice!=0);
        sc.close();
    }
}
