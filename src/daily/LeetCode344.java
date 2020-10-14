package daily;

public class LeetCode344 {
    public static void main(String[] args) {
        char[] s= {'h','e','l','l','o'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        int n = s.length;
        if (n < 2) return;
//        char[] chars = new char[n];
        char temp = 'A';
        for (int i = 0,j = n - 1; i < (n / 2); i++){
            if (j - i > i){
                temp = s[i];
                s[i] = s[j - i];
                s[j - i] = temp;
            }
        }
//        return s;
    }
}
