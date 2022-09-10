import javax.swing.*;
import java.util.Stack;

public class StackClass2 {

    public static void addAtLast(Stack<Integer> s, int data){
        if (s.empty()){
            s.push(data);
            return;
        }
        int val = s.pop();
        addAtLast(s, data);
        s.push(val);

    }

    public static void reverse(Stack<Integer> s){
                if (s.empty()){
                    return;
                }
                int top = s.pop();
                reverse(s);
                addAtLast(s, top);


//        while(!s.empty()){
//            System.out.println(s.pop());

//        while(!s.empty()){
//            int top = s.pop();
//            int topMinus1 = s.pop();
//            s.push(top);
//            s.push(topMinus1);

    }

    public static void main(String arg[]){
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(6);
        s.push(5);
        addAtLast(s, 8);
        reverse(s);
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
}
