import java.util.ArrayList;
import java.util.Stack;

public class StackClass1 {

    public static class Stack{
        ArrayList<Integer> s = new ArrayList<>();

        public boolean isEmpty(){
            return s.size() == 0;
        }
         public void push(int data){
            s.add(data);
         }

        public int pop(){
            if (isEmpty()){
                return -1;
            }
            int data = s.get(s.size()-1);
            s.remove(s.size()-1);
            return data;
        }

        public int peek(){
            if (isEmpty()){
                return -1;
            }
            return s.get(s.size()-1);
        }

        public Stack addAtLast(Stack s, int data){
            if (s.isEmpty()){
                s.push(data);
                return s;
            }
            int val = s.pop();
            addAtLast(s, data);
            s.push(val);
            return s;
        }
    }


    public static void main(String args[]){
        Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(1);
        s.addAtLast(s, 4);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }


    }
}
