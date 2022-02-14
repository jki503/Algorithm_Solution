# 프로그래머스 LEVEL 2 2017 카카오코드 예선 카카오프렌즈 컬러링북

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1829?language=java)

</br>

```java

class Solution {

    int numberOfArea;
    int maxSizeOfOneArea;
    boolean[][] visited;
    int[][] dir = {
        //우(0) 상(1) 좌(2) 하(3)
        {0,1},
        {-1,0},
        {0,-1},
        {1,0}
    };

    int tmpSize=0;


    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea=0;
        visited = new boolean[m][n];

        int[] answer = new int[2];


        for(int y = 0 ; y < m ; y++){
            for(int x = 0 ; x < n; x++){

                // 0이면
                if(picture[y][x] == 0)
                    continue;

                // 이미 방문 했으면
                if(visited[y][x])
                    continue;

                System.out.println(y + " " + x);

                // 영역 갱신
                numberOfArea++;
                searchArea(y,x,picture, picture[y][x]);

                // 최대 사이즈 갱신
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpSize);

                // tmpsize 초기화
                tmpSize=0;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public void searchArea(int y, int x, int[][] map, int color){

        // 유효하지 않으면
        if(y<0 || x<0 || y>=map.length || x>=map[0].length)
            return;

        // 방문 했으면
        if(visited[y][x])
            return;

        // 색깔이 다르면
        if(map[y][x] != color)
            return;

        visited[y][x] = true;
        tmpSize++;

        for(int i=0;i<4;i++){
            int yy = y + dir[i][0];
            int xx = x + dir[i][1];

            searchArea(yy,xx,map,color);
        }
    }

}

```
