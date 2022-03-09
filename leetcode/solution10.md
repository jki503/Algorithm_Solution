# leetcode 10. Regular Expression Matching

- [문제 링크](https://leetcode.com/problems/regular-expression-matching/)

</br>

```java

import java.util.regex.Pattern;

class Solution {
    public boolean isMatch(String s, String p) {
        return Pattern.matches(p,s);
    }
}

```
