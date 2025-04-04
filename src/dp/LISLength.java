package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LISLength {
    /*
    *  https://leetcode.com/problems/longest-increasing-subsequence/
    * */

    public static int lengthOfLIS(int[] nums) {
        int max = 1;
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for(int idx = nums.length - 2 ; idx >= 0; idx--) {
            int lis = 1 + lengthOfLIS(nums, idx, idx+1, dp);
            max = Math.max(max, lis);
        }
        return max;
    }

    public static int lengthOfLIS(int[] nums, int idx, int lastIdx, int[][] dp) {
        if(idx == 0) {
            if(nums[idx] < nums[lastIdx]) {
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[idx][lastIdx] != -1) {
            return dp[idx][lastIdx];
        }

        int take = 0;
        if(nums[idx] < nums[lastIdx]) {
            take = 1 + lengthOfLIS(nums, idx - 1, idx,dp);
        }
        int not_take = lengthOfLIS(nums, idx-1, lastIdx, dp);
        return dp[idx][lastIdx] = Math.max(take, not_take);
    }

    public static int lengthOfLISTabulated(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int[] d : dp) {
            Arrays.fill(d, 0);
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[0]) {
                dp[0][i] = 1;
            }
        }

        System.out.println("debug");
        for(int idx = 1 ; idx < nums.length; idx++) {
            for(int j = idx + 1; j < nums.length; j++) {
                int take = 0;
                if (nums[j] > nums[idx]) {
                    take = 1 + dp[idx - 1][j];
                }
                int not = dp[idx][j - 1];
                dp[idx][j] = Math.max(take, not);
            }
        }

        return dp[nums.length-1][nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLISTabulated(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLISTabulated(new int[]{7,7,7,7,7,7,7}));
    }
}
