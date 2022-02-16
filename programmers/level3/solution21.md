# 프로그래머스 LEVEL 3 N-Queen

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12952?language=java)

</br>

```java

class Solution {

    // 행
    int[] point;
    boolean[] visited;
    int answer;

    public int solution(int n) {
        answer = 0;

        point = new int[n];
        visited = new boolean[n];

        findNqueen(0,n);

        return answer;
    }

    public void findNqueen(int row, int n){

        // Nqueen을 찾을 경우
        if(row == n){
            answer++;
            return;
        }

        for(int i=0;i<n;i++){

            // 미문시
            if(!visited[i]){
                visited[i] = true;
                point[row] = i;
                if(checkValid(row))
                    findNqueen(row + 1 , n);

                visited[i] = false;
            }

        }
    }

    public boolean checkValid(int row){

        for(int i=0; i < row; i++){
            // 같은 열일 경우
            if(point[i] == point[row])
                return false;

            // 대각선일 경우
            if(Math.abs(row - i) == Math.abs(point[row] - point[i]))
               return false;
        }
        return true;
    }
}

```
