package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_368 {

    public static List<Integer> f(int idx, int[] nums, List<Integer> current) {
        if(idx < 0) return new ArrayList<>(current);

        boolean include = true;
        for(int n : current) {
            if(n % nums[idx] != 0) {
                include = false;
                break;
            }
        }
        List<Integer> includeList = Collections.emptyList();
        if(include) {
            current.add(nums[idx]);
            includeList = f(idx - 1, nums, current);
            current.removeLast();
        }

        List<Integer> notInclude = f(idx - 1, nums, current);
        return includeList.size() >= notInclude.size() ? includeList : notInclude;
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        return f(nums.length - 1, nums, current).reversed();
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
    }
}
