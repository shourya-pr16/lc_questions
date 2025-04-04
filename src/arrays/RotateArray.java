package arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int t = nums[end];
            nums[end] = nums[start];
            nums[start] = t;
            start++; end--;
        }
    }
}
