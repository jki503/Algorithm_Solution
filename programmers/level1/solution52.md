# 프로그래머스 LEVEL 1 행렬의 덧셈

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12950?language=java)

</br>

```java

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int n = arr1.length;
        int m = arr1[0].length;

        int[][] answer = new int[n][m];

        for(int y = 0 ; y < n; y++)
            for(int x=0; x < m; x++)
                answer[y][x] = arr1[y][x] + arr2[y][x];


        return answer;
    }
}

```
