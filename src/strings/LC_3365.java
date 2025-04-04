package strings;

import java.util.HashMap;
import java.util.Map;

public class LC_3365 {
    public static boolean isPossibleToRearrange(String s, String t, int k) {
        String[] beginTokens = splitInTokens(s,k);
        String[] targetTokens = splitInTokens(t,k);

        Map<String, Integer> count = new HashMap<>();
        for(int i = 0; i < beginTokens.length; i++) {
            count.put(beginTokens[i], count.getOrDefault(beginTokens[i], 0)+1);
            count.put(targetTokens[i], count.getOrDefault(targetTokens[i], 0)-1);
        }
        return count.entrySet().stream().noneMatch(entry -> entry.getValue() != 0);
    }

    private static String[] splitInTokens(String s, int k) {
        int n = s.length()/k;
        String[] tokens = new String[k];
        int idx = 0;
        for(int i = 0; i <= s.length() - n; i = i+n, idx++) {
            tokens[idx] = s.substring(i, i+n);
        }
        return tokens;
    }

    public static void main(String[] args) {
        System.out.println(isPossibleToRearrange("abcd", "cdab", 2));
    }
}
