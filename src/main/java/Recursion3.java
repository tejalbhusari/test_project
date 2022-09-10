import sun.lwawt.macosx.CSystemTray;
import sun.net.www.protocol.file.FileURLConnection;

import java.util.HashSet;

//reverse a String
public class Recursion3 {

    public static int first = -1;
    public static int last = -1;
    public static boolean[] map =new boolean[26];
    public static void reverse(String s, int index){
        if (index ==0){
            System.out.println(s.charAt(index));
            return;
        }
        System.out.print(s.charAt(index));
        reverse(s, index-1);

    }

    public static void getOccurrence(String s, int index, char c){
        if (index ==(s.length())){
            return;
        }
        if (c == s.charAt(index)){
            if (first == -1){
                first = index;
//                System.out.println("first ooc " + first);
            }else {
                last =index;
            }
        }
        getOccurrence(s,index +1, c);
        if (last != -1){
//            System.out.println("last ooc " + last);
        }

    }

    public static void moveAllx(String s, int pos, int count, String newString){
        if (pos == s.length()){
            for (int i =0; i< count; i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        if (s.charAt(pos) =='x'){
            count ++;
            moveAllx(s,pos+1 , count, newString);
        } else {
            newString+= s.charAt(pos);
            moveAllx(s,pos+1 , count, newString);
        }
    }

    public static void removeDuplicates(String s, int pos, String newString){
        if (pos == s.length()){
            System.out.println(newString);
            return;
        }
        if (map[(s.charAt(pos)-'a')]){
//            System.out.println("inside if");
            removeDuplicates(s, pos +1, newString);
        }else {
            newString += s.charAt(pos);
            map[(s.charAt(pos)-'a')] = true;
//            System.out.println("inside else " + map[(s.charAt(pos)-'a')] );
            removeDuplicates(s, pos +1, newString);
        }

    }

    public static void getSeq(String s, int pos, String newStr, HashSet<String>h ){
        if (pos == s.length()){
            if(h.contains(newStr)){
                return;
            }else {
                h.add(newStr);
                System.out.println(newStr);
                return;
            }
        }
        getSeq(s, pos+1, newStr + s.charAt(pos),h);
        getSeq(s, pos+1, newStr,h);

    }

    public static void permutation(String s, String com){
        if (s.length() == 0){
            System.out.println(com);
        }

        for (int i =0; i< s.length(); i++){
            String s1 = s.replace((String.valueOf(s.charAt(i))),"");
            permutation(s1,  com +s.charAt(i));

        }
    }


    public static int countPaths(int i, int j, int n, int m){
        if (i ==n || j ==m){
//            System.out.println("(" + i + ", " + j + ")");
            return 0;
        }
        if (i == n-1 && j== m-1){
//            System.out.println("(" + i + ", " + j + ")");
            return 1;
        }
        System.out.println("(" + i + ", " + j + ")");
        int downPaths = countPaths(i+1, j, n, m);
        int rightPaths = countPaths(i, j+1, n, m);
        System.out.println(downPaths + "\t"+ rightPaths);
        return downPaths +rightPaths;
    }

    public static int placeTiles(int n, int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int verticalWays= placeTiles(n-m, m);
        int horizontalWays = placeTiles(n-1, m);
        return verticalWays+ horizontalWays;

    }

    public static void  main(String args[]){
//        String s = "ababnalashadiailak";
//        reverse(s, s.length()-1);
//        getOccurrence(s,0, 'a');
//        System.out.println("first ooc " + first);
//        System.out.println("last ooc " + last);
//        String s = "abc";
//        moveAllx(s, 0, 0, "");
//        removeDuplicates(s, 0, "");

//        HashSet<String> h = new HashSet<>();
//        getSeq(s,0,"", h);

//        permutation(s,"");

//        int n = 3,  m = 3;
//        System.out.println(countPaths(0,0,n,m));

        int n= 4, m=2;
        System.out.println(placeTiles(n,m));
    }
}
