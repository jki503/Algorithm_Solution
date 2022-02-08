# 프로그래머스 LEVEL 월간 코드 챌린지 시즌1 3 삼각 달팽이

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/68645?language=java)

</br>

```java

class Solution {

    // 하(0) 우(1) 상(2)
    int[] dirRow = {1,0,-1};
    int[] dirCol = {0,1,-1};
    int[][] arr;

    public int[] solution(int n) {
        int[] answer = {};

        arr = new int[n][n];

        // destination Num
        int N = 0;
        for(int i=1;i<=n;i++){
            N+=i;
        }

        // 초기 좌표 (0,0) 및 방향 하(0)
        int r = 0;
        int c = 0;
        int d = 0;

        // 달팽이 채우기
        for(int i=1;i<=N;i++){
            arr[r][c] = i;

            // 현재 방향대로 가도 되는지
            if(!checkValid(r + dirRow[d], c + dirCol[d], n)){
                // 방향 전환
                d = (d+1) % 3;
            }

            // 좌표 갱신
            r = r + dirRow[d];
            c = c + dirCol[d];
        }

        // 원소 담기
        answer = new int[N];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0)
                    continue;
                answer[idx++] = arr[i][j];
            }

        }
        return answer;
    }

    public boolean checkValid(int r, int c, int n){

        if(r < 0 || r>=n) return false;
        if(c < 0 || c>=n) return false;
        if(arr[r][c] != 0) return false;

        return true;
    }
}

```
