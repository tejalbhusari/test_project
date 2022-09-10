import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    static int inv = 0;

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }

    static int merge(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] * 0.5 > nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int k = low; k <= high; k++) {
            nums[k] = temp.get(k - low);
        }
        return count;
    }


    public static void main(String[] args) {
        int arr1[] = new int[]{2,4,3,5,1};

        System.out.println(reversePairs(arr1));


    }
}