package strings;

public class LongestBeautifulSubstring {

    /*
    *  https://leetcode.com/problems/longest-substring-of-all-vowels-in-order
    * */
    public static int longestBeautifulSubstring(String word) {
        int lastVisited = -1, max = 0, currentMax = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' && (lastVisited == -1 || lastVisited == 0)) {
                lastVisited = 0;
                currentMax++;
            } else if (word.charAt(i) == 'e' && (lastVisited == 0 || lastVisited == 1)) {
                currentMax++;
                lastVisited = 1;
            } else if (word.charAt(i) == 'i' && (lastVisited == 1 || lastVisited == 2)) {
                lastVisited = 2;
                currentMax++;
            } else if (word.charAt(i) == 'o' && (lastVisited == 2 || lastVisited == 3)) {
                lastVisited = 3;
                currentMax++;
            } else if (word.charAt(i) == 'u' && (lastVisited == 3 || lastVisited == 4)) {
                currentMax++;
                lastVisited = 4;
                max = Math.max(max, currentMax);
            } else {
                if(word.charAt(i) == 'a') {
                    lastVisited = 0;
                    currentMax = 1;
                } else {
                    lastVisited = -1;
                    currentMax = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaeiou"));
    }
}
