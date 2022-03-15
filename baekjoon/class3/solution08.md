# 백준 class 3 숨바꼭질(1692)

- [문제 링크](https://www.acmicpc.net/problem/1697)

</br>

```java

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int result = 0;

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int size = 100000 +1;


        Queue<Subin> q = new LinkedList<>();
        int[] dist = new int[size];

        q.offer(new Subin(N,0));

        while(!q.isEmpty()){

            Subin curr = q.poll();
            int idx = curr.idx;
            int cost = curr.cost;

            // 유효 범위인지
            if(idx<0 || idx>=size)
                continue;

            // 최소 거리인지
            if(dist[idx] != 0 && dist[idx] <= cost)
                continue;

            dist[idx] = cost;

            // 도착하면
            if(idx == K)
                continue;

            q.offer(new Subin(idx-1,cost+1));
            q.offer(new Subin(idx+1,cost+1));
            q.offer(new Subin(idx*2,cost+1));
        }


        bw.write(dist[K]+"");
        bw.flush();
        bw.close();
    }

    private static class Subin{

        int idx;
        int cost;

        public Subin(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

}

```
