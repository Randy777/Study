package daily;

public class LeetCode985 {
    public static void main(String[] args) {
        int[] t = {1,2,3,4};
        int[][] a = {{1,0},{-3,1},{-4,0},{2,3}};
        sumEvenAfterQueries(t,a);
    }
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int res = 0;
        int temp;
        int[] result = new int[queries.length];
        for(int j = 0; j < queries.length; j++){
            if(A[j] % 2 == 0){
                res += A[j];
            }
        }
        for(int i = 0; i < queries.length; i++){
            temp = A[queries[i][1]];
            A[queries[i][1]] =  A[queries[i][1]] + queries[i][0];
            if (temp % 2 == 0 && A[queries[i][1]] % 2 == 0){
                res = res - temp + A[queries[i][1]];
            }else if (temp % 2 == 0 && A[queries[i][1]] % 2 != 0){
                res = res - temp;
            }else if (temp % 2 != 0 && A[queries[i][1]] % 2 == 0){
                res = res + A[queries[i][1]];
            }
            result[i] = res;
        }
        return result;
    }
}
