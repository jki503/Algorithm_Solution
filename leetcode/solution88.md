# leetcode 242. Valid Anagram

- [문제 링크](https://leetcode.com/problems/valid-anagram/)

```java
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0 ; i < arr1.length ;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
```
