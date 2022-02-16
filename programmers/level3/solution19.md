# 프로그래머스 LEVEL 3 2019 카카오 개발자 겨울 인턴십 징검다리 건너기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/64062?language=java)

</br>

```java

class Solution {

    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = 1;
        int max = 200000000;

        // 친구 수 구하기
        answer = findMaxCnt(min, max, stones, k);

        return answer;
    }

    // 최대 친구 수
    public int findMaxCnt(int start, int end, int[]arr, int k){

        int mid = 0;
        while(start < end){

            mid = (start + end) / 2;

            // 건널 수 있으면
            if(checkValid(arr, k , mid)){
                start = mid + 1;
            }
            else{

                end = mid;
            }
        }

        return start;

    }

    // 건널 수 있는지
    boolean checkValid(int[] arr, int k, int mid){

        int zeroCnt = 0;

        for(int num : arr){

            // 디딤돌이 0 이하면
            if(num - mid <= 0)
                zeroCnt++;
            else
                zeroCnt = 0;

            if(zeroCnt == k)
                return false;
        }

        return true;

    }
}

```
