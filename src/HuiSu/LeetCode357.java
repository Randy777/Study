package HuiSu;

public class LeetCode357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10, k = 9, temp = 9;
        for (int i = 2; i <= Math.min(n, 10); ++i){
            temp *= k;
            k--;
            res += temp;
        }
        return res;
    }
}
