# 프로그래머스 LEVEL 3 섬 연결하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42861?language=java)

</br>

```java

import java.util.Arrays;

class Solution {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (e1,e2) -> e1[2] - e2[2]);

        int[] parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }

        for(int[] c : costs){

            int from = c[0];
            int to = c[1];
            int cost = c[2];

            if(checkCycle(parent,from,to))
                continue;

            answer += cost;

            unionParent(parent,from,to);

        }

        return answer;
    }

    public boolean checkCycle(int[] p , int e1, int e2){

        e1 = getParent(p,e1);
        e2 = getParent(p,e2);

        return e1 == e2 ? true : false;
    }

    public int getParent(int[] p, int e){

        if(p[e] == e) return e;
        return getParent(p,p[e]);
    }

    public void unionParent(int[] p, int e1, int e2){

        e1 = getParent(p,e1);
        e2 = getParent(p,e2);

        if(e1 < e2) p[e2] = e1;
        else p[e1] = e2;
    }
}

```
