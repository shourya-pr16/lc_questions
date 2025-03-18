package strings;

import java.util.HashSet;
import java.util.Set;

public class BinaryCodesOfSizeK {
    /*
    * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
    * */

    public static boolean hasAllCodes(String s, int k) {
        int totalDistinct = (int) Math.pow(2,k);
        Set<String> distinct = new HashSet<>();
        for(int i = 0; i < s.length() - k + 1; i++) {
            distinct.add(s.substring(i, i+k));
        }
        return totalDistinct == distinct.size();
    }

    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110", 2));
    }
}
