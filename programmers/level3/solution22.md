# 프로그래머스 LEVEL 3 월간 코드 챌린지 시즌 1 풍선 터트리기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/68646?language=java)

</br>

```java

class Solution {

    // 벌룬 최대 값
    int max = 1000000000;

    public int solution(int[] a) {
        int answer = 0;

        int l = max;
        int r = max;

        int n = a.length;

        for(int i=0;i<n;i++){

            if(l > a[i]){
                l = a[i];
                answer++;
            }

            if(r > a[n-1-i]){
                r = a[n-1-i];
                answer++;
            }

            // 같아지면 탐색 끝
            if(l == r)
                break;
        }

        answer += (l==r) ? -1 : 0;

        return answer;
    }
}

```
