import sun.lwawt.macosx.CSystemTray;

import java.beans.IntrospectionException;
import java.util.Stack;

public class Ans2 {

    public void insertElement(Stack<Integer> stack, int a){

        if (stack.isEmpty() || a > stack.peek()){
            stack.push(a);
            return;
        }
        int temp = stack.pop();
        insertElement(stack, a);
        stack.push(temp);
    }

    public void sort(Stack<Integer> stack){
       if(stack.empty()){
           return;
       }
       int i = stack.pop();

       sort(stack);
       insertElement(stack, i);
       }


    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(-1);
        stack.push(5);
        stack.push(1);
        stack.push(3);

        Ans2 ans2 = new Ans2();
        ans2.sort(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }



    }
}
