package strings;

public class LC_3223 {
    public static int minimumLength(String s) {
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
            if((chars[s.charAt(i) - 'a'] & 1) == 1) chars[s.charAt(i) - 'a'] = 1;
            else chars[s.charAt(i) - 'a'] = 2;
        }
        int len = 0;
        for(int v : chars) len+=v;
        return len;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
    }
}
