# leetcode 3. Longest Substring Without Repeating Characters

- [문제 링크](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

</br>

```java

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> charMap = new HashMap<>();

        int start = 0;
        int end = 0;
        int max = 0;

        int n = s.length();

        while(end < n){

            char cEnd = s.charAt(end);
            charMap.put(cEnd, charMap.getOrDefault(cEnd,0)+1);
            end++;

            if(charMap.get(cEnd) <= 1)
                max = Math.max(end-start,max);


            // remove repeat atom
            while(charMap.get(cEnd) > 1){
                 char cStart = s.charAt(start);

                if(charMap.containsKey(cStart) && charMap.get(cStart) > 0){
                    charMap.put(cStart, charMap.get(cStart) - 1);
                }
                start++;
            }
        }

        return max;

    }
}

```
