package strings;

import java.util.HashMap;
import java.util.Map;

public class LC_2131 {

    public static int longestSpaceOptimized(String[] words) {
        int[][] base = new int[26][26];
        int pairs = 0;
        for(String word : words) {
            int first = word.charAt(0)-'a';
            int second = word.charAt(1)-'a';
            if(base[first][second] > 0) {
                base[first][second]--;
                pairs+=2;
            } else {
                base[second][first]++;
            }
        }

        int extra = 0;
        for(int i = 0; i<26; i++) {
            if(base[i][i] > 0) {
                extra++;
                break;
            }
        }

        return (pairs+extra)*2;
    }

    public static int longestPalindrome(String[] words) {
        Map<String , Integer> map = new HashMap<>();
        String reverse = "";
        int pairs = 0;
        for(String word : words) {
            reverse = reverse + word.charAt(1) + word.charAt(0);
            if(map.containsKey(word)) {
                if(map.get(word) == 1) map.remove(word);
                else map.put(word, map.get(word)-1);
                pairs+=2;
            } else {
                map.put(reverse, map.getOrDefault(reverse,0)+1);
            }
            reverse = "";
        }

        int additionalPair = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getKey().charAt(1) == entry.getKey().charAt(0)) {
                additionalPair++;
                break;
            }
        }

        return (pairs+additionalPair)*2;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));
//        System.out.println(longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
//        System.out.println(longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println(longestSpaceOptimized(new String[]{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"}));
    }
}
