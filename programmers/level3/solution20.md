# 프로그래머스 LEVEL 3 위클리 챌린지 아이템 줍기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/87694?language=java)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    int SIZE = 51;
    boolean map[][];
    int answer;

    int[][] dir = {
        // 우(0) 상(1) 좌(2) 하(3)
        {0,1},
        {-1,0},
        {0,-1},
        {1,0}
    };

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        answer = Integer.MAX_VALUE;
        Queue<Player> queue = new LinkedList<>();

        // 경로 맵 초기화 - 테두리만 true
        initMap(rectangle);

        // 도착 위치
        int destX = itemX * 2;
        int destY = itemY * 2;

         // 초기 사용자
        queue.offer(new Player(characterX * 2, characterY * 2,0));

        while(!queue.isEmpty()){

            Player curr = queue.poll();
            int y = curr.y;
            int x = curr.x;
            int dist = curr.dist;

            // 갈 수 없는 경로면
            if(!map[y][x]){
                continue;
            }

            map[y][x] = false;

            // 도착 했으면
            if(x == destX  && y == destY){
                answer = Math.min(answer,dist/2);
                continue;
            }

            for(int i = 0 ; i < 4 ; i++){
                int yy = y + dir[i][0];
                int xx = x + dir[i][1];

                //System.out.println(yy + " " + xx);

                queue.offer(new Player(xx,yy,dist+1));

            }

        }

        return answer;

    }

    // 테두리만 true로
    public void initMap(int[][] arr){

        map = new boolean[SIZE*2+1][SIZE*2+1];

        // 직사각형 전체 true;
        for(int[] point : arr){
            int x = point[0]*2;
            int y = point[1]*2;
            int xx = point[2]*2;
            int yy = point[3]*2;

            for(int i = y ; i <= yy; i++){
                for(int j = x ; j <= xx; j++)
                    map[i][j] = true;
            }
        }

        // 직사각형 내부 false;
        for(int[] point : arr){
            int x = point[0]*2;
            int y = point[1]*2;
            int xx = point[2]*2;
            int yy = point[3]*2;

            for(int i = y + 1 ; i < yy; i++){
                for(int j = x +1 ; j < xx; j++)
                    map[i][j] = false;
            }
        }

    }


    class Player{

        int x;
        int y;
        int dist;

        Player(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }
}

```
