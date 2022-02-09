# 프로그래머스 LEVEL 2 2021 Dev-Matching: 웹 백엔드 개발자(상반기) 행렬 테두리 회전하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77485?language=java)

</br>

```java

import java.lang.Math;

class Solution {

    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = {};
        int n = queries.length;
        answer = new int[n];


        // 초기 행렬 세팅
        arr = new int[rows][columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = (i * columns + j + 1);
            }
        }

        for(int i=0;i<n;i++){
            // 회전 후 최소값 넣기
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    /*
        회전 후 최소값 반환
    */
    public int rotate(int[] q){



        // 시작과 끝좌표
        int r = q[0] - 1;
        int c = q[1] - 1;
        int rr = q[2] - 1;
        int cc = q[3] - 1;


        int temp = arr[r][c];
        int min = temp;
        // 상
        for(int i = r ; i < rr ; i++){
            // 밑에 행 원소 올리기
            arr[i][c] = arr[i+1][c];
            min = Math.min(arr[i][c],min);
        }

        // 좌
        for(int i = c ; i < cc ; i++){
            arr[rr][i] = arr[rr][i+1];
            min = Math.min(arr[rr][i],min);
        }

        // 하
        for(int i = rr ; i > r ; i--){
            arr[i][cc] = arr[i-1][cc];
            min = Math.min(arr[i][cc],min);
        }

        // 우
        for(int i = cc ; i > c ; i--){
            arr[r][i] = arr[r][i-1];
            min = Math.min(arr[r][i],min);
        }
        // 초기 원소 밀기
        arr[r][c+1] = temp;

        return min;
    }

}

```
