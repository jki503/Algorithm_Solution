# 프로그래머스 LEVEL 2 [찾아라 프로그래밍 마에스터] 게임맵 최단 거리

```java
import java.util.*;
import java.lang.Math;

class Solution {

    //상(0)우(1)하(2)좌(3)
    int dirRow[] = {-1,0,1,0};
    int dirCol[] = {0,1,0,-1};

    class Node{
        public int row;
        public int col;
        public int cost;
        public int dir;

        Node(int row, int col, int cost, int dir){
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.dir = dir;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int [][][]costMap = new int[n][n][4];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,2)); // 우
        queue.offer(new Node(0,0,0,1)); // 하

        while(!queue.isEmpty()){
            //지금을 기준으로
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;
            int cost = node.cost;
            int dir = node.dir;

            // 유효한 위치인지
            if(!validLocation(row,col,n,board)) continue;

            // 방문한 노드인지
            if(validVisited(costMap,row,col,dir,cost)) continue;
            costMap[row][col][dir] = cost;

            //도착했는지
            if(validDestination(row,col,n))
                continue;


            // 코너 방향 선언
            int dir2 = (dir+1)%4;
            int dir3 = (dir+3)%4;


            //직선
            queue.offer(new Node(row+dirRow[dir], col+dirCol[dir],cost+100,dir));

            //코너
            queue.offer(new Node(row+dirRow[dir2], col+dirCol[dir2],cost+500+100,dir2));
            queue.offer(new Node(row+dirRow[dir3], col+dirCol[dir3],cost+500+100,dir3));

        }
        for(int i=0;i<4;i++){
            if(costMap[n-1][n-1][i] != 0)
                if(answer == 0){
                    answer = costMap[n-1][n-1][i];
                }
                else{
                    answer = Math.min(costMap[n-1][n-1][i],answer);
                }

        }

        return answer;
    }


    public boolean validLocation(int row, int col,int n, int[][] board){
        if(row<0 || row >=n
          || col < 0 || col>= n
          || board[row][col] == 1){
            return false;
        }
        else
            return true;
    }

    public boolean validVisited(int[][][] costMap, int row,int col,int dir, int nowCost){
        if(costMap[row][col][dir] == 0) return false;
        else if(costMap[row][col][dir] > nowCost) return false;
        else return true;

    }

    public boolean validDestination(int row, int col, int n){
        if(row == n-1 && col == n-1)
            return true;
        else
            return false;
    }
}

```
