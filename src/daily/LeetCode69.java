package daily;

public class LeetCode69 {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        int mid = 0,left = 0,right = x;
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        mid = x / 2;
        double t = 0,n = 0;
        t = mid * mid;
        n = (mid + 1) * (mid + 1);
        while(!(x > t && x < n)){
            if(x > t){
                mid = (mid + right) / 2;
            }else if(x < t){
                right = mid;
                mid = mid / 2;
            }else if(x == t){
                return mid;
            }
            t = mid * mid;
            n = (mid + 1) * (mid + 1);
        }
        return mid;
    }
}
