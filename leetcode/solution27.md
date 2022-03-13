# leetcode 338. Counting Bits

- [문제 링크](https://leetcode.com/problems/counting-bits/)

</br>

```java

class Solution {
    public int[] countBits(int n) {

        /*
        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++)
            ans[i] = Integer.toBinaryString(i).replace("0","").length();

        return ans;
        */

        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++){
            ans[i] = ans[i/2];
            if(i%2==1)
                ans[i]++;
        }

        return ans;
    }
}

```
