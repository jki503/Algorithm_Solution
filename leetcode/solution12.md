# leetcode 14. Longest Common Prefix

- [문제 링크](https://leetcode.com/problems/longest-common-prefix/)

</br>

```java

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        String str1 = strs[0];
        String str2 = strs[strs.length-1];

        for(int i=0; i < str1.length(); i++){

            char c = str1.charAt(i);

            if( c == str2.charAt(i))
                sb.append(c);
            else
                break;
        }

        return sb.toString();
    }
}

```
