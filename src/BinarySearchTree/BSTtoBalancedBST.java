package BinarySearchTree;
import java.util.ArrayList;

public class BSTtoBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Inorder sequnece
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    //inorder to Balanced BST
    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }

    public static Node balancedBST(Node root){
        //inorder sequence->
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //inorder to Balanced BST ->
        root = createBST(inorder,0,inorder.size()-1);
        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        //given BST
        Node root = new Node(8);

        root.left = new Node(6);                    //         8
        root.left.left = new Node(5);               //       /  \
        root.left.left.left = new Node(3);          //      6    10
                                                         //     /      \
        root.right = new Node(10);                  //    5        11
        root.right.right = new Node(11);            //   /          \
        root.right.right.right = new Node(12);      //  3           12

        /* Expected Balanced BST-
        *             8
        *          /     \
        *         5      11
        *        / \    /  \
        *       3   6  10  12
        * */
        root = balancedBST(root);
        preOrder(root);
    }
}
