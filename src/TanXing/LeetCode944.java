package TanXing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode944 {
    public static void main(String[] args) {
        String[] strings = {"adfasdc","adsfasdf"};
        minDeletionSize(strings);
    }
    public static int minDeletionSize(String[] A) {
        List<char[]> chars = new ArrayList<>();
        for (String s : A){
            chars.add(s.toCharArray());
        }
        for (int i = 0; i < chars.get(0).length; i++){

        }
        return 1;
    }
}
