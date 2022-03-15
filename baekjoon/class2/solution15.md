# 백준 class 2 카드2(2164)

- [문제 링크](https://www.acmicpc.net/problem/2231)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i<=N;i++)
            q.offer(i);

        while(q.size() != 1){
            q.poll(); // 1. 버리기
            q.offer(q.poll()); //2. 바닥으로 넣기
        }

        System.out.println(q.poll());
    }

}

```
