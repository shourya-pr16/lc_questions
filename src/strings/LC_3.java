package strings;

import java.util.HashSet;
import java.util.Set;

public class LC_3 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int maxL = 1;

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(!chars.contains(s.charAt(j))) {
                    chars.add(s.charAt(j));
                    maxL = Math.max(chars.size(), maxL);
                } else {
                    maxL = Math.max(chars.size(), maxL);
                    chars.clear();
                    break;
                }
            }
        }
        return maxL;
    }

    public static int longestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 0;
        int low = 1, high = s.length();

        while (low <= high) {
            int mid = (low + high) >> 1;
            set.clear();
            boolean isPossible = isPossible(mid, set, s);
            if(isPossible) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int mid, Set<Character> set, String s) {
        int low = 0, high = 0;
        while (low <= high && high < s.length()) {
            if(!set.contains(s.charAt(high))) {
                set.add(s.charAt(high));
                high++;
                if(set.size() == mid) {
                    return true;
                }
            } else {
                set.remove(s.charAt(low));
                low++;
            }
        }
        return false;
    }

    public static int longestLinear(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int max = 0;

        int[] count = new int[26];
        int low = 0, high = 0;
        while (low <= high && high < s.length()) {
            if(count[s.charAt(high) - 'a'] == 0) {
                count[s.charAt(high) - 'a'] = 1;
                max = Math.max(max, high - low + 1);
                high++;
            } else {
                count[s.charAt(low) - 'a'] -= 1;
                low++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestLinear("pwwkew"));
    }
}
