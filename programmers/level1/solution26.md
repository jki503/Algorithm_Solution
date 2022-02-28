# 프로그래머스 LEVEL 1 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17681?language=java)

</br>

```java

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0 ; i < n ; i++){

            // 공백 방지
            answer[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i])))
                .replace("1","#")
                .replace("0"," ");

        }



        return answer;
    }
}

```
