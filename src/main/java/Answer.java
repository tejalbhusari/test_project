public class Answer {


    public void sortTheBalls(int[] arr){
        int low ,mid ;
        low = mid = 0;
        int high = arr.length-1;

        while(mid <= high){
            System.out.println(mid);
            switch(arr[mid]){
                case 0:
                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    mid++;
                    low++;
                    break;

                case 1 :
                    mid++;
                    break;

                case 2 :
                    int tmp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = tmp;
                    high--;
                    break;

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        int arr[] = new int[]{0,1,0,1,2,0,0,2,1,2};

        Answer ans = new Answer();
        ans.sortTheBalls(arr);
    }
}
