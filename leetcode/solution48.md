# leetcode 763. Partition Labels

- [문제 링크](https://leetcode.com/problems/partition-labels/)

</br>

```java

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        int[] idxs = new int[26];

        int n = s.length();
        int start = -1;
        int end = 0;

        for(int i=0; i < n; i++)
            idxs[s.charAt(i) - 'a'] = i; // last index of letters

        for(int i=0; i < n; i++){

            char c = s.charAt(i);

            end = idxs[c-'a'] > end ? idxs[c-'a'] : end;

            if(end == i){
                result.add(end - start);
                start = end;
            }
        }

        return result;
    }
}

```
