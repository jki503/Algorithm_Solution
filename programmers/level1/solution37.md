# 프로그래머스 LEVEL 1 수박수박수박수박수박수?

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12922?language=java)

</br>

```java

class Solution {

    final char[] subak = {'수','박'};

    public String solution(int n) {

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++)
            sb.append(subak[i%2]);

        return sb.toString();
    }
}

```
