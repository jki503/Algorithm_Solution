# 프로그래머스 LEVEL 2 전화번호 목록

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42577?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=1 ; i < phone_book.length; i++){

            if(phone_book[i].startsWith(phone_book[i-1])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}

```
