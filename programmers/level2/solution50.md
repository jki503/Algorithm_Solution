# 프로그래머스 LEVEL 2 Summer/Winter Coding(~2018) 점프와 순간 이동

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12980?language=java)

</br>

```java
public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n!=0){
            if(n % 2 == 0) n/=2;
            else{
                n= (n-1)/2;
                ans++;
            }
        }

        return ans;
    }
}

```
