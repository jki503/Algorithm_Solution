# leetcode 11. Container With Most Water

- [문제 링크](https://leetcode.com/problems/container-with-most-water/)

</br>

```java

class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int area = 0;


        while(l < r ){

            int wid = r - l;
            int hei = height[l] < height[r] ? height[l] : height[r];

            area = Math.max(hei*wid, area);

            if(height[l] < height[r])
                l++;
            else
                r--;
        }

        return area;

    }
}

```
