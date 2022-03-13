# leetcode 73. Set Matrix Zeroes

- [문제 링크](https://leetcode.com/problems/set-matrix-zeroes/)

</br>

```java

import java.util.Set;
import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int y=0; y < m; y++)
            for(int x=0; x < n; x++)
                if(matrix[y][x] == 0){
                    rowSet.add(y);
                    colSet.add(x);
                }

        Iterator<Integer> iter = rowSet.iterator();
        while(iter.hasNext()){
            int row = iter.next();

            for(int x=0; x < n; x++)
                matrix[row][x] = 0;

        }

        iter = colSet.iterator();
        while(iter.hasNext()){
            int col = iter.next();

            for(int y=0; y < m; y++)
                matrix[y][col] = 0;

        }

    }
}


```
