package strings;

import java.util.HashMap;
import java.util.Map;

public class IsInterleave {
    /*
    *  https://leetcode.com/problems/interleaving-string/description/
    * */

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();

        return isInterleave(s1, s1.length()-1, s2 , s2.length() -1, s3, s3.length()-1, memo);
    }

    public static boolean isInterleave(String s1, int s1Ptr, String s2, int s2Ptr,  String s3, int s3Ptr, Map<String, Boolean> memo) {
        String key = s1Ptr + "," + s2Ptr;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(s1Ptr == -1) {
            return s2.substring(0,s2Ptr+1).equals(s3.substring(0, s3Ptr+1));
        }

        if(s2Ptr == -1) {
            return s1.substring(0,s1Ptr+1).equals(s3.substring(0, s3Ptr+1));
        }


        if(s1.charAt(s1Ptr) != s3.charAt(s3Ptr) && s2.charAt(s2Ptr) != s3.charAt(s3Ptr)) {
            memo.put(key, false);
            return false;
        }

        boolean result;
        if(s3.charAt(s3Ptr) == s1.charAt(s1Ptr) && s3.charAt(s3Ptr) == s2.charAt(s2Ptr)) {
            result = (isInterleave(s1, s1Ptr-1, s2, s2Ptr, s3, s3Ptr-1, memo)
                    || isInterleave(s1, s1Ptr, s2, s2Ptr-1, s3, s3Ptr-1, memo));
        } else {
            result = s1.charAt(s1Ptr) == s3.charAt(s3Ptr) ? isInterleave(s1, s1Ptr-1, s2, s2Ptr, s3, s3Ptr-1, memo) :
                isInterleave(s1, s1Ptr, s2, s2Ptr-1, s3, s3Ptr-1, memo);
        }
        memo.put(key, result);
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("aabc", "abad", "aabadabc"));
    }
}
