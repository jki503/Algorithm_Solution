# 백준 class 3 미로탐색(2178)

- [문제 링크](https://www.acmicpc.net/problem/2178)

</br>

```java

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{

    // 상(0) 우(1) 하(2) 좌(3)
    private static final int[] dirX ={0,1,0,-1};
    private static final int[] dirY ={-1,0,1,0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int result = Integer.MAX_VALUE;

        char[][] map = new char[N][M];
        int[][] dist = new int[N][M];

        for(int i=0;i<N;i++)
            map[i] = br.readLine().toCharArray();

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0,0,1));

        while(!q.isEmpty()){

            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;

            // 유효 블럭인지
            if(y<0 || y>=N || x<0 || x>=M || map[y][x] == '0')
                continue;

            // 최소 비용이 아니면
            if(dist[y][x] != 0 && dist[y][x] <= cost)
                continue;

            dist[y][x] = cost;

            // 도착
            if(x == M-1 && y== N-1)
                continue;

            for(int i=0;i<4;i++)
                q.offer(new Node(x+dirX[i],y+dirY[i],cost+1));

        }

        bw.write(dist[N-1][M-1]+"");
        bw.flush();
        bw.close();
    }

    private static class Node{

        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

```
