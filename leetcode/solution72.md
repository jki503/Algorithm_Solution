# leetcode 1647. Minimum Deletions to Make Character Frequencies Unique

- [문제 링크](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/)

```java
import java.util.*;

class Solution {

    public int minDeletions(String s) {
        int answer = 0;
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        Arrays.sort(freq);
        Set<Integer> set = new HashSet<>();

        for(int i : freq){
            while(set.contains(i) && i > 0){
                i--;
                answer++;
            }

            set.add(i);
        }

        return answer;
    }
}
```
