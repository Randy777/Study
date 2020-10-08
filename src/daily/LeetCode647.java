package daily;
/***
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class LeetCode647 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++){
            dp[i] = dp[i - 1] + strBack(chars,0,i);
        }
        return 1;
    }
    public static int strBack(char[] s,int start,int end){
        int count = 1;
        for (int i = end - 1; i >= 0; i--){
            if (s[i] == s[end]){
                count ++;
            }
        }
        return 1;
    }
}
