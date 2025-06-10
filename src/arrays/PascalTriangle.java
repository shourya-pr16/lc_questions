package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> pascalTrianle(int rows) {
        int[][] nums = new int[rows][];
        if (rows >= 1) nums[0] = new int[]{1};
        if (rows >= 2) nums[1] = new int[]{1, 1};

        int rowIdx = 2;
        while (rowIdx < rows) {
            int[] arr = new int[rowIdx + 1];
            arr[0] = 1;
            arr[arr.length - 1] = 1;
            for (int i = 1; i <= arr.length - 2; i++) {

                arr[i] = nums[rowIdx - 1][i] + nums[rowIdx - 1][i - 1];

            }
            nums[rowIdx] = arr;
            rowIdx++;
        }


        List<List<Integer>> val = new ArrayList<>();
        for(int[] num : nums) {
            val.add(Arrays.stream(num).boxed().toList());
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(pascalTrianle(1));
    }
}
