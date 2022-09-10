public class Recursion {


//    public static  int  printN(int n){
//        if (n==0){
//            System.out.print(n + "\t ");
//            return 0;
//        }
//        int sum = n +  printN(n-1);
//        System.out.print(n + "\t");
//
//        int num =  + printN(n+1);
//
//
//    }

    public static int printFact(int n, int counter){
         if (counter == 0){
             return 1;
         }
         if (n ==0 ){
             return 1;
         }
         if (counter%2 == 0){
             return printFact(n, counter/2) * printFact(n, counter/2);
         }
         else
         {  return printFact(n, counter/2) * printFact(n, counter/2) * n;}
         }

    public static void main(String args[]){
        int x = 2;
        int n = 4;
        int sum = printFact(x, n);
        System.out.print(sum);
    }
}
