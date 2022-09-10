import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LL {

    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.addAll(Arrays.asList("8","9", "10"));
//        String e = list.getFirst();
//        String e1 = list.getLast();
//        String e2 = list.get(1);
//        System.out.println(e + " " + e1 + " " + e2  );
//        System.out.println(list);
//        System.out.println(list.size());
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list);
//        String prev = null;
//        String current = null;
//        String next = null;
        Collections.reverse(list);
        for(String i: list){
            System.out.println(i);
        }
//        list.re
    }
}
