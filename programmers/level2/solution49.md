# 프로그래머스 LEVEL 2 땅따먹기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12913?language=java)

</br>

```java

class Solution {

    final int COL = 4;

    int solution(int[][] land) {
        int answer = 0;

        int n = land.length;

        for(int y=1; y < n; y++)
            for(int x=0; x<COL; x++)
                land[y][x] += getMaxPoint(x,land[y-1]);

        answer = getMaxPoint(COL+1, land[n-1]);

        return answer;
    }

    public int getMaxPoint(int c, int[] arr){

        int result = 0;

        for(int x = 0 ; x < COL; x++){

            // 이전 열이면
            if(c == x)
                continue;

            result = Math.max(result, arr[x]);
        }

        return result;
    }
}

```
