# 프로그래머스 LEVEL 1 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17681?language=java)

</br>

```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0 ; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toBinaryString(arr1[i] | arr2[i])
                .replaceAll("1", "#")
                .replaceAll("0", " "));

            while(sb.length() != n){
                sb.insert(0, " ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
```
