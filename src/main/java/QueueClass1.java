public class QueueClass1 {

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        boolean isEmpty(){
            return head == null && tail == null;
        }

        void add(int data){
            Node newNode = new Node(data);
            if(tail == null){
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        int remove(){
            if(isEmpty()){
                return -1;
            }
            if (head == tail){
                tail = null;
            }
            int front = head.data;
            head = head.next;
            return front;
        }

        int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
