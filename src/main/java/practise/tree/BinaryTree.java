package practise.tree;


import java.util.LinkedList;
import java.util.Queue;

//create a tree using a preorder sequence
public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeTest {
        static int index = -1;

        public Node buildTree(int[] nodes) {
            if (nodes == null) {
                return null;
            }
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
//                if (q.isEmpty()){
//                    break;
//                } else {
//                    q.add(null);
//                }
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }

    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int ht = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(ht, Math.max(rightDia, leftDia));
    }

    public static class TreeInfo {
        int diameter;
        int height;

        TreeInfo(int d, int h) {
            this.diameter = d;
            this.height = h;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTreeDia = diameter2(root.left);
        TreeInfo rightTreeDia = diameter2(root.right);
        int currentHt = Math.max(leftTreeDia.height, rightTreeDia.height) + 1;
        int diamter3 = leftTreeDia.height + rightTreeDia.height + 1;
        return new TreeInfo(Math.max(diamter3, Math.max(leftTreeDia.diameter, rightTreeDia.diameter)), currentHt);
    }

    public static int sumAtKthLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Node current = queue.remove();
                if (level == k) {
//                     System.out.print(current.data + " ");
                    sum += current.data;
                } else {
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }
            }
            level++;
            if (level > k) {
                break;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        BinaryTreeTest t = new BinaryTreeTest();
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1};
        Node root = t.buildTree(nodes);
//        System.out.println(root.data);
//        preOrderTraversal(root);
//        inOrder(root);
//        postOrder(root);
//        levelOrder(root);
//        System.out.print(countNodes(root));
//        System.out.print(sumOfNodes(root));
//        System.out.print(heightOfTree(root));

//        System.out.print(diameter(root));
//        System.out.print(diameter2(root).diameter);

        System.out.print(sumAtKthLevel(root, 4));
    }
}
