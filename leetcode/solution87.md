# leetcode 315. Count of Smaller Numbers After Self

- [문제 링크](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

```java
import java.util.*;

class Solution {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < nums.length - 1; i++){
            int curr = nums[i];
            int num = 0;

            for(int j = i + 1 ; j < nums.length; j++){
                    if(curr > nums[j]){
                        num++;
                    }
            }
            list.add(num);
        }
        list.add(0);

        return list;
    }
}
```
