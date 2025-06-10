package dp;

public class LC_416 {

    public static boolean f(int i, int[] nums, int sum, Boolean[] dp) {
        if(sum == 0) return true;
        if(sum < 0 || i < 0) return false;
        if(dp[i] != null) {
            return dp[i];
        }
        return dp[i] = f(i-1, nums, sum-nums[i], dp) | f(i-1 , nums, sum, dp);

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length][target+1];

        for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= target; j++ ) {
                boolean not = dp[i-1][j];
                boolean take = false;
                if(nums[i] < j) take = dp[i-1][j-nums[i]];
                dp[i][j] = take | not;
            }
        }

        return dp[nums.length-1][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
