import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String args[]) {
       int[][] arr = {{1,2},{3,4}, {5,6}};
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{3,4});
        list.add(new int[]{5,6});
        int[][] arr2 = list.toArray(new int[0][]);
        for(int i=0 ; i< arr2.length; i++){
            for (int j =0; j< arr2[i].length; j++)
            System.out.println(i + " " + arr2[i][j]);
        }

    }
}
