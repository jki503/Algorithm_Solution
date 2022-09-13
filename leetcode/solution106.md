# leetcode 948. Bag of Tokens

- [문제 링크](https://leetcode.com/problems/bag-of-tokens/)

```java
import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int start = 0;
        int end = tokens.length - 1;
        Arrays.sort(tokens);

        while(start <= end){
            if(power >= tokens[start]){
                power -= tokens[start++];
                score++;
                continue;
            }

            if(start == end || score == 0){
                break;
            }

            power += tokens[end--];
            score--;
        }

        return score;
    }
}
```
