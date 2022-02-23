# 프로그래머스 LEVEL 3 2019 카카오 개발자 겨울 인턴십 불량 사용자

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/64064?language=java)

</br>

```java

import java.util.HashSet;
import java.util.Arrays;

class Solution {

    String[] banPattern; // regex
    HashSet<String> banSet; // ban id 목록
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        banSet = new HashSet<>();

        int n = banned_id.length;
        banPattern = new String[n];
        visited = new boolean[user_id.length];

        for(int i=0;i<n;i++)
            banPattern[i] = banned_id[i].replace("*",".");

        // banSet 찾기
        permutate(0,user_id,"");

        answer = banSet.size();

        return answer;
    }

    public void permutate(int cnt, String[] arr, String ids){

        // 순열 중복 체킹
        if(cnt == banPattern.length){

            String[] users = ids.split(" ");
            Arrays.sort(users);

            String banIds = "";
            for(String u : users)
                banIds += u;

            banSet.add(banIds);
            return;
        }

        for(int i=0; i < arr.length; i++){

            // 방문했으면
            if(visited[i])
                continue;

            // 패턴 일치하지 않으면
            if(!arr[i].matches(banPattern[cnt]))
                continue;

            visited[i] = true;
            permutate(cnt+1,arr, ids + " " + arr[i]);
            visited[i] = false;
        }

    }
}

```
