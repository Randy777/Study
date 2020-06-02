package daily;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
    public static void main(String[] args) {
        int[] ints = {1,1};
        int t = 1;
        kidsWithCandies(ints,t);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int temp = candies[0];
        List<Boolean> dp = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            temp = Math.max(temp,candies[i]);
        }
        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= temp){
                dp.add(true);
            }else{
                dp.add(false);
            }
        }
        return dp;
    }
}
