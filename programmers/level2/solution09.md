# 프로그래머스 LEVEL 2 소수 찾기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42839?language=java)

</br>

```java

import java.util.HashSet;

class Solution {

    /*
        numArr : 형변환으로부터 자유
        set : 중복되는 숫자 제거
        visited : dfs로 순열 탐색

        checkPrime후 set에 추가
        set은 소수가 들어간 집합임으로
        answer는 set의 size
    */
    String[] numArr;
    HashSet<Integer> set;
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        // 배열로
        numArr = numbers.split("");
        int len = numArr.length;

        set = new HashSet<>();
        visited = new boolean[len];

        // 탐색 시작
        permute("",0,len);

        answer = set.size();

        return answer;
    }

    public void permute(String curr, int count,int len){

        // 탈출 조건
        if(count == len){
            // 소수 판별
            int currNum = Integer.parseInt(curr);

            if(checkPrime(currNum))
                set.add(currNum);

            return;
        }

        for(int i=0;i<numArr.length;i++){
            if(!visited[i]){

                // 0으로 시작하면 continue;
                if(curr.equals("") && numArr[i].equals("0"))
                    continue;

                visited[i] = true;

                //순열 갱신
                String next = curr + numArr[i];
                int nextNum = Integer.parseInt(next);

                // 소수 체크
                if(checkPrime(nextNum))
                    set.add(nextNum);

                // 갱신한 문자열로 탐색
                permute(next, count+1, len);

                visited[i] = false;

            }
        }

    }

    public boolean checkPrime(int num){
        if(num <2)
            return false;

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}

```
