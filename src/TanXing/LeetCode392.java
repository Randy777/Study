package TanXing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode392 {


    public static void main(String[] args) {
        String b = "ase";
        String a = "adasfasf";
        System.out.println(isSubsequence(b, a));
    }
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()){
            return true;
        }
        char[] b = s.toCharArray();
        char[] a = t.toCharArray();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0,j = 0; i < a.length; i++){
            if (b[j] == a[i]){
                j++;
                count++;
            }
            if (count == b.length){
                break;
            }
        }
        return count == b.length;
    }
}
