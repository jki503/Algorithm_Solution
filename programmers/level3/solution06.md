# 프로그래머스 LEVEL 3 등굣길

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42898?language=java)

</br>

```java

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];

        for(int[] puddle : puddles){
            int r = puddle[1];
            int c = puddle[0];

            map[r][c] = -1;
        }

        // start
        map[1][1]=1;

        for(int i=1; i<=n;i++){
            for(int j=1;j<=m;j++){

                // 불능 지역이면 continue;
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }

                map[i][j]+= (map[i-1][j] + map[i][j-1]) % 1000000007;
            }
        }
        answer = map[n][m];

        return answer;
    }
}

```
