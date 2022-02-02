# 프로그래머스 LEVEL 3 2020 KAKAO BLIND RECRUITMENT 블록 이동하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60063?language=java)

</br>

```java

import java.util.*;
import java.lang.Math;

class Solution {

    int [][]board;
    int [][][]timeArr;
    int n;

    //우(0) 하(1) 좌(2) 상(3)
    int dir[][] = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    class Robot{
        int row;
        int col;
        int dir;
        int time;

        Robot(int row, int col, int dir, int time){
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.time = time;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;

        /*
            변수 설정
            n : board 길이
            board : 입력 받은 후 전역 설정
            timeArr : 네 방향의 time 저장
        */
        this.n = board.length;
        this.board = board;
        this.timeArr = new int[n][n][4];

        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(0,0,0,0));

        while(!queue.isEmpty()){
            Robot robot = queue.poll();

            // 첫번째 좌표
            int r = robot.row;
            int c = robot.col;
            int d = robot.dir;

            int t = robot.time;

            // 두번째 좌표 & 역방향
            int rr = r + dir[d][0];
            int cc = c + dir[d][1];
            int dd = (d+2) %4;

            // 방문했으면 continue;
            if(checkVisited(robot))
                continue;

            // time 갱신
            timeArr[r][c][d] = t;
            timeArr[rr][cc][dd] =t;

            // 도착했으면
            if(checkArrived(robot))
                continue;

            // 한 칸 이동
            for(int i=0;i<4;i++){
                int mvR = r + dir[i][0];
                int mvC = c + dir[i][1];

                Robot mvRobot = new Robot(mvR,mvC,d,t+1);

                if(!checkValid(mvRobot))
                    continue;
                queue.offer(mvRobot);

            }

            // 회전 이동
            for(int i=1;i<=3;i+=2){
                int rtD = (d + i) % 4;

                Robot rtRobot1 = new Robot(r,c,rtD,t+1);
                Robot rtRobot2 = new Robot(rr,cc,rtD,t+1);

                // 둘 중에 하나라도 유효한 블락이 아니면
                if(!checkValid(rtRobot1) || !checkValid(rtRobot2))
                    continue;

                queue.offer(rtRobot1);
                queue.offer(rtRobot2);
            }
        }

        for(int i=0;i<4;i++){
            int resultTime = timeArr[n-1][n-1][i];
            if(resultTime == 0)
                continue;

            answer = answer == 0 ? resultTime : Math.min(answer,resultTime);
        }

        return answer;
    }

    // return true : 방문했으면
    public boolean checkVisited(Robot robot){

        int r = robot.row;
        int c = robot.col;
        int d = robot.dir;

        int t = robot.time;

        int rr = r + dir[d][0];
        int cc = c + dir[d][1];
        int dd = (d+2) %4;

        // 방문한 적이 없거나
        if(timeArr[r][c][d] == 0 && timeArr[rr][cc][dd]==0)
            return false;
        // 비용이 최소면
        else if(timeArr[r][c][d] > t && timeArr[rr][cc][dd] > t)
            return false;
        else
            return true;
    }

    // return true : 유효한 블락이면
    public boolean checkValid(Robot robot){
        int r = robot.row;
        int c = robot.col;
        int d = robot.dir;

        int rr = r + dir[d][0];
        int cc = c + dir[d][1];

        if( r>=0 && r<n && c>=0 && c<n
          && rr>=0 && rr<n && cc>=0 && cc<n
          && board[r][c] == 0
          && board[rr][cc] == 0)
            return true;
        else
            return false;

    }

    // return true : 도착했으면
    public boolean checkArrived(Robot robot){

        int r = robot.row;
        int c = robot.col;
        int d = robot.dir;

        int rr = r + dir[d][0];
        int cc = c + dir[d][1];

        if((r==n-1 && c==n-1)
        || (rr==n-1 && cc==n-1))
            return true;

        return false;
    }

}

```
