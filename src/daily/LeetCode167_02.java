package daily;

public class LeetCode167_02 {
    public static void main(String[] args) {
        int[] num = {2,3,4};
        int target = 6;
        System.out.println(twoSum(num, target).length);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length ;
        int[] res = new int[2];
        for (int left = 0,right = n - 1; left < n;){
            if (numbers[left] + numbers[right] > target){
                right--;
            }else if (numbers[left] + numbers[right] < target){
                left++;
            }else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }
}
