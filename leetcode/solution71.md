# leetcode 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

- [문제 링크](https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/)

```java
import java.util.Arrays;

class Solution {
    public int minPartitions(String n) {
        char[] arr = n.toCharArray();

        Arrays.sort(arr);

        return arr[arr.length-1] - '0';
    }
}
```
