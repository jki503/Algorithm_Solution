# 30. Substring with Concatenation of All Words

- [문제 링크](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

```java
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int subLen = words[0].length();
        int wordLen = words.length;
        int len = subLen * wordLen;

        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(int i = 0 ; i < s.length() - len + 1; i++){
            String sub = s.substring(i, i + len);
            if(isSubstring(sub, map, subLen, words)){
                ans.add(i);
            }
        }


        return ans;
    }

    private boolean isSubstring(String sub, Map<String, Integer>map, int subLen, String[] words){
        Map<String, Integer> tempMap = new HashMap<>();

        for(int i = 0 ; i <= sub.length() - subLen; i+= subLen){
            String str = sub.substring(i, i + subLen);
            tempMap.put(str, tempMap.getOrDefault(str, 0) + 1);
        }

        for(String w : words){
            if(!map.get(w).equals(tempMap.get(w))){
                return false;
            }
        }

        return true;
    }

}
```
