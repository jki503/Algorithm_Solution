# leetcode 42. Trapping Rain Water

- [문제 링크](https://leetcode.com/problems/trapping-rain-water/)

```java
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        int lMax = 0;
        int rMax = 0;

        while(l <= r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if(lMax < rMax){
                sum += lMax - height[l++];
            }
            else{
                sum += rMax - height[r--];
            }
        }

        return sum;
    }
}
```
