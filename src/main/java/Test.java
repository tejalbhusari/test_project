import java.util.Arrays;

public class Test {

    public static void main(String args[]) {
        int[] arr = new int[8];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        for (int i=0 ; i < arr.length-1; i++){
            arr[i+1] = 1- arr[i];
            System.out.println(arr[i]);
        }
    }
}
