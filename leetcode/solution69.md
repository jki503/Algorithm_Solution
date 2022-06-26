# leetcode 1423. Maximum Points You Can Obtain from Cards

- [문제 링크](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length - k;

        int result = 0;
        int total = 0;
        int sub = 0;

        for(int num : cardPoints){
            total += num;
        }

        int i = 0;

        while(i < n){
            sub += cardPoints[i];
            i++;
        }

        result = total  - sub;

        while(i < cardPoints.length){
            sub += cardPoints[i] - cardPoints[i-n];
            result = Math.max(result, total - sub);
            i++;
        }

        return result;
    }
}
```
