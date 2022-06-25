# 1354. Construct Target Array With Multiple Sums

- [문제 링크](https://leetcode.com/problems/construct-target-array-with-multiple-sums/)

```java
import java.util.*;

class Solution {

    public boolean isPossible(int[] target) {
        long sum = 0;

        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(long num : target){
            pq.offer(num);
            sum += num;
        }

        while(!pq.isEmpty()){
            long curr = pq.poll();
            if(curr == 1){
                return true;
            }

            sum -= curr;

            if(curr == 1 || sum == 1) // 모든게 1
                return true;

            if(curr < sum) // 현재값을 만들 수 없는 경우
                return false;

            if(sum == 0)
                return false; // 길이가 1인데 값이 1이 아닌 경우 체크

            curr %= sum;

            if(curr == 0)  // 나올 수 없는 값
                return false;

            sum += curr;
            pq.offer(curr);

        }

        return true;

    }
}
```
