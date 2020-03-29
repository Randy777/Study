package Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public static void main(String[] args) throws IOException {

            int[][] intervals = new int[3][2];
            for (int i = 0; i< 3; i++){
                for (int j = 0; j < 2; j++){
                    intervals[i][j] = 3 * i + j;
                }
            }

            int[][] ret = new LeetCode56().merge(intervals);
            System.out.print(ret);
        }

    public int[][] merge(int[][] intervals) {

        List<int[]> array = new ArrayList<>();
        if (intervals.length ==0 || intervals == null){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1 == o2 ? o1[1] - o2[1] : o1[0] - o2[0] ;
            }
        });
        array.add(intervals[0]);
        for (int i = 0; i<intervals.length; i++){
            if (array.get(array.size()-1)[1] >= intervals[i][0]){
                array.get(array.size()-1)[1] = Math.max(array.get(array.size()-1)[1],intervals[i][1]);
            }else {
                array.add(intervals[i]);
            }
        }
        return array.toArray(new int[array.size()][2]);
    }

}


