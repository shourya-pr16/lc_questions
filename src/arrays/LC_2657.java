package arrays;

import java.util.Arrays;

public class LC_2657 {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        int maxCommon = res.length;
        res[A.length-1] = maxCommon;

        for(int i = A.length-1; i > 0; i--) {
            if(A[i] == B[i]) {
                maxCommon--;
            } else {
                maxCommon-=2;
            }
            res[i-1] = Math.max(maxCommon, 0);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4}));
        System.out.println(findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2}));
    }
}
