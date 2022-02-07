# 프로그래머스 LEVEL 2 2017 팁스타운 예상 대진표

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12985?language=java)

</br>

```java

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 위치가 같아지기 전까지
        while(a != b){

            // 위치 갱신
            if(a % 2 == 0)
                a/=2;
            else
                a = (a/2) + 1;

            if(b%2 == 0)
                b /= 2;
            else
                b = (b / 2) + 1;

            // answer 증가
            answer++;
        }

        return answer;
    }


}

```
