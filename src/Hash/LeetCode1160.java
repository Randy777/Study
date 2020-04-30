package Hash;

import java.util.Arrays;

public class LeetCode1160 {
    public static void main(String[] args) {
        String[] strings = {"cat","bt","hat","tree"};
        String string = "atach";
        countCharacters(strings,string);
    }
    public static int countCharacters(String[] words, String chars) {
        Arrays.sort(chars.toCharArray());
        for (String s : words){
            s.toCharArray();
        }
        return 1;
    }
}
