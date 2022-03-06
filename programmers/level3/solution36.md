# 프로그래머스 LEVEL 3 정수 삼각형

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43105?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {

        int nRow = triangle.length;

        for(int y = 1; y < nRow; y++){

            int nCol = triangle[y].length;

            for(int x = 0; x < nCol; x++){

                if(x==0)
                    triangle[y][x] += triangle[y-1][x];
                else if(x == nCol-1)
                    triangle[y][x] += triangle[y-1][x-1];
                else
                    triangle[y][x] += Math.max(triangle[y-1][x],triangle[y-1][x-1]);

            }
        }

        return Arrays.stream(triangle[nRow-1]).max().getAsInt();
    }

}

```
