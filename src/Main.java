import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String str = "1,1,1,1,1,1,1,";
        List<String> result = Arrays.asList(str.split(","));
        System.out.println(result.size());
        List<String> arrList = new ArrayList(result);
        arrList.add("");
        System.out.println(arrList.size());
        for (String s : arrList){
            System.out.println(s);
        }
    }
}
