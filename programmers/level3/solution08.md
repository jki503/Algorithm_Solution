# 프로그래머스 LEVEL 3 2017 카카오 본선 보행자 천국

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1832?language=java)

</br>

```java

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        // 0 : 하, 1: 우
        int[][][] cntMap = new int[m+1][n+1][2];

        cntMap[1][1][0] = 1;
        cntMap[1][1][1] = 1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(cityMap[i-1][j-1] == 0){
                    // 자유
                    cntMap[i][j][0] += (cntMap[i-1][j][0] + cntMap[i][j-1][1])%MOD;
                    cntMap[i][j][1] += (cntMap[i-1][j][0] + cntMap[i][j-1][1])%MOD;

                }else if(cityMap[i-1][j-1] == 1){
                    // 통행 금지
                    cntMap[i][j][0] = 0;
                    cntMap[i][j][1] = 0;
                }
                else{
                    // 오던 방향대로 직진
                    cntMap[i][j][0] += cntMap[i-1][j][0];
                    cntMap[i][j][1] += cntMap[i][j-1][1];

                }

            }
        }

        answer+= cntMap[m][n][0];

        return answer;
    }
}

```
