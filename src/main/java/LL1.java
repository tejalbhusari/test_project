import java.util.Arrays;

public class LL1 {

    public static Node head;
    static int size = 0;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }

    }

    public void add(String data){
        Node n1 = new Node(data);
        size++;
        if (head == null){
            head = n1;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next ;
        }
        temp.next = n1;
    }

    public void reverse(){
        Node prev = head;
        Node current = head.next;
        prev.next = null;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverseRecursive(Node head){
        if (head == null || head.next == null){
            System.out.println(head.data);
            return head;
        }
        System.out.println("--" + head.data);
       Node newNode = reverseRecursive( head.next);
        System.out.println(newNode.data+ "#");
        System.out.println(head.data + "--");
       head.next.next = head;
       head.next = null;
       return newNode;
    }


    public static void deleteNthFromLast(Node head){

    }

    public static void main(String args[]){
        LL1 list = new LL1();
//        list.addAll(Arrays.asList("1", "2", "3", "4", "5"));
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL" + "\n");
//        list.reverse();
        temp = list.reverseRecursive(head);
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }




    }
}
