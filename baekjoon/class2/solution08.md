# 백준 class 2 단어 정렬(1181)

- [문제 링크](https://www.acmicpc.net/problem/1181)

</br>

```java

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        // 1. 중복 단어 제거
        for(int i=0;i<N;i++)
            set.add(br.readLine());

        List<String> list = new ArrayList<>(set);

        // 2. 정렬
       Collections.sort(list, (s1,s2)
                         -> s1.length() == s2.length()
                         ? s1.compareTo(s2) : s1.length() - s2.length());

        for(int i=0;i<list.size();i++)
            bw.write(list.get(i) + "\n");

        bw.flush();
        bw.close();

    }

}

```
