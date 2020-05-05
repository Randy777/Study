package daily;
/**
 * @date 2020-05-04
 *给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LeetCode45 {
    public static void main(String[] args) {
        int[] ints = {2};
        System.out.println(jump(ints));
    }
    public static int jump(int[] nums) {
        int count = 0;
        if (nums.length <= 1){
            return 0;
        }
        int index = nums.length - 1;
        return getResult(nums,count,index);
    }
    public static int getResult(int[] nums,int count,int index){
        if (index == 0){
            return count;
        }else {
            int temp = 0;
            for (int i = index -1; i >= 0; i--){
                if (i + nums[i] >= index){
                    temp = i;
                }
            }
            count++;
            return getResult(nums,count,temp);
        }
    }
}
