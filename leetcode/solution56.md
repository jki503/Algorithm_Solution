# leetcode 1337. The K Weakest Rows in a Matrix

- [문제 링크](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)

</br>

```java

import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Soldiers> pq = new PriorityQueue<>();

        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[k];

        for(int y = 0; y < n; y++){
            int num =0;

            for(int x = 0 ; x < m; x++)
                num+=mat[y][x];

            pq.offer(new Soldiers(y,num));
        }

        for(int i = 0; i < k; i++)
            result[i] = pq.poll().row;

        return result;
    }

    private class Soldiers implements Comparable<Soldiers>{

        int row;
        int num;

        public Soldiers(int row, int num){
            this.row = row;
            this.num = num;
        }

        @Override
        public int compareTo(Soldiers o){

            if(this.num == o.num)
                return this.row - o.row;
            else
                return this.num - o.num;
        }

    }
}

```
