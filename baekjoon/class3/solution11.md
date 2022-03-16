# 백준 class 3 최대힙(11279)

- [문제 링크](https://www.acmicpc.net/problem/11279)

</br>

```java

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i < N; i++){

            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(pq.isEmpty()) bw.write(0+"\n");
                else bw.write(pq.poll()+"\n");
            }
            else
                pq.offer(x);

        }

        bw.flush();
        bw.close();
    }

}

```
