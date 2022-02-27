# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌 1 3진법 뒤집기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/68935?language=java)

</br>

```java

class Solution {
    public int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        // 3진법 뒤집기
        while(true){

            if(n==0)
                break;
            sb.append(n%3);
            n/=3;
        }

        String num = sb.toString();

        int mulThree = (int)Math.pow(3,num.length()-1);

        for(char c : num.toCharArray()){

            answer+= (c -'0') *mulThree;
            mulThree/=3;
        }

        return answer;
    }
}

```
