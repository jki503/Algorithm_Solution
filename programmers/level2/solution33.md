# 프로그래머스 LEVEL 2 2021 카카오 채용연계형 인턴십 거리두기 확인하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/81302?language=java#)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    int[][] dir={
        // 우(0) 상(1) 좌(2) 하(3)

        {0,1},
        {-1,0},
        {0,-1},
        {1,0}
    };

    int SIZE=5;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0;i<places.length;i++){
            answer[i] = findResult(places[i]);
        }

        return answer;
    }


    public int findResult(String[] room){

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(room[i].charAt(j) == 'P'){
                    // 규칙을 지키지 않은 경우
                    if(!checkCorrect(j,i,room)) return 0;
                }

            }
        }
        return 1;
    }

    public boolean checkCorrect(int x, int y, String[] room){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        boolean[][] visited = new boolean[SIZE][SIZE];
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(int i=0;i<4;i++){

                int xx = curr.x + dir[i][1];
                int yy = curr.y + dir[i][0];


                //1. 위치 검사
                if(xx<0 || yy<0 || xx >=SIZE || yy >=SIZE)
                    continue;

                //2. 방문 했거나 거리 충족

                int dist = Math.abs(xx-x) + Math.abs(yy-y);
                if(visited[yy][xx] || dist > 2){
                    continue;
                }

                visited[yy][xx] = true;

                //3. 이동 할 수 있는지
                if(room[yy].charAt(xx) == 'X')
                    continue;
                else if(room[yy].charAt(xx) == 'P')
                    return false;
                else
                    queue.offer(new Node(xx,yy));
            }

        }
        return true;
    }
}

```
