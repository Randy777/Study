package Sort;

import java.util.Arrays;

/**
* 有效的字母异位词
 * AC
* */
public class LeetCode242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean b =  isAnagram(s,t);
        System.out.println(b);
    }


    private static boolean isAnagram(String s, String t) {
        if ( s.length() == t.length()){
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);

            for (int i = 0; i < charS.length; i++){
                if (charS[i] != charT[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
