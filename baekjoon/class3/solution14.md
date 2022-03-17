# 백준 class 3 바이러스(2606)

- [문제 링크](https://www.acmicpc.net/problem/2606)

</br>

```java

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N+1];
        int start = 1;
        int count = 0;

        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            String[] input = br.readLine().split(" ");

            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        q.add(start);
        visited[start] = true;


        while(!q.isEmpty()){

            int curr = q.poll();

            for(int network : graph.get(curr)){

                if(visited[network])
                    continue;

                visited[network] = true;
                q.offer(network);
                count++;

            }
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
    }

}

```
