package subset;

import java.util.ArrayList;
import java.util.List;

public class BitSubset {
    public static int[] arr = {1, 2, 3, 4};

    public static void main(String[] args) {
        List<List<Integer>> totalSet = combi(2);

        for (int i = 0; i < totalSet.size(); i++) {
            List<Integer> subset = totalSet.get(i);
            System.out.println(subset);
        }

    }

    // 전체 부분집합 개수
    public static List<List<Integer>> findSubset() {
        // 부분집합 개수
        int n = 1 << arr.length;

        List<List<Integer>> totalSet = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }

            totalSet.add(subset);
        }

        return totalSet;
    }


    //개수 조합
    public static List<List<Integer>> combi(int k){
        List<List<Integer>> totalSet = new ArrayList<>();
        int n = 1<<arr.length;

        for(int i=1;i<=n;i++) {
            int cnt = 0;
            for(int j=0;j<arr.length;j++){
                if( (i & 1<<j) >0)
                    cnt++;
            }
            // 부분집합의 개수
            if(cnt == k){
                List<Integer> subset = new ArrayList<>();
                for(int j=0;j<n;j++){
                    if( (i & 1<<j) >0)
                        subset.add(arr[j]);
                }
                totalSet.add(subset);
            }
        }

        return totalSet;
    }
}
