# leetcode 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

- [문제 링크](https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/)

```java
import java.util.*;

class Solution {

    private static final int mod = 1000000000 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = getMaxLength(horizontalCuts, h);
        int maxW = getMaxLength(verticalCuts, w);

        return (int)((long)maxH * maxW % mod);
    }

    private int getMaxLength(int[] arr, int length){
        int prev = 0;
        int max = length - arr[arr.length-1];

        for(int curr : arr){
            int currLen = (curr - prev) % mod;
            max = currLen > max ? currLen : max;
            prev = curr;
        }

        return max % mod;
    }
}
```
