# 프로그래머스 LEVEL 2 월간 코드 챌린지 시즌 3 빛의 경로 사이클

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/86052?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {

    // 상(0) 우(1) 하(2) 좌(3)
    private final int[] dirX = {0,1,0,-1};
    private final int[] dirY = {-1,0,1,0};

    private boolean[][][] visited;

    private int nRow;
    private int nCol;

    public int[] solution(String[] grid) {

        List<Integer> cycleList = new ArrayList<>();

        nRow = grid.length;
        nCol = grid[0].length();

        visited = new boolean[nRow][nCol][4];

        for(int y=0; y < nRow ; y++)
            for(int x=0; x < nCol; x++)
                for(int d = 0 ; d < 4; d++){

                    // 사이클 존재하면
                    if(visited[y][x][d])
                        continue;

                    cycleList.add(getCycle(y,x,d,grid));
                }

        // 정렬
        Collections.sort(cycleList);

        int[] answer = new int[cycleList.size()];

        for(int i=0; i < answer.length; i++)
            answer[i] = cycleList.get(i);

        return answer;
    }

    private int getCycle(int y, int x, int d, String[] grid){

        int cycle=0;

        while(true){

            if(visited[y][x][d])
                break;

            visited[y][x][d] = true;
            cycle++;

            // 방향 전환
            if(grid[y].charAt(x) == 'R')
                d = (d+1) % 4;
            else if(grid[y].charAt(x) == 'L')
                d = (d+3) % 4;

            // grid 좌표 갱신
            y = (y + dirY[d] + nRow) % nRow;
            x = (x + dirX[d] + nCol) % nCol;
        }

        return cycle;
    }
}

```
