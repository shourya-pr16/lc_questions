package dp;

public class EditDistance {

    /*
    * https://leetcode.com/problems/edit-distance/description/
    * */

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        return f(word1, word2, word1.length() -1, word2.length()-1, dp);
    }

    public static int f(String s1, String s2, int a, int b, int[][]dp) {
        if(a < 0) {
            return b+1;
        }
        if(b < 0) {
            return a+1;
        }

        if(dp[a][b] != 0) {
            return dp[a][b];
        }

        if(s1.charAt(a) == s2.charAt(b)) {
            return f(s1, s2, a-1, b-1, dp);
        }

        int add = 1 + f(s1, s2, a, b-1, dp);
        int del = 1 + f(s1, s2, a-1,b,dp);
        int update = 1 + f(s1, s2, a-1, b-1, dp);

        return dp[a][b] = Math.min(add, Math.min(update, del));
    }

    public static int minTab(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for(int i = 0; i <= s2.length(); i++) dp[0][i] = i;

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = 1 + dp[i][j - 1];
                    int del = 1 + dp[i - 1][j];
                    int upd = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(add, Math.min(del, upd));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        System.out.println(minTab("park", "spake"));
    }
}
