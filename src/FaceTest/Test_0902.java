package FaceTest;

public class Test_0902 {
    public static void main(String[] args) {
        int[] arr1 = {0};
        int[] arr2 = {1,1};
        System.out.println(addNegabinary(arr1, arr2));
    }
    public static int[] addNegabinary(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;
        int len = Math.max(m,n);
        int len2 = Math.min(m,n);

        int[] array1 = new int[len];
        int[] array2 = new int[len2];

        array1 = m >= n ? arr1 : arr2;
        array2 = m >= n ? arr2 : arr1;

        int[] arr3 = new int[len];
        for(int i = 0,j = 0; i < len; i++,j++){
            if((len - i) % 2 == 0){
                arr3[len - 1 - i] = len2 > i ? array1[len - 1 - i] & array2[len2 - 1 - j] : array1[len - 1 - i] & 0;
            }else{
                arr3[len - 1 - i] = len2 > i ? array1[len - 1 - i] ^ array2[len2 - 1 - j] : array1[len - 1 - i] ^ 0;
            }
        }
        return arr3;
    }

}
