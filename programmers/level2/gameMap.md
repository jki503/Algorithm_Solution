# 프로그래머스 LEVEL 2 [찾아라 프로그래밍 마에스터] 게임맵 최단 거리

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1844)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    //user 객체
    class User{
        int row;
        int col;
        int cost;

        User(int row, int col,int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    //상우하좌
    int[] dirRow = {-1,0,1,0};
    int[] dirCol = {0,1,0,-1};


    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] costMap = new int[n][m];

        Queue<User> queue = new LinkedList<>();
        queue.offer(new User(0,0,1));

        while(!queue.isEmpty()){
            User user = queue.poll();
            int row = user.row;
            int col = user.col;
            int cost = user.cost;

            //유효하지 않은 블록인지
            if(invalidBlock(row,col,n,m,maps))
                continue;

            //cost가 가장 낮은지
            if(costMap[row][col]>0 && costMap[row][col] <= cost)
                continue;
            costMap[row][col] = cost;

            //도착 했는지
            if(row == n-1 && col == m-1)
                continue;

            // push the next block
            for(int i = 0 ; i < 4; i++){
                queue.offer(new User(row+dirRow[i],col+dirCol[i],cost+1));
            }

        }
        answer = costMap[n-1][m-1] == 0 ? -1 : costMap[n-1][m-1];

        return answer;
    }

    // return true is next user
    public boolean invalidBlock(int row,int col, int n, int m, int[][] maps){

        if(row < 0 || row >= n
          || col <0 || col >= m
          || maps[row][col] == 0){
            return true;
        }else
            return false;
    }

}

```
