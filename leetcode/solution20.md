# leetcode 179. Largest Number

- [문제 링크](https://leetcode.com/problems/largest-number/)

</br>

```java
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];

        for(int i = 0 ; i < nums.length ; i++)
            strs[i] = nums[i] +"";

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2) );

        StringBuilder sb = new StringBuilder();

        for(String s : strs)
            sb.append(s);

        if(sb.charAt(0) == '0')
            return "0";

        return sb.toString();
    }
}

```
