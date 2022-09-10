import sun.lwawt.macosx.CSystemTray;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class TestClass {

    public static void bubbleSort(int arr[]){
        for (int i=0; i < arr.length-1; i++){
            for (int j =0 ; j < arr.length -1- i; j++){
                 if (arr[j] > arr[j+1]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
            }
        }
        for(int i : arr){
            System.out.print(i + "\t");
        }
    }

    public static void main(String args[]){

        int arr[] = {1,8,7,5,20,6,9,3};
        System.out.print("input array : ");
        for(int i : arr){
            System.out.print(i + " \t");
        }
        System.out.print("\n");
        bubbleSort(arr);



//        //bit masking
//
//        int a = 5;
//        int pos = 2;
//        int bitmask = 1 <<pos;
//        int result = bitmask & a;
//        if (result == 0){
//            System.out.println("bit is 0");
//        }
//        else {
//            System.out.println("bit is 1")  ;
//        }
//
//        bitmask = 1<<1;
//        result = bitmask | a;
//        System.out.println(result);
//
//        bitmask = 1<<2;
//        bitmask = ~(bitmask);
//        result = bitmask & a;
//        System.out.println(result);

    }
}
