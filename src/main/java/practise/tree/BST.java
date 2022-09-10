package practise.tree;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }


    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int val){
        if (root == null){
            return false;
        }
        if (val == root.data){
            return true;
        }else if (val < root.data){
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node delete (Node root, int val){
        //first need to search for the node with data as val
        if (root.data > val){
            root.left = delete(root.left, val);
        } else if (root.data < val){
            root.right = delete(root.right, val);
        } else{
            // case 1 - no child
            if (root.left == null && root.right == null){
                return  null;
            }
            // 2nd case only 1 child
            if (root.left == null){
                return  root.right;
            } else if (root.right == null){
                return root.left;
            }

            // 3rd case
            Node inorderSuccessor = getInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);
        }
        return root;
    }

    public static Node getInorderSuccessor(Node root){
      while (root.left != null){
          root = root.left;
      }
      return root;
    }

    public static void main(String args[]) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        root = delete(root,8 );
        inOrder(root);
    }


}
