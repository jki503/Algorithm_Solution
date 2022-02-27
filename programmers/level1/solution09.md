# 프로그래머스 LEVEL 1 Summer/Winter Coding(~2018) 소수 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12977?language=java)

</br>

```java

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int n = nums.length;

        // 3개 수 조합
        for(int i = 0; i < n; i++)
            for(int j = i+1 ; j < n; j++)
                for(int k = j+1 ; k < n; k++)
                    if(checkPrime(nums[i]+ nums[j] + nums[k]))
                        answer++;

        return answer;
    }

    private boolean checkPrime(int num){

        if(num < 2)
            return false;

        for(int i=2;i<=Math.sqrt(num);i++)
            if(num % i == 0)
                return false;

        return true;
    }
}

```
