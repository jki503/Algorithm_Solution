# leetcode 2007. Find Original Array From Doubled Array

- [문제 링크](https://leetcode.com/problems/find-original-array-from-doubled-array/)

```java
import java.util.*;

class Solution {

    private static final int MAX_ELEMENT = 100000;

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0){
            return new int[0];
        }
        Arrays.sort(changed);
        int[] cnt = new int[MAX_ELEMENT + 1];
        for(int c : changed){
            cnt[c]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int c : changed){
            if(cnt[c] > 0){
                cnt[c]--;
                list.add(c);
                if(c * 2 > MAX_ELEMENT){
                    return new int[0];
                }
                cnt[c * 2]--;
                if(cnt[c * 2] < 0){
                    return new int[0];
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```
