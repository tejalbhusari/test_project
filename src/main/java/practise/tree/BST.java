package practise.tree;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static void printInRange(Node root, int x, int y){
        if (root == null){
            return;
        }
        if (root.data >= x && root.data <= y){
            printInRange(root.left, x,y);
            System.out.println(root.data);
            printInRange(root.right, x,y);
        }
        if (root.data > y){
            printInRange(root.left, x,y);
        }else if(root.data < x){
            printInRange(root.right, x,y);
        }
    }

    public static void printPaths(Node root, ArrayList<Integer> arr){
        if (root == null){
            return;
        }

        arr.add(root.data);
        if (root.left == null && root.right == null){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
            printPaths(root.left, arr);
            printPaths(root.right, arr);

        arr.remove(arr.remove(arr.size()-1));
    }

    public static void main(String args[]) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
//        root = delete(root,8 );
//        inOrder(root);

//        printInRange(root, 4,12);
        printPaths(root, new ArrayList<Integer>());
    }


}
