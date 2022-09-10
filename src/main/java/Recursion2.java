public class Recursion2 {

    public static void towerOfHanoi(int n , String src, String helper, String dest, int counter){
        counter++;
        if (n ==1){
            System.out.println("Transfer disk "+ n + " from "+ src + " " +  dest );
            return;
        }
        towerOfHanoi(n-1, src, dest, helper, counter);
        System.out.println("Transfer disk "+ n + " from "+ src + " " +  dest);
        towerOfHanoi(n-1, helper, src, dest, counter);
        System.out.println("  counter " + counter);

    }

    public static void  main(String args[]){
        int n= 5, counter =0;
        towerOfHanoi(n, "Source", "Helper", "Destination", counter);
    }
}
