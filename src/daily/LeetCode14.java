package daily;

import java.util.ArrayList;
import java.util.List;

/**
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 2){
            return "";
        }
        int index = strs[0].toCharArray().length;
        for (int i = 1; i < strs.length; i++){
            strs[i].toCharArray();
            for (int j = 0; j <= index; j++){
                System.out.println(strs[j]);
            }
        }
        return "";
    }
}
