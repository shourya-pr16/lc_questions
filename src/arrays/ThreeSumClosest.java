package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length -2; i++) {
            int l = i+1, h = nums.length - 1;
            while ( l < h) {
                int currSum = nums[i]+nums[l]+nums[h];
                int diff = target - currSum;
                if(minDiff > Math.abs(diff)) {
                    minDiff = Math.abs(diff);
                    closestSum = currSum;
                }
                if(currSum < target) l++;
                else h--;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{10,20,30,40,50,60,70,80,90}, 1));
    }
}
