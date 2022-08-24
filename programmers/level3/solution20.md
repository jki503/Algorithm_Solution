# 프로그래머스 LEVEL 3 위클리 챌린지 아이템 줍기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/87694?language=java)

</br>

```java
import java.util.*;

class Solution {
    private static final int SIZE = 101;
    // 상(0) 우(1) 하(2) 좌(3)
    private final int[] dx = {0,1,0,-1};
    private final int[] dy = {-1,0,1,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        boolean[][] map = new boolean[SIZE + 1][SIZE + 1];
        setMap(map, rectangle);

        int startX = characterX * 2;
        int startY = characterY * 2;
        int destX = itemX * 2;
        int destY = itemY * 2;

        Queue<Player> q = new ArrayDeque<>();
        q.offer(new Player(startX, startY, 0));

        while(!q.isEmpty()){
            Player curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            int distance = curr.distance;

            if(!map[y][x]){
                continue;
            }

            map[y][x] = false;

            if(x == destX && y == destY){
                answer = Math.min(answer, distance/2);
                continue;
            }

            for(int i = 0 ; i < 4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                q.offer(new Player(xx, yy, distance + 1));
            }

        }

        return answer;
    }

    public void setMap(boolean[][] map, int[][] arr){

        for(int[] point : arr){
            int x = point[0] * 2;
            int y = point[1] * 2;
            int xx = point[2] * 2;
            int yy = point[3] * 2;

            for(int i = y ; i<= yy; i++){
                for(int j = x ; j<= xx; j++){
                    map[i][j] = true;
                }
            }
        }

        for(int[] point : arr){
            int x = point[0] * 2;
            int y = point[1] * 2;
            int xx = point[2] * 2;
            int yy = point[3] * 2;

            for(int i = y + 1 ; i< yy; i++){
                for(int j = x + 1 ; j< xx; j++){
                    map[i][j] = false;
                }
            }
        }
    }

    class Player{
        int x;
        int y;
        int distance;

        public Player(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
```
