# leetcode 240. Search a 2D Matrix II

- [문제 링크](https://leetcode.com/problems/search-a-2d-matrix-ii/)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int y = 0;
        int x = m - 1;

        while(y < n && x >= 0){

            if(target == matrix[y][x]){
                return true;
            }

            if(target > matrix[y][x]){
                y+=1;
            }
            else{
                x-=1;
            }
        }

        return false;
    }
}
```
