# 프로그래머스 LEVEL 1 하샤드 수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12947?language=java)

</br>

```java

class Solution {
    public boolean solution(int x) {

        int sum = 0;
        int hass = x;

        while(true){

            if(x == 0)
                break;

            sum += x % 10;
            x/=10;
        }

        if(hass % sum != 0)
            return false;
        else
            return true;
    }
}

```
