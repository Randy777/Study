package Sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LeetCode179 {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        System.out.println(largestNumber(array));
    }

    public static String largestNumber(int[] nums) {
        Arrays.sort(nums);
//        System.out.println("");
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        int count = 1;
        for (int i = 1; i <= nums[nums.length-1]; i *= 10){
            count *= 10;
        }
        count = count / 10;
        for (int j = 0; j < nums.length; j++){
            map.put(nums[j],getNum(nums[j],count));
//            System.out.print(map.get(nums[j]) + "-");
        }
//        System.out.println("");
        Map<Integer,Integer> map1 = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (oldValue,newValue) -> oldValue,LinkedHashMap::new));
        String result = "";
        for (Integer key : map1.keySet()){
            result += key;
        }
        return result;
    }

    private static Integer getNum(int num, int count) {
        if (num < count){
            return getNum(num * 10 + num % 10, count);
        }
        return num;
    }

}
