# 프로그래머스 LEVEL 1 서울에서 김서방 찾기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12919?language=java)

</br>

```java

class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";

        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                answer += i + "에 있다";
                break;
            }
        }


        return answer;
    }
}

```
