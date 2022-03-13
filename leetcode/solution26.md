# leetcode 74. Search a 2D Matrix

- [문제 링크](https://leetcode.com/problems/search-a-2d-matrix/)

</br>

```java

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        for(int y=0; y < n; y++){

            int start = 0;
            int end = m-1;

            while(start <= end){

                int mid = (start + end) / 2;

                if(matrix[y][mid] == target)
                    return true;
                else if(matrix[y][mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }

        return false;
    }
}

```
