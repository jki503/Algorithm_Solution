# 프로그래머스 LEVEL 2 타겟 넘버

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43165?language=java)

</br>

```java

class Solution {

    int n;
    int answer;
    int[] num;

    public int solution(int[] numbers, int target) {
        answer=0;
        num = numbers;
        n = num.length;

        findTarget(0,0,target);

        return answer;
    }

    /*
        curr : 현재 합
        i : 탐색 위치
    */
    public void findTarget(int curr, int i, int target){
        if(i == n){
            if(curr == target){
                answer++;
            }
            return;
        }

        // +, - 두번 탐색
        findTarget(curr+num[i],i+1,target);
        findTarget(curr-num[i],i+1,target);

    }
}

```
