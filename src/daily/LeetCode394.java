package daily;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 0:48,A:65,a:97
 * */
public class LeetCode394 {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        char[] t = s.toCharArray();
        Queue<String> queueNum = new LinkedList<String>();
        int indexStart = 0;
        int indexEnd = 0;
        String temp ;
        String result = "";
        String str;
        for (int i = 0; i < t.length; i++){
            if (t[i] >= 48 && t[i] <= 57){
                queueNum.add(String.valueOf(t[i]));
            }
            if (t[i] == 91){
                indexStart = i;
            }
            if (t[i] == 93){
                str = "";
                temp = "";
                indexEnd = i;
                while (!queueNum.isEmpty()){
                    temp += queueNum.poll();
                }
                for (int k = indexStart + 1; k <= indexEnd - 1; k++){
                    str += String.valueOf(t[k]);
                }
                for (int j = 0; j < Integer.valueOf(temp); j++){
                    result += str;
                }
            }
        }
        return result;
    }
}
