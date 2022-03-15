# 백준 class 3 DFS와 BFS(1260)

- [문제 링크](https://www.acmicpc.net/problem/1260)

</br>

```java

import java.io.*;
import java.util.*;

class Main{

    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static StringBuilder sb; // 출력 결과

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        int[][] edges = new int[M][2];

        visited = new boolean[N+1];
        graph = new ArrayList<>(); // graph 정보
        sb = new StringBuilder();

        // graph 설정
        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 문제 조건..?
        for(List<Integer> list : graph){
            Collections.sort(list);
        }

        dfs(start,0,N );
        sb.append("\n");

        visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){

            int curr = q.poll();

            if(visited[curr])
                continue;

            visited[curr] = true;

            sb.append(curr).append(" ");

            for(int node : graph.get(curr))
                q.offer(node);


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int depth, int count) {

        if(visited[idx])
            return;

        visited[idx] = true;
        sb.append(idx).append(" ");

        if(depth == count)
            return;

        for(int node : graph.get(idx))
            dfs(node,depth+1,count);

    }

}

```
