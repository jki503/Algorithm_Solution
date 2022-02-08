# 프로그래머스 LEVEL 3 가장 긴 팰린드롬

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12904?language=java)

</br>

```java

class Solution
{
    public int solution(String s)
    {
        // defalut return
        int answer = 1;

        // 배열 변환
        char[] charArr = s.toCharArray();
        int n = charArr.length;

        // 길이
        for(int len=n; len > 1;len--){


            // idx
            for(int i=0;i+len<=n;i++){
                boolean check = true;

                // 팰린드롬 검사
                for(int j=0;j<len/2;j++){
                    if(charArr[i+j] != charArr[i+len-j-1]){
                        check = false;
                        break;
                    }
                }
                if(check)
                    return len;
            }

        }

        return answer;
    }
}
```
