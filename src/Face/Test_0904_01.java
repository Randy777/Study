package Face;

public class Test_0904_01 {

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w-we";
        int K = 4;
        System.out.println(licenseKeyFormatting(s, K));
    }

    public static String licenseKeyFormatting(String S, int K) {

        String target = "";
        String[] split = S.split("-");
        String str = "";
        for (String s : split){
//            System.out.println(s);
            str += s;
        }
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i-- ){
//            chars[i] =  '97' <= chars[i] <= '123' ? chars[i] - 32 : chars[i];
                if (((chars.length - i) % K == 0) && i != (chars.length - 1) && i != 0){
                    target +=  chars[i] + "-";
                }else {
                    target += chars[i];
                }
        }
        return target;
    }
}
