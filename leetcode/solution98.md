# leetcode 383. Ransom Note

- [문제 링크](https://leetcode.com/problems/ransom-note/)

```java
import java.util.*;

class Solution {
    public boolean canConstruct(String r, String m) {
        int[] rCounts = new int[26];
        int cnt = 0;
        for (char c : r.toCharArray()) {
            rCounts[c - 'a']++;
            if (rCounts[c - 'a'] == 1) cnt++;
        }

        for (char c : m.toCharArray()) {
            rCounts[c - 'a']--;
            if(rCounts[c - 'a'] == 0){
                if(--cnt == 0)
                    return true;
            }
        }

        return cnt == 0;
    }
}

```
