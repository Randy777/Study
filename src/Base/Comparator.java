package Base;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Randy
 * @date 19点43分
 * 比较器Comparator
 */
public class Comparator {

    public static class Node {
        private int num;
        private String val;

        public Node(int num, String val) {
            this.num = num;
            this.val = val;
        }

    }


//    public static void main(String[] args) {
//        //ArrayList<Node> list = new ArrayList<>();
//        LinkedList<Node> list = new LinkedList<>();
//        list.add(new Node(5, "aa"));
//        list.add(new Node(10, "aa"));
//        list.add(new Node(6, "aa"));
//        list.add(new Node(7, "aa"));
//        list.add(new Node(8, "aa"));
//        list.add(new Node(9, "aa"));
//        list.add(new Node(10, "aa"));
//        list.add(new Node(11, "aa"));
//        list.add(new Node(5, "aa"));
//        System.out.print("原序");
//        for (Node c : list) {
//            System.out.print(c.num + c.val + " ");
//        }
//        System.out.println();
//
//        Node[] b = list.toArray(new Node[list.size()]);
//        /** return 0 -- 原序**/
//        Arrays.sort(b, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return 0;
//            }
//        });
//        System.out.print("原序");
//        for (Node c : b) {
//            System.out.print(c.num + c.val + " ");
//        }
//        System.out.println();
//
//        Node[] b1 = list.toArray(new Node[list.size()]);
//        /** return -1 -- 反序**/
//        Arrays.sort(b1, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return -1;
//            }
//        });
//        System.out.print("反序");
//        for (Node c1 : b1) {
//            System.out.print(c1.num + c1.val + " ");
//        }
//        System.out.println();
//
//        Node[] b2 = list.toArray(new Node[list.size()]);
//        /** return 1 -- 原序**/
//        Arrays.sort(b2, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return 1;
//            }
//        });
//        System.out.print("原序");
//        for (Node c2 : b2) {
//            System.out.print(c2.num + c2.val + " ");
//        }
//        System.out.println();
//
//        Node[] b3 = list.toArray(new Node[list.size()]);
//        /** return o1.num - o2.num-- 字典升序**/
//        Arrays.sort(b3, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.num - o2.num;
//            }
//        });
//        System.out.print("字典升序");
//        for (Node c3 : b3) {
//            System.out.print(c3.num + c3.val + " ");
//        }
//        System.out.println();
//
//        Node[] b5 = list.toArray(new Node[list.size()]);
//        /** return o2.num - o1.num-- 字典降序**/
//        Arrays.sort(b5, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o2.num - o1.num;
//            }
//        });
//        System.out.print("字典降序");
//        for (Node c5 : b5) {
//            System.out.print(c5.num + c5.val + " ");
//        }
//        System.out.println();
//
//
//        Node[] b6 = list.toArray(new Node[list.size()]);
//        /**  Integer n1 = o1.num;
//         Integer n2 = o2.num;
//         return n1.compareTo(n2);
//         -- 字典升序
//         **/
//        Arrays.sort(b6, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                //Integer n1 = o1.num;
////                Integer n2 = o2.num;
////                return n1.compareTo(n2);
//                /**自动封装在这里没有起作用**/
//                return ((Integer) o1.num).compareTo((Integer) o2.num);
//            }
//        });
//        System.out.print("字典升序");
//        for (Node c6 : b6) {
//            System.out.print(c6.num + c6.val + " ");
//        }
//        System.out.println();
//
//
//        Node[] b7 = list.toArray(new Node[list.size()]);
//        /** Integer n1 = o1.num;
//         Integer n2 = o2.num;
//         return n2.compareTo(n1);
//         -- 字典降序**/
//        Arrays.sort(b7, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
////                Integer n1 = o1.num;
////                Integer n2 = o2.num;
////                return n2.compareTo(n1);
//                /**自动封装在这里没有起作用**/
//                return ((Integer) o2.num).compareTo((Integer) o1.num);
//            }
//        });
//        System.out.print("字典降序");
//        for (Node c7 : b7) {
//            System.out.print(c7.num + c7.val + " ");
//        }
//        System.out.println();
//
//    }

}
