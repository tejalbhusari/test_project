public class CircularQueue {
    static class Queue{
        static int arr[];
        public static int size;
        public static int rear =-1;
        public static int front = -1;


        public Queue(int n){
            arr= new int[n];
            size = n;
        }

        public boolean isEmpty(){
            return (rear == -1) && (front == -1);
        }

        //enqueue
        public void add(int data){
            if ((rear +1)%size == front){
                System.out.println("Queue is full");
                return;
            }
            if (front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear]= data;
            return;

        }
        //dequeue
        public int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (rear == front){
                front = -1;
                rear = -1;
                return result;
            }
            front = (front +1)%size;
            return result;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]){
        QueueClass.Queue q= new QueueClass.Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.add(5);
        q.remove();
        q.add(6);
        q.remove();
        q.add(7);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
