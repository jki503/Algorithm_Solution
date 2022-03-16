# 백준 class 3 듣보잡(1746)

- [문제 링크](https://www.acmicpc.net/problem/1764)

</br>

```java

import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        List<String> names = new ArrayList<>();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // 듣도 못한사람
        for(int i=0;i<N;i++)
            set.add(br.readLine());

        // 보도 못한 사람
        for(int i=0;i < K;i++){

            String name = br.readLine();

            // 중복 체크
            if(set.contains(name))
                names.add(name);

        }

        // 정렬
        Collections.sort(names);

        bw.write(names.size() + "\n");
        for(String name : names)
            bw.write(name +"\n");

        bw.flush();
        bw.close();
    }

}

```
