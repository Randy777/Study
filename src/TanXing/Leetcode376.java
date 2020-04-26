package TanXing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode376 {
    public static void main(String[] args) {
        int[] ints = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
        System.out.println(wiggleMaxLength(ints));
    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 1 || nums.length == 0){
            return nums.length;
        }
        List<Integer> asList = new ArrayList<>(nums.length);
        for (int num : nums){
            asList.add(num);
        }
//        Collections.addAll(asList,nums);
        int temp = 0,temp1 = 0;
        for (int i = 0; i < asList.size(); i++){
            if (asList.get(0) == asList.get(1)){
                asList.remove(1);
            }
        }
        for (int i = 1; i < asList.size() - 1; i++){
            temp = asList.get(i) - asList.get(i - 1);
            temp1 = asList.get(i + 1) - asList.get(i);
            if (temp * temp1 >= 0){
                asList.remove(i);
                i--;
            }
        }
        return asList.size();
    }
}
