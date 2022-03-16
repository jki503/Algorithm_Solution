# 백준 class 3 절댓값 힙(11286)

- [문제 링크](https://www.acmicpc.net/problem/11286)

</br>

```java

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                int abs1 = o1 < 0 ? -o1 : o1;
                int abs2 = o2 < 0 ? -o2 : o2;

                return abs1 == abs2 ? o1 - o2 : abs1 - abs2;

            }
        });

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
