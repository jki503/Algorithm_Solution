# 프로그래머스 LEVEL 3 2022 KAKAO BLIND RECRUITMENT 파괴되지 않은 건물

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92344?language=java)

</br>

```java

class Solution {

    int sum[][];
    int n;
    int m;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        n = board.length;
        m = board[0].length;

        sum = new int[n+1][m+1];

        for(int s[] : skill){

            // 타입
            int type = s[0];

            // 좌표
            int y = s[1];
            int x = s[2];
            int yy = s[3];
            int xx = s[4];

            // 변화량
            int amount = type == 1 ? s[5] * -1 : s[5];

            sum[y][x] += amount;
            sum[yy+1][xx+1] += amount;
            sum[yy+1][x] -= amount;
            sum[y][xx+1] -= amount;

        }

        // 변화량 계산
        calcChange();

        // 파괴되지 않은 건물 체크
        for(int y=0 ; y <n; y++){
            for(int x=0; x<m; x++){
                if(board[y][x] + sum[y][x] >0)
                    answer++;
            }
        }

        return answer;
    }

    // 변화량 누적합 계산
    public void calcChange(){

        // 좌우
        for(int x = 1 ; x < m ; x++){
            for(int y=0; y< n; y++){
                sum[x][y] += sum[x-1][y];
            }
        }

        // 상하
        for(int y=1 ; y < n; y++){
            for(int x=0;x<m; x++){
                sum[x][y] += sum[x][y-1];
            }
        }
    }
}

```
