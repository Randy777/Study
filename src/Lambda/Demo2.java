package Lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zy
 * @date 2019-11-29
 * @description
 *     1.利用filter对null和空字符串进行过滤
 *     2.利用map进行对于Stream中包含的元素使用给定的转换函数进行转换操作
 *     3.collect进行聚合成map
 * 函数式编程概念map,它允许你将对象进行转换。
 *  reduce() 函数可以将所有值合并成一个。
 * */
public class Demo2 {
    public static void main(String[] args) {
        Map<String,Object> params = new HashMap<>(16);

        params.put("a","");
        params.put("b",null);
        params.put("c","c");

        params = parseMapForFilter(params);
        System.out.println(params);
        System.out.println(parseMapForFilter(null));
    }

    public static Map<String, Object> parseMapForFilter(Map<String, Object> map) {
        if (map == null) {
            return null;
        } else {
            map = map.entrySet().stream()
                    .filter((e) -> checkValue(e.getValue()))
                    .collect(Collectors.toMap(
                            (e) -> (String) e.getKey(),
                            (e) -> e.getValue()
                    ));
        }
        return map;
    }

    private static boolean checkValue(Object object) {
        if (object instanceof String && "".equals(object)) {
            return false;
        }
        if (null == object) {
            return false;
        }
        return true;
    }
}
