# 378. Kth Smallest Element in a Sorted Matrix

- [문제 링크](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

```java
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n*n];

        int i = 0;

        for(int y = 0 ; y < n; y++){
            for(int x= 0 ; x < n; x++){
                arr[i++] = matrix[y][x];
            }
        }

        Arrays.sort(arr);

        return arr[k-1];
    }
}
```
