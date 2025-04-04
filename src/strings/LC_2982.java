package strings;

public class LC_2982 {
    /*
    *  https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/description/
    * */

    public static int maximumLength(String s) {
        int maxL = -1;
        char[] str = s.toCharArray();

        int n = str.length;
        int[][] count = new int[26][n+1];

        count[str[0]-'a'][1] = 1;
        char last = str[0];
        int c = 1;

        for(int i = 1; i < n; i++) {
            if(last != str[i]) {
                c = 1;
                count[str[i]-'a'][1] += 1;
                last = str[i];
            } else {
                c++;
                for(int j = 1; j <= c; j++) {
                    count[str[i] - 'a'][j] += 1;
                }
            }
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 1; j <= str.length; j++) {
                if(count[i][j] >= 3) {
                    maxL = Math.max(maxL, j);
                }
            }
        }

        return maxL;
    }

    public static void main(String[] args) {
//        System.out.println(maximumLength("aaaa"));
        System.out.println(maximumLength("abcaba"));
//        System.out.println(maximumLength("abcdef"));
    }
}
