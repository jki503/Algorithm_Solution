# 프로그래머스 N개의 최소 공배수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12953?language=java)

</br>

```java

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        for(int i=0;i<arr.length;i++){
            answer = answer * arr[i] / getGCD(answer, arr[i]);
        }

        return answer;
    }


    public int getGCD(int n1, int n2){

        int temp = 1;
        while(n1!=0){

            temp = n1;
            n1 = n2 % n1;
            n2 = temp;
        }

        return n2;
    }
}

```
