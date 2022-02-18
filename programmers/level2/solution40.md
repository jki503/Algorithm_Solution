# 프로그래머스 LEVEL 2 124 나라의 숫자

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12899?language=java)

</br>

```java

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int mod = 0;
        while(n!=0){

            mod = n%3;
            n /= 3;

            switch(mod){
                case 0:
                    n-=1;
                    sb.insert(0,4); break;
                case 1:
                    sb.insert(0,1); break;
                case 2:
                    sb.insert(0,2); break;
                default: break;

            }

        }
        answer = sb.toString();

        return answer;
    }
}

```
