package Divide;

public class LeetCode240 {
    public static void main(String[] args) {
        int[][] ints = {{1,4,7,11,15,31},
                {2,5,8,12,19,32},
                {3,6,9,16,22,33},
                {10,13,14,17,24,34},
                {18,21,23,26,30,35}};
        int[][] ints1 = {{-1},{-1}};
        int[][] ints2 = {{1,3,5}};
        System.out.println(searchMatrix(ints,5));
        System.out.println(searchMatrix(ints1, 0));
        System.out.println(searchMatrix(ints2, 5));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length;
        if (n == 0){
            return false;
        }
        int[] ints = new int[Math.max(m,n)];
        if (m > n){
            for (int i = 0; i < m; i++){

                if (i >= n){
                    ints[i] = Integer.MAX_VALUE;
                }else {
                    ints[i] = matrix[i][i];
                }
            }
        }else if (m < n){
            for (int i = 0; i < n; i++){
                if (i >= m){
                    ints[i] = Integer.MAX_VALUE;
                }else {
                    ints[i] = matrix[i][i];
                }
            }
        }else {
            for (int i = 0; i < n; i++){
                ints[i] = matrix[i][i];
            }
        }
        for (int i = 0; i < ints.length; i++){
            if (ints[i] == target){
                return true;
            }
            if (ints[i] > target){
                if (m == n){
                    for (int j = 0; j < i; j++){
                        if (matrix[j][i] == target || matrix[i][j] == target){
                            return true;
                        }
                    }
                }else if (m > n){
                    for (int j = 0; j < i; j++){
                        if (ints[i] == Integer.MAX_VALUE){
                            if (matrix[i][j] == target){
                                return true;
                            }
                            continue;
                        }
                        if (matrix[j][i] == target || matrix[i][j] == target){
                            return true;
                        }
                    }
                }else {
                    for (int j = 0; j < i; j++){
                        if (ints[i] == Integer.MAX_VALUE){
                            if (matrix[j][i] == target){
                                return true;
                            }
                            continue;
                        }
                        if (matrix[j][i] == target || matrix[i][j] == target){
                            return true;
                        }
                    }
                }
                if (ints[i] == Integer.MAX_VALUE){
                    continue;
                }
                break;
            }
        }
        return false;
    }
}
