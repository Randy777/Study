package JPointOffer;
/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class offer05 {
    public static void main(String[] args) {
        String s = "This is a function";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
//        s.replaceAll(" ","20%");
        s.replace("","20%");
        System.out.println(s);
        return s;
    }
}
