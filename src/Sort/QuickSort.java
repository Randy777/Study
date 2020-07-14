package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,9,5};
        quickSort(arr,0,arr.length - 1);
        for (int a : arr){
            System.out.println(a);
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        //i左，j右，temp基准，t
        int i,j,temp,t;
        i = low;
        j = high;
        if (low > high){
            return;
        }
        temp = arr[low];
        while (i < j){
            //右边，依次往左递减，找到比基准小的
            while (temp <= arr[j] && i < j){
                j--;
            }
            //左边，依次往右递增，找到比基准大的
            while (temp >= arr[i] && i < j){
                i++;
            }
            if (i < j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        // i = j 时，与基准调换
        arr[low] = arr[i];
        arr[i] = temp;
//        递归左边
        quickSort(arr,low,j - 1);
//        递归右边
        quickSort(arr,j + 1,high);
    }
}
