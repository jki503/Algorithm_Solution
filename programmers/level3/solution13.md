# 프로그래머스 LEVEL 3 단어 변환

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43163?language=java)

</br>

```java

import java.lang.Math;

class Solution {

    int answer = Integer.MAX_VALUE;

    String targetWord;
    String[] wordsArr;

    boolean[] visited;


    public int solution(String begin, String target, String[] words) {

        targetWord = target;
        wordsArr = words;
        visited = new boolean[wordsArr.length];

        convertWord(0,wordsArr.length,begin);

        return answer;
    }

    public void convertWord(int count, int n, String curr){

        // 탈출 조건 1
        if(curr.equals(targetWord)){
            answer = Math.min(answer,count);
            return;
        }

        // 탈출 조건 2: 모두 탐색했는데도 없을때
        if(count == n){
            answer = 0;
            return;
        }

        for(int i=0;i<wordsArr.length;i++){

            // 방문하지 않으면서 변환 가능할때
            if(!visited[i] && checkValid(curr,wordsArr[i])){
                visited[i] = true;
                convertWord(count+1,n,wordsArr[i]);
                visited[i] =false;
            }

        }

    }

    public boolean checkValid(String s1, String s2){
        int count = 0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;

            // 변환 할 수 없을때
            if(count>1)
                return false;
        }
        return true;
    }
}

```
