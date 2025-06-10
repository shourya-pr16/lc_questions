package arrays;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        insertionSort(new int[]{5,8,1,3,2});
    }

}
